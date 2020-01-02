package com.example.submission1;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment {

    private MovieAdapter movieAdapter;
    private RecyclerView RVMovie;
    private ProgressBar progressBar;
    private MainViewModel mainViewModel;
    private ArrayList<Film> l = new ArrayList<>();//membuat arraybaru


    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int id = 15;

        mainViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(MainViewModel.class);
        mainViewModel.setMovie(id);

        mainViewModel.getMovie().observe(this, new Observer<ArrayList<Film>>() {
            @Override
            public void onChanged(ArrayList<Film> films) {
                if (films != null){
                    movieAdapter.setData(films);
                    showLoading(false);
                }
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_movie, container, false);

        RVMovie = rootView.findViewById(R.id.rv_movie);
        progressBar = rootView.findViewById(R.id.progressBarmovies);
        RVMovie.setHasFixedSize(true);

        RVMovie.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL, false));
        movieAdapter = new MovieAdapter();
        movieAdapter.notifyDataSetChanged();
        RVMovie.setAdapter(movieAdapter);

        return rootView;

    }

    private void showLoading(Boolean state) {
        if (state) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
    
    private void showDetail(Film film) {
        Intent i = new Intent(MovieFragment.this.getActivity(),DetailFilm.class);

        Film film1 = new Film();
        film1.setJudul(film.getJudul());
        film1.setPoster(film.getPoster());
        film1.setTahun(film.getTahun());
        film1.setGenre(film.getGenre());
        film1.setDetail(film.getDetail());
        i.putExtra(DetailFilm.EXTRA_FILM,film1);

        startActivity(i);
    }

//    private class GetMovie extends AsyncTask<Void, Void, Void> {
//
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//            // Showing progress dialog
//            pDialog = new ProgressDialog(getActivity());
//            pDialog.setMessage("Please wait...");
//            pDialog.setCancelable(false);
//            pDialog.show();
//        }
//
//        protected Void doInBackground(Void... arg0) {
//            HttpHandler sh = new HttpHandler();
//
//            // Making a request to url and getting response
//            String jsonStr = sh.makeServiceCall(url);
//
//            Log.e(TAG, "Response from url: " + jsonStr);
//
//            if (jsonStr != null) {
//                try {
//                    JSONObject jsonObj = new JSONObject(jsonStr);
//
//                    // Getting JSON Array node
//                    JSONArray movie = jsonObj.getJSONArray("movie");
//
//                    // looping through All Contacts
//                    for (int i = 0; i < movie.length(); i++) {
//                        JSONObject c = movie.getJSONObject(i);
//
//                        String poster = c.getString("poster");
//                        String judul = c.getString("judul");
//                        String tahun = c.getString("tahun");
//                        String genre = c.getString("genre");
//                        String detail = c.getString("detail");
//
//                        // Phone node is JSON Object
////                        JSONObject phone = c.getJSONObject("phone");
////                        String mobile = phone.getString("mobile");
////                        String home = phone.getString("home");
////                        String office = phone.getString("office");
//
//                        // tmp hash map for single contact
//                        HashMap<String, String> moovie = new HashMap<>();
//
//                        // adding each child node to HashMap key => value
//                        moovie.put("poster", poster);
//                        moovie.put("judul", judul);
//                        moovie.put("tahun", tahun);
//                        moovie.put("genre", genre);
//                        moovie.put("detail", detail);
//
//                        // adding contact to contact list
//                        movieList.add(moovie);
//                    }
//                } catch (final JSONException e) {
//                    Log.e(TAG, "Json parsing error: " + e.getMessage());
//                    getActivity().runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            Toast.makeText(getContext(),"Json Parsing error: "+ e.getMessage(),
//                                    Toast.LENGTH_LONG).show();
//                        }
//                    });
//                }
//            } else {
//                Log.e(TAG, "Couldn't get json from server.");
//                getActivity().runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        Toast.makeText(getContext(),
//                                "Couldn't get json from server. Check LogCat for possible errors!",
//                                Toast.LENGTH_LONG)
//                                .show();
//                    }
//                });
//
//            }
//
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(Void result) {
//            super.onPostExecute(result);
//            // Dismiss the progress dialog
//            if (pDialog.isShowing())
//                pDialog.dismiss();
//            /**
//             * Updating parsed JSON data into ListView
//             * */
//            ListAdapter adapter = new ListAdapter(
//                    getActivity(), movieList,
//                    R.layout.list_film, new String[]{"judul", "tahun", "genre"},
//                    new int[]{R.id.judul_film, R.id.tahun_film, R.id.genre_film});
//
//            RVMovie.setAdapter(adapter);
//        }
//
//
//    }

}
