package com.example.submission1;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class TVShowFragment extends Fragment {
    private static final String EXTRA_FILM = "film" ;
//    private static final String EXTRA_TAHUN = "" ;
//    private static final String EXTRA_GENRE = "" ;
//    private static final String EXTRA_DETAIL = "" ;

    private RecyclerView RVTVShow;
    private ListAdapter listAdapter;

    private TextView JudulFilm, TahunFilm, GenreFilm, DetailnyaFilm;
    private ImageView GambarFilm;
    private ArrayList<Film> l = new ArrayList<>();//membuat arraybaru

    public TVShowFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_tvshow, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RVTVShow = view.findViewById(R.id.recyclerview);
        RVTVShow.setHasFixedSize(true);
        RVTVShow.setLayoutManager(new LinearLayoutManager(view.getContext()));

        JudulFilm = view.findViewById(R.id.judul_film);
        TahunFilm = view.findViewById(R.id.tahun_film);
        GenreFilm = view.findViewById(R.id.genre_film);
        GambarFilm = view.findViewById(R.id.gbr_film);
        DetailnyaFilm = view.findViewById(R.id.sinopsis_detail);

        l.addAll(DataTVShow.getListData());
        tampilkanlist(view);

    }

    private void tampilkanlist(View view) {
        ListAdapter adapter = new ListAdapter( l);
        RVTVShow.setAdapter(adapter);
        adapter.setOnItemKlik(new ListAdapter.onItemKlik() {
            @Override
            public void onItemClicked(Film film) {
                showDetail(film);
            }
        });
    }

    private void showDetail(Film film) {
        Intent i = new Intent(TVShowFragment.this.getContext(),DetailFilm.class);

        Film film1 = new Film();
        film1.setPoster(film.getPoster());
        film1.setJudul(film.getJudul());
        film1.setTahun(film.getTahun());
        film1.setGenre(film.getGenre());
        film1.setDetail(film.getDetail());
        i.putExtra(DetailFilm.EXTRA_FILM,film1);

        startActivity(i);
    }
}
