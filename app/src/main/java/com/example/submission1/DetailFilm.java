package com.example.submission1;

import android.content.ContentValues;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.submission1.database.MovieHelper;

import static com.example.submission1.database.DatabaseContract.MovieColumns.GENRE;
import static com.example.submission1.database.DatabaseContract.MovieColumns.JUDUL;
import static com.example.submission1.database.DatabaseContract.MovieColumns.POSTER;
import static com.example.submission1.database.DatabaseContract.MovieColumns.SINOPSIS;
import static com.example.submission1.database.DatabaseContract.MovieColumns.TAHUN;


public class DetailFilm extends AppCompatActivity {
    public static String EXTRA_FILM = "film";
    
    TextView judul, sinopsis, genre, tahun;
    ImageView poster;
    Button fav;
    MovieHelper movieHelper;
    Film movie;


    public static final String EXTRA_NOTE = "extra_note";
    public static final String EXTRA_POSITION = "extra_position";
    public static final int REQUEST_ADD = 100;
    public static final int REQUEST_UPDATE = 200;
    private final int ALERT_DIALOG_CLOSE = 10;
    private final int ALERT_DIALOG_DELETE = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_film);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setId();
    }

    private void setId() {
        judul = findViewById(R.id.judul_detail);
        poster = findViewById(R.id.poster_detail);
        sinopsis = findViewById(R.id.sinopsis_detail);
        genre = findViewById(R.id.genre_detail);
        tahun = findViewById(R.id.tahun_detail);
        fav = findViewById(R.id.btnfav);

        movieHelper = MovieHelper.getInstance(getApplicationContext());
        movieHelper.open();
//        fav.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ContentValues values = new ContentValues();
//                values.put(JUDUL, String.valueOf(judul));
//                values.put(POSTER, String.valueOf(poster));
//                values.put(SINOPSIS, String.valueOf(sinopsis));
//                values.put(GENRE, String.valueOf(genre));
//                values.put(TAHUN, String.valueOf(tahun));
//                movieHelper.insertFavoriteMovie(values);
//                Toast.makeText(DetailFilm.this, "berhasil di favoritkan", Toast.LENGTH_SHORT).show();
//            }
//        });

        Film film = getIntent().getParcelableExtra(EXTRA_FILM);
        assert film != null;
        Glide.with(this).load(film.getPoster())
                .apply(new RequestOptions().centerCrop())
                .into(poster);
        judul.setText(film.getJudul());
        tahun.setText(film.getTahun());
        genre.setText(film.getGenre());
        sinopsis.setText(film.getDetail());

        movieHelper = MovieHelper.getInstance(getApplicationContext());
        movieHelper.open();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        if (movieHelper.isExistMovie(movie)) {
            getMenuInflater().inflate(R.menu.menu_already_favorite, menu);
        } else {
            getMenuInflater().inflate(R.menu.menu_add_favorite, menu);
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_add_favorite) {
            if (!movieHelper.isExistMovie(movie)) {
                long result = movieHelper.insertFavoriteMovie(movie);
                if (result > 0) {
                    item.setIcon(R.drawable.ic_star_clicked);
                    Toast.makeText(DetailFilm.this, "success_add_favorite", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(DetailFilm.this, "failed__add_favorite", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(DetailFilm.this, "favorite_is_exist", Toast.LENGTH_SHORT).show();
            }
        } else {
            if (item.getItemId() == R.id.action_delete_favorite) {
                int result = movieHelper.deleteFavorite(movie.getId());
                if (result > 0) {
                    item.setIcon(R.drawable.ic_star);
                    Toast.makeText(DetailFilm.this, "success_delete_favorite", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(DetailFilm.this, "failed__delete_favorite", Toast.LENGTH_SHORT).show();
                }
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
