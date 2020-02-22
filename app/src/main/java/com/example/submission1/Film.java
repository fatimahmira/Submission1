package com.example.submission1;

import android.os.Parcel;
import android.os.Parcelable;

public class Film implements Parcelable {
    private int id;
    private String judul;
    private String poster;
    private String tahun;
    private String genre;
    private String detail;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private Film(Parcel in) {
        id = in.readInt();
        judul = in.readString();
        poster = in.readString();
        tahun = in.readString();
        genre = in.readString();
        detail = in.readString();
    }

    public static final Creator<Film> CREATOR = new Creator<Film>() {
        @Override
        public Film createFromParcel(Parcel in) {
            return new Film(in);
        }

        @Override
        public Film[] newArray(int size) {
            return new Film[size];
        }
    };

    public Film() {

    }

    public Film(int id, String judul, String poster, String tahun, String genre, String detail) {
        this.id = id;
        this.judul = judul;
        this.poster = poster;
        this.tahun = tahun;
        this.genre = genre;
        this.detail = detail;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getTahun() {
        return tahun;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(judul);
        parcel.writeString(poster);
        parcel.writeString(tahun);
        parcel.writeString(genre);
        parcel.writeString(detail);
    }

}
