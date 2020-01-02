package com.example.submission1;

import android.net.Uri;

import java.util.ArrayList;

class DataMovie {
    private static String [][] movie = new String[][]{
            //gbr, judul, thn, genre, detail
            {DataMovie.getDrawable(R.drawable.poster_a_star), "A Star is Born", "1986 - 1989", "Romantic",
                    "Seorang bintang musik country yang karirnya mulai memudar, Jackson Maine menemukan sebuah talenta yang sangat berbakat di dalam diri dari seorang musisi muda bernama Ally. Maine berhasil mengorbitkan Ally menjadi seorang bintang muda yang menjanjikan. Namun keduanya terlibat hubungan yang lebih jauh dari sekedar mentor dan anak didik. Seiring dengan meroketnya karir dari Ally dan dirinya, Maine mengalami dilema mengenai masalah ini."
            },
            {DataMovie.getDrawable(R.drawable.poster_aquaman), "Aquaman", "2009 - 2019", "Petualangan, Aksi, Fantasi",
                    "Film ini mengungkap asal-usul Arthur Curry, manusia perkasa yang bisa mengendalikan air dan hewan laut. Dari mana ia mendapatkan kekuatannya? Siapa orang tuanya, dan pantaskah dia menjadi seorang raja di 7 samudera?"
            },
            {DataMovie.getDrawable(R.drawable.poster_birdbox), "Bird Box", "1999", "Post-Apocalyptic",
                    "Bird Box yang menceritakan tentang teror misterius kepada penduduk dunia yang mengakibatkan bunuh diri masal. Setelah menyerang Siberia dan menyebar ke berbagai belahan Eropa, kejadian misterius itu akhirnya menyerang warga Amerika."
            },
            {DataMovie.getDrawable(R.drawable.poster_bohemian), "Bohemian Rhapsody", "1999", "Aksi Fiksi Ilmiah",
                    "Sebuah film biografi tahun 2018 tentang grup band rock Inggris, Queen. Film ini menceritakan tentang kehidupan penyanyi Freddie Mercury, yang berujung pada penampilan Queen pada konser Live Aid di Stadion Wembley pada tahun 1985."
            },
            {DataMovie.getDrawable(R.drawable.poster_bumblebee), "Bumblebee", "1999", "Laga, Drama, Olahraga",
                    "Berlangsung 20 tahun sebelum peristiwa film pertama, yang akan menjadi tahun 1987, Bumblebee berlindung di sebuah tempat barang rongsokan pantai California kecil. Seorang gadis remaja bernama Charlie Watson belajar bahwa itu bukan Volkswagen Beetle biasa."
            },
            {DataMovie.getDrawable(R.drawable.poster_creed), "Creed II", "1999", "Thriller, Aksi, Distopia, Fiksi Ilmiah",
                    "Di tempat lain, Adonis sedang memulai babak baru dalam hidupnya. Ia sudah memiliki segalanya. Gelar tinju kelas berat dunia sudah disandangnya. Orang-orang di Amerika mengeluk-elukannya. Namun, di sebuah makan malam yang awalnya romantis bersama Bianca , mendadak Adonis memiliki raut wajah yang berbeda. Ia bertemu dengan sosok yang membuatnya memendam kepedihan dalam di masa lalu."
            },
            {DataMovie.getDrawable(R.drawable.poster_maze_runner), "Maze Runner", "1999", "Aksi, Fiksi Ilmiah",
                    "Thomas (Dylan O\\'\\Brien) beserta sekelompok Glader memulai sebuah misi untuk menemukan sebuah obat yang disebut \\\"\\flare\\\"\\. Namun untuk dapat mencapai tujuan itu, mereka harus masuk ke Last City dan berhadapan langsung dengan WCKD yang dapat mengontrol labirin mematikan."
            },
            {DataMovie.getDrawable(R.drawable.poster_robinhood), "Robin Hood", "1999", "Aksi, Petualangan",
                    "Robin Hood (Taron Egerton) sebagai tentara salib kembali ke negerinya dalam keadaan yang berbeda. Ia menemukan pejabat korup dan menghabiskan uang kerajaan sementara rakyat dalam keadaan sengsara. Bersama Little John (Jamie Foxx) Ia melawan tirani Inggris yang sangat kuat."
            },
            {DataMovie.getDrawable(R.drawable.poster_thegirl), "The Girl in the Spiders Web", "1999", "Drama, Crime, Thriller",
                    "The Girl in the Spider\\'\\s Web akan berkisah tentang seorang peretas komputer muda Lisbeth Salander (Claire Foy) dan jurnalis Mikael Blomkvist (Sverrir Gudnason) menemukan diri mereka terperangkap dalam jaringan mata-mata, penjahat dunia maya, dan pejabat pemerintah yang korup."
            },
            {DataMovie.getDrawable(R.drawable.poster_themule), "The Mule", "1999", "Drama, Crime, Thriller",
                    "Seorang ahli hortikultura berusia 90 tahun dan veteran Perang Korea tertangkap mengangkut kokain senilai $ 3 juta melalui Illinois untuk kartel narkoba Meksiko."
            }


    };

    private static String getDrawable(int resourceId){
        return Uri.parse("android.resource://"+R.class.getPackage().getName() + "/" + resourceId).toString();
    }

    public static ArrayList<Film> getListData(){
        ArrayList<Film> list = new ArrayList<>();
        for (String[] film : movie){
            Film k = new Film();
            k.setPoster(film[0]);
            k.setJudul(film[1]);
            k.setTahun(film[2]);
            k.setGenre(film[3]);
            k.setDetail(film[4]);
            list.add(k);
        }
        return list;
    }
}
