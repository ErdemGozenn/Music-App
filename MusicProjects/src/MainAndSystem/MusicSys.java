package MainAndSystem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import Has_A.Playlist;
import Is_A.Album;
import Is_A.Music;
import Is_A.Single;

public class MusicSys {
	//public static ArrayList<Music> allTracks = new ArrayList<>();
	//private static ArrayList<Music> allTracks = new ArrayList<>();
	private static HashSet<Music> allTracks = new HashSet<Music>();
	//private static ArrayList<Single> allSingle = new ArrayList<>();
	public static Playlist p1 = new Playlist();
	
	public static double totalSize = 0;
	
	
	
	
	

	
	
	public static void addTracks(String musicType, String title, String artist, double duration, String genre,  int releasedYear, String  theme) {
		if(musicType.equalsIgnoreCase("Single")) {
			 allTracks.add(new Single(title, artist, duration, genre, theme));
		}
		else {
			 allTracks.add(new Album(title, artist, duration, genre, releasedYear));
		}
	}

	
	
	public static String displayTracks() {
			String out="";
			TreeSet<Music> ts = new TreeSet<Music>();
			ts.addAll(allTracks);
			for(Music m: ts) {
				out += m.toString() + "\n";
			}
			
			return out;
		}
	
    public static Set<Music> getSeries() {
 
        return allTracks;
    }

	
	public static Music searchMusic(String title) {
		//With the iterator
        Iterator<Music> i = allTracks.iterator();
        while (i.hasNext()) {
            Music g = i.next();
            if (g.getTitle().equalsIgnoreCase(title)) {
                return g;
            }
        }
        //With for loop
        /*
        for (Series s : seriesSet) {
            if (s.getId() == id) {
                return s;
            }
        }*/

        return null;
	}


	public static void deleteMusic(String title) {
		Iterator<Music> iterator = allTracks.iterator();
	    while (iterator.hasNext()) {
	        Music s = iterator.next();
	        if (s.getTitle().equalsIgnoreCase(title)) {
	            iterator.remove();
	        }
	    }
				
	}
		

	
	public static boolean addPlaylist(	String ckTitle,String artist, double duration, String genre, String theme) {
		Scanner sc  = new Scanner(System.in);
		
			
			Single s1 = new Single();
				  System.out.println("Enter title: ");
					if(checkMusicForPlaylist(ckTitle)) {
						return false;
					}
				s1.setTitle(ckTitle);
				s1.setArtist(artist);
				s1.setDuration(duration);
				s1.setGenre(genre);
				s1.setTheme(theme);
				p1.addTracksForPlaylist(s1);
				return true;

	}
	
	public static boolean checkMusicForPlaylist(String title) {
		Music m = null;
		for(int i = 0 ; i<p1.arrMus.size(); i++) {
			m=p1.arrMus.get(i);
			if(m.getTitle().equalsIgnoreCase(title))
				return true;
		}
		return false;
	}
	
	public static String displayPlaylist() {
		return p1.displayPlaylist();
	}
	
	public static double calculatePlaylistSize() {
		double totalSize = 0;
		for(int i = 0; i<p1.arrMus.size(); i++) {
			Music m1 = p1.arrMus.get(i);
			totalSize += m1.calculateSize();
		}
		
		return totalSize;
	}
	

	
	
	
	public static double calculateDurationForPlaylist() {
		double totalDuration = 0;
		for(int i = 0 ; i<p1.arrMus.size(); i++)
		{
			Music m1 = p1.arrMus.get(i);
			totalDuration += m1.getDuration();
		}
		
		return totalDuration;
	}
	
	public static double calculateAlbumSize() {
	    double total = 0;
	    for (Music track : allTracks) {
	        if (track instanceof Album) {
	            total += track.calculateSize();
	        }
	    }
	    return total;
	}

	
	public static int getNumOfMusic() {
		return Music.getNumOfMusic();
	}
	
	
}
