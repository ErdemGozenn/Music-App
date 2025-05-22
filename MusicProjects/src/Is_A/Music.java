package Is_A;

import java.util.Comparator;
import java.util.Scanner;

import Interface.Instrument;

public abstract class Music implements Instrument,Comparator<Music>{
	
	private String title;
	private String artist;
	private	double duration;
	private String genre;
	private static int numOfMusic = 0;

	
	public Music() {
		numOfMusic++;
    }
	
	public Music(String title,String artist,double duration,String genre){
		this();
		this.title = title;
		this.artist = artist;
		this.duration = duration;
		this.genre = genre;
		
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}


	public static int getNumOfMusic() {
		return numOfMusic;
	}
	
	
	public static void setNumOfMusic(int numOfMusic) {
		Music.numOfMusic = numOfMusic;
	}

	
	public abstract double calculateSize();

	@Override
	public String toString() {
		return "\n"
				+ "\ntitle=" + title + "\nartist=" + artist + "\nduration=" + duration + "\ngenre=" + genre +  "\nMain Insturment: "+ mainInsturment()+ "\n\n";
	}
		
	public boolean findMusic(String title) {
		if(this.title.equals(title))
			return true;
		else 
			return false;
	}
	
	@Override
	public String mainInsturment() {
		// TODO Auto-generated method stub
		if(getGenre().equalsIgnoreCase("akustic"))
			return "Akustic Guitar";
		else if (getGenre().equalsIgnoreCase("pop"))
			return "Saxophone";
		else if (getGenre().equalsIgnoreCase("rock"))
			return "Electro Guitar";
		else if(getGenre().equalsIgnoreCase("classic"))
			return "Violin";
		else
			return "Rhythm";
		
	}
}
