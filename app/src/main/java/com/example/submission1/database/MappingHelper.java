package com.example.submission1.database;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.core.content.ContextCompat;

import com.example.submission1.Film;

import java.util.ArrayList;

import static com.example.submission1.database.DatabaseContract.TABLE_FAV;
import static com.example.submission1.database.DatabaseContract.TABLE_FAV2;

public class MappingHelper {
    private static final String DATABASE_TABLE = TABLE_FAV;
    private static final String DATABASE_TABLE2 = TABLE_FAV2;
    private static DatabaseHelper dataBaseHelper;
    private static MappingHelper INSTANCE;
    private static SQLiteDatabase database;

    public MappingHelper(Context context) {
        dataBaseHelper = new DatabaseHelper(context);
    }

    public static MappingHelper getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (SQLiteOpenHelper.class) {
                if (INSTANCE == null) {
                    INSTANCE = new MappingHelper(context);
                }
            }
        }
        return INSTANCE;
    }

    public void open() throws SQLException {

        database = dataBaseHelper.getWritableDatabase();
    }

    public void close() {
        dataBaseHelper.close();
        if (database.isOpen())
            database.close();
    }

    public static ArrayList<Film> mapCursorToArrayList(Cursor moviesCursor) {
        ArrayList<Film> movieList = new ArrayList<>();

        while (moviesCursor.moveToNext()) {
            int id = moviesCursor.getInt(moviesCursor.getColumnIndexOrThrow(DatabaseContract.MovieColumns._ID));
            String judul    = moviesCursor.getString(moviesCursor.getColumnIndexOrThrow(DatabaseContract.MovieColumns.JUDUL));
            String poster   = moviesCursor.getString(moviesCursor.getColumnIndexOrThrow(DatabaseContract.MovieColumns.POSTER));
            String genre    = moviesCursor.getString(moviesCursor.getColumnIndexOrThrow(DatabaseContract.MovieColumns.GENRE));
            String sinopsis = moviesCursor.getString(moviesCursor.getColumnIndexOrThrow(DatabaseContract.MovieColumns.SINOPSIS));
            String tahun    = moviesCursor.getString(moviesCursor.getColumnIndexOrThrow(DatabaseContract.MovieColumns.TAHUN));
            movieList.add(new Film(id, judul, poster, tahun, genre, sinopsis));
        }

        return movieList;
    }

    public static Film mapCursorToObject(Cursor moviesCursor) {
        moviesCursor.moveToFirst();
        int id          = moviesCursor.getInt(moviesCursor.getColumnIndexOrThrow(DatabaseContract.MovieColumns._ID));
        String judul    = moviesCursor.getString(moviesCursor.getColumnIndexOrThrow(DatabaseContract.MovieColumns.JUDUL));
        String poster   = moviesCursor.getString(moviesCursor.getColumnIndexOrThrow(DatabaseContract.MovieColumns.POSTER));
        String genre    = moviesCursor.getString(moviesCursor.getColumnIndexOrThrow(DatabaseContract.MovieColumns.GENRE));
        String sinopsis = moviesCursor.getString(moviesCursor.getColumnIndexOrThrow(DatabaseContract.MovieColumns.SINOPSIS));
        String tahun    = moviesCursor.getString(moviesCursor.getColumnIndexOrThrow(DatabaseContract.MovieColumns.TAHUN));

        return (new Film(id, judul, poster, tahun, genre, sinopsis));
    }
}


