package Week10.Playlist;

import java.util.ArrayList;

public class Start {
    public static void main(String[] args){
        ArrayList<Song> playlist = new ArrayList<>();
        playlist.add(new Song("S1", "A1", "Rock"));
        playlist.add(new Song("S2", "A2", "Pop"));
        playlist.add(new Song("S3", "A3", "Rock"));

        GenreFilterIterator genreFilterIterator = new GenreFilterIterator(playlist, "Rock");

        while (genreFilterIterator.hasNext()){
            Song song = genreFilterIterator.next();
            System.out.println("Title : " + song.getTitle() +
                    ", Artist: " + song.getArtist() +
                    ", Genre: " + song.getGenre());
        }
    }
}