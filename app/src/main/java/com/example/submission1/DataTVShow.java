package com.example.submission1;

import android.net.Uri;

import java.util.ArrayList;

 class DataTVShow {
     private static String [][] tvshow = new String[][]{
            //gbr, judul, thn, genre, detail
            {DataTVShow.getDrawable(R.drawable.poster_dragon_ball), "Dragon Ball", "1986 - 1989", "153 Episodes",
                    "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the mystical Dragon Balls brought her to Goku\\'\\s home. Together, they set off to find all seven and to grant her wish."
            },
            {DataTVShow.getDrawable(R.drawable.poster_fairytail), "Fairy Tail", "2009 - 2019", "51 Episodes",
                    "Lucy is a 17 years old girl, who wants to be a full\\-\\fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn\\'\\t just any ordinary kid, he\\'\\s a member of one of the world\\'\\s most infamous mage guilds: Fairy Tail."
            },
            {DataTVShow.getDrawable(R.drawable.poster_family_guy), "Family Guy", "1999", "9 Episodes",
                    "Sick, twisted, politically incorrect and Freakin Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he\\'\\s not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues."
            },
            {DataTVShow.getDrawable(R.drawable.poster_grey_anatomy), "Grey\\'\\s Anatomy", "2005", "9 Episodes",
                    "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital."
            },
            {DataTVShow.getDrawable(R.drawable.poster_ncis), "NCIS", "2003", "11 Episodes",
                    "From murder and espionage to terrorism and stolen submarines, a team of special agents investigates any crime that has a shred of evidence connected to Navy and Marine Corps personnel, regardless of rank or position."
            },
            {DataTVShow.getDrawable(R.drawable.poster_riverdale), "Riverdale", "2017", "11 Episodes",
                    "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade."
            },
            {DataTVShow.getDrawable(R.drawable.poster_supergirl), "Super Girl", "2015", "9 Episodes",
                    "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism."
            },
            {DataTVShow.getDrawable(R.drawable.poster_supernatural), "Supernatural", "2005", "8 Episodes",
                    "When they were boys, Sam and Dean Winchester lost their mother to a mysterious and demonic supernatural force. Subsequently, their father raised them to be soldiers. He taught them about the paranormal evil that lives in the dark corners and on the back roads of America ... and he taught them how to kill it. Now, the Winchester brothers crisscross the country in their \\'\\67 Chevy Impala, battling every kind of supernatural threat they encounter along the way. "
            },
            {DataTVShow.getDrawable(R.drawable.poster_the_simpson), "The Simpson", "1989", "10 Episodes",
                    "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general."
            },
            {DataTVShow.getDrawable(R.drawable.poster_the_umbrella), "The Umbrella", "2019", "10 Episodes",
                    "A dysfunctional family of superheroes comes together to solve the mystery of their father\\'\\s death, the threat of the apocalypse and more."
            },
            {DataTVShow.getDrawable(R.drawable.poster_the_walking_dead), "The Walking Dead", "2010", "9 Episodes",
                    "Sheriff\\'\\s deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way."
            }

    };

    private static String getDrawable(int resourceId){
        return Uri.parse("android.resource://"+R.class.getPackage().getName() + "/" + resourceId).toString();
    }

    public static ArrayList<Film> getListData(){
        ArrayList<Film> list = new ArrayList<>();
        for (String[] film : tvshow){
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
