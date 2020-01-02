package com.example.submission1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.HashMap;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListHolder> {

    private ArrayList<Film> list_tvshow;
    private onItemKlik onItemKlik;

    ListAdapter(ArrayList<Film> l) {
        this.list_tvshow = l;
    }

    public ListAdapter(FragmentActivity activity, ArrayList<HashMap<String, String>> movieList, int list_film, String[] strings, int[] ints) {
    }


    void setOnItemKlik(onItemKlik onItemKlik) {
        this.onItemKlik = onItemKlik;
    }

    @NonNull
    @Override
    public ListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_film, parent, false);
        return new ListHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull final ListHolder holder, int position) {
        Film k = list_tvshow.get(position);

        Glide.with(holder.itemView.getContext())
                .load(k.getPoster())
                .into(holder.GambarFilm);
        holder.JudulFilm.setText(k.getJudul());
        holder.GenreFilm.setText(k.getGenre());
        holder.TahunFilm.setText(k.getTahun());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemKlik.onItemClicked(list_tvshow.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list_tvshow.size();
    }

    class ListHolder extends RecyclerView.ViewHolder {
        TextView JudulFilm;
         TextView TahunFilm;
         TextView GenreFilm;
        ImageView GambarFilm;

        ListHolder(@NonNull View itemView) {
            super(itemView);

            JudulFilm = itemView.findViewById(R.id.judul_film);
            TahunFilm = itemView.findViewById(R.id.tahun_film);
            GenreFilm = itemView.findViewById(R.id.genre_film);
            GambarFilm = itemView.findViewById(R.id.gbr_film);
        }
    }
    public interface onItemKlik{
       void onItemClicked(Film film);
    }
}
