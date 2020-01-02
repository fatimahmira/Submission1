package com.example.submission1;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;
import retrofit2.http.Tag;

public class MainViewModel extends ViewModel {
    private static final String API_KEY = "a636b5aee9e03575b71445739bd0c9ad";
    private MutableLiveData<ArrayList<Film>> listMovie = new MutableLiveData<>();


    void setMovie(final int id){
        AsyncHttpClient client = new AsyncHttpClient();
        final ArrayList<Film> listItems = new ArrayList<>();
        String url = "https://api.themoviedb.org/3/movie/"+id+"/lists?api_key="+API_KEY+"&language=en-US&page=1";

        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    String result = new String(responseBody);
                    JSONObject responseObject = new JSONObject(result);
                    JSONArray list = responseObject.getJSONArray("results");

                    for (int i = 0; i < list.length(); i++) {
                        JSONObject movie = list.getJSONObject(i);
                        Film movieItems = new Film();
//                        movieItems.setPoster(movie.getString("poster"));
                        movieItems.setId(movie.getInt("id"));
                        movieItems.setJudul(movie.getString("name"));
                        movieItems.setTahun(movie.getString("iso_639_1"));
                        movieItems.setGenre(movie.getString("list_type"));
                        movieItems.setDetail(movie.getString("description"));

                        listItems.add(movieItems);
                    }
                    listMovie.postValue(listItems);
                } catch (Exception e) {
                    Log.d("Exception", e.getMessage());
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.d("onFailure",error.getMessage());
            }
        });

    }

    LiveData<ArrayList<Film>> getMovie(){
        return listMovie;
    }

}
