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


//        MovieAdapter mv = new MovieAdapter();
        RVMovie = rootView.findViewById(R.id.rv_movie);
        progressBar = rootView.findViewById(R.id.progressBarmovies);
        RVMovie.setHasFixedSize(true);

        RVMovie.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL, false));
        movieAdapter = new MovieAdapter();
        movieAdapter.notifyDataSetChanged();
        RVMovie.setAdapter(movieAdapter);
        movieAdapter.setOnItemKlik(new MovieAdapter.onItemKlik()

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
}
