package com.example.submission1.database;

import android.net.Uri;
import android.provider.BaseColumns;

public class DatabaseContract {
        // Authority yang digunakan
        private static final String AUTHORITY = "com.example.submission1.database";
        private static final String SCHEME = "content";

    static String TABLE_FAV = "fav";
    static String TABLE_FAV2 = "fav2";

        /*
        Penggunaan Base Columns akan memudahkan dalam penggunaan suatu table
        Untuk id yang autoincrement sudah default ada di dalam kelas BaseColumns dengan nama field _ID
         */
        public static final class MovieColumns implements BaseColumns {
            // Note table name
            static final String TABLE_NAME = "movie";

            // Note title
            public static final String JUDUL = "title";
            public static final String POSTER = "poster";
            public static final String SINOPSIS = "sinop";
            public static final String GENRE = "genre";
            public static final String TAHUN = "date";

            // Base content yang digunakan untuk akses content provider
            public static final Uri CONTENT_URI = new Uri.Builder().scheme(SCHEME)
                    .authority(AUTHORITY)
                    .appendPath(TABLE_NAME)
                    .build();

        }
    }

