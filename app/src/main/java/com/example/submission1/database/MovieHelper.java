package com.example.submission1.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.submission1.Film;

import java.util.ArrayList;

import static android.provider.BaseColumns._ID;
import static com.example.submission1.database.DatabaseContract.MovieColumns.GENRE;
import static com.example.submission1.database.DatabaseContract.MovieColumns.JUDUL;
import static com.example.submission1.database.DatabaseContract.MovieColumns.POSTER;
import static com.example.submission1.database.DatabaseContract.MovieColumns.SINOPSIS;
import static com.example.submission1.database.DatabaseContract.MovieColumns.TABLE_NAME;
import static com.example.submission1.database.DatabaseContract.MovieColumns.TABLE_NAME2;
import static com.example.submission1.database.DatabaseContract.MovieColumns.TAHUN;

public class MovieHelper {
    private static final String DATABASE_TABLE = TABLE_NAME;
    private static final String DATABASE_TABLE2 = TABLE_NAME2;
    private static DatabaseHelper dataBaseHelper;
    private static MovieHelper INSTANCE;

    private static SQLiteDatabase database;

    private MovieHelper(Context context) {
        dataBaseHelper = new DatabaseHelper(context);
    }

    public static MovieHelper getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (SQLiteOpenHelper.class) {
                if (INSTANCE == null) {
                    INSTANCE = new MovieHelper(context);
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

    public ArrayList<Film> getFavMovie() {
        ArrayList<Film> arrayList = new ArrayList<>();
        Cursor cursor= database.query(DATABASE_TABLE,
                null,
                null,
                null,
                null,
                null,
                _ID + " DESC");
        cursor.moveToFirst();
        Film film = new Film();
        if (cursor.getCount() > 0) {
            do {
                film.setId(cursor.getInt(cursor.getColumnIndexOrThrow(_ID)));
                film.setJudul(cursor.getString(cursor.getColumnIndexOrThrow(JUDUL)));
                film.setTahun(cursor.getString(cursor.getColumnIndexOrThrow(TAHUN)));
                film.setDetail(cursor.getString(cursor.getColumnIndexOrThrow(SINOPSIS)));
                film.setGenre(cursor.getString(cursor.getColumnIndexOrThrow(GENRE)));
                film.setPoster(cursor.getString(cursor.getColumnIndexOrThrow(POSTER)));
                arrayList.add(film);
                cursor.moveToNext();
            } while (!cursor.isAfterLast());
        }
        cursor.close();
        return arrayList;
    }

    public boolean isExistMovie(Film movie) {
        database = dataBaseHelper.getReadableDatabase();
        String QUERY = "SELECT * FROM " + TABLE_NAME + " WHERE " + _ID + "=" + movie.getId();

        Cursor cursor = database.rawQuery(QUERY, null);
        if (cursor.getCount() <= 0) {
            cursor.close();
            return false;
        }
        cursor.close();
        return true;
    }

    public long insertFavoriteMovie(Film movie) {
        ContentValues args = new ContentValues();
        args.put(_ID, movie.getId());
        args.put(JUDUL, movie.getJudul());
        args.put(TAHUN, movie.getTahun());
        args.put(GENRE, movie.getGenre());
        args.put(SINOPSIS, movie.getDetail());
        args.put(POSTER, movie.getPoster());
        return database.insert(DATABASE_TABLE, null, args);
    }

    public int deleteFavoriteMovie (int id) {
        return database.delete(TABLE_NAME, _ID + " = '" + id + "'", null);
    }

    public ArrayList<Film> getFavTV() {
        ArrayList<Film> arrayList = new ArrayList<>();
        Cursor cursor= database.query(DATABASE_TABLE2,
                null,
                null,
                null,
                null,
                null,
                _ID + " DESC");
        cursor.moveToFirst();
        Film film = new Film();
        if (cursor.getCount() > 0) {
            do {
                film.setId(cursor.getInt(cursor.getColumnIndexOrThrow(_ID)));
                film.setJudul(cursor.getString(cursor.getColumnIndexOrThrow(JUDUL)));
                film.setTahun(cursor.getString(cursor.getColumnIndexOrThrow(TAHUN)));
                film.setDetail(cursor.getString(cursor.getColumnIndexOrThrow(SINOPSIS)));
                film.setGenre(cursor.getString(cursor.getColumnIndexOrThrow(GENRE)));
                film.setPoster(cursor.getString(cursor.getColumnIndexOrThrow(POSTER)));
                arrayList.add(film);
                cursor.moveToNext();
            } while (!cursor.isAfterLast());
        }
        cursor.close();
        return arrayList;
    }

    public boolean isExistTV(Film movie) {
        database = dataBaseHelper.getReadableDatabase();
        String QUERY = "SELECT * FROM " + TABLE_NAME2 + " WHERE " + _ID + "=" + movie.getId();

        Cursor cursor = database.rawQuery(QUERY, null);
        if (cursor.getCount() <= 0) {
            cursor.close();
            return false;
        }
        cursor.close();
        return true;
    }

    public long insertFavoriteTV(Film movie) {
        ContentValues args = new ContentValues();
        args.put(_ID, movie.getId());
        args.put(JUDUL, movie.getJudul());
        args.put(TAHUN, movie.getTahun());
        args.put(GENRE, movie.getGenre());
        args.put(SINOPSIS, movie.getDetail());
        args.put(POSTER, movie.getPoster());
        return database.insert(DATABASE_TABLE2, null, args);
    }

    public int deleteFavorite(int id) {
        return database.delete(TABLE_NAME2, _ID + " = '" + id + "'", null);
    }

}
