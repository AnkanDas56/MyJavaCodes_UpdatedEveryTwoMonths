import java.util.*;

import static java.lang.System.out;

import java.lang.classfile.AnnotationValue;
import java.util.Comparator;

class Song {
    @Override
    public String toString() {
        return title + " by " + artist;

    }

    private String title;
    private String artist;

    public Song(String TitleString, String ArtistString) {
        this.title = TitleString;
        this.artist = ArtistString;
    }

    public Song() {
    }

    public String getTitle() {
        return this.title;
    }

    public String getArtist() {
        return this.artist;
    }


    public static void main(String[] args) {
        Song s = new Song("Papaoutai", "Unjaps");
        ArrayList<Song> SongsList = s.getSongs();
        System.out.println("Enter your choice of sorting (Options : Artist , Title)");
        Scanner sc = new Scanner(System.in);
        String wantings = sc.nextLine();

        if ("Artist".equals(wantings)) {
            SongsList.sort(new ArtistComparator());
        } else if ("Title".equals(wantings)) {
            SongsList.sort((one, two) -> one.getTitle().compareTo(two.getTitle()));
        }
        out.println(SongsList);
    }

    private ArrayList<Song> getSongs() {
        ArrayList<Song> SongsList = new ArrayList<>();
        SongsList.add(new Song("Another Love ", "Tom Odell"));
        SongsList.add(new Song("Why You Are ", "Pop"));
        SongsList.add(new Song("Hello Cassidy ", "Cav$"));
        SongsList.add(new Song("Havana", "BillPop"));
        SongsList.add(new Song("Die With A smile", "God64$"));
        SongsList.add(new Song("Aaavan Jaavan", "Jim"));
        SongsList.add(0, new Song("West meets East", "Jared"));
        return SongsList;
    }
}

class ArtistComparator implements Comparator<Song> {
    @Override
    public int compare(Song s1, Song s2) {
        return s1.getArtist().compareTo(s2.getArtist());
    }
}

class TitleComparator implements Comparator<Song> {
    @Override
    public int compare(Song s1, Song s2) {
        return s1.getTitle().compareTo(s2.getTitle());
    }
}
