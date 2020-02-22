package com.example.submission1.fragment;


import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.submission1.Film;
import com.example.submission1.MainViewModelMovie;
import com.example.submission1.MovieAdapter;
import com.example.submission1.R;
import com.example.submission1.database.MovieHelper;

import java.util.ArrayList;

import static android.provider.BaseColumns._ID;
import static com.example.submission1.database.DatabaseContract.MovieColumns.GENRE;
import static com.example.submission1.database.DatabaseContract.MovieColumns.JUDUL;
import static com.example.submission1.database.DatabaseContract.MovieColumns.POSTER;
import static com.example.submission1.database.DatabaseContract.MovieColumns.SINOPSIS;
import static com.example.submission1.database.DatabaseContract.MovieColumns.TAHUN;


/**
 * A simple {@link Fragment} subclass.
 */
public class FavFragment extends Fragment {
    public static final String KEY_MOVIES = "movies";
    public ArrayList<Film> listMovies = new ArrayList<>();
    public RecyclerView rvfav;
    private MainViewModelMovie mainViewModelMovie;
    private MovieAdapter movieAdapter;
    private MovieHelper movieHelper;
    private Bundle bundle;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mainViewModelMovie = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(MainViewModelMovie.class);

    }

    public FavFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvfav = view.findViewById(R.id.rv_fav_movie);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fav, container, false);
    }

    @Override
    public void onStart() {
        rvfav.setLayoutManager(new LinearLayoutManager(getContext()));
        rvfav.setHasFixedSize(true);
        movieHelper = MovieHelper.getInstance(getContext());
        movieHelper.open();
        Cursor cursor = movieHelper.queryAll();

        rvfav.setAdapter(movieAdapter);

        if (bundle == null){
            listMovies.clear();
            cursor.moveToFirst();
            Film film = new Film();
            if (cursor.getCount() > 0){
                do {
                    film.setId(cursor.getInt(cursor.getColumnIndexOrThrow(_ID)));
                    film.setJudul(cursor.getString(cursor.getColumnIndexOrThrow(JUDUL)));
                    film.setTahun(cursor.getString(cursor.getColumnIndexOrThrow(TAHUN)));
                    film.setDetail(cursor.getString(cursor.getColumnIndexOrThrow(SINOPSIS)));
                    film.setGenre(cursor.getString(cursor.getColumnIndexOrThrow(GENRE)));
                    film.setPoster(cursor.getString(cursor.getColumnIndexOrThrow(POSTER)));
                    listMovies.add(film);
                    cursor.moveToNext();
                } while (!cursor.isAfterLast());

//                if (listMovies != null){
//                    movieAdapter.setData(listMovies);
//                } else {
//                    Toast.makeText(getContext(), "Tidak ada favorit", Toast.LENGTH_SHORT).show();
//                }
            } else {
                ArrayList<Film> list = bundle.getParcelableArrayList(KEY_MOVIES);
                if (list != null){
                    movieAdapter.setData(list);
                }

            }
            cursor.close();
        }
        super.onStart();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        movieHelper.close();
    }
}
