package Is_A;

import java.util.ArrayList;
import java.util.Scanner;

public class Album extends Music {
	
	private int releasedYear;
	

	public Album() {
       
    }
	
	public Album(String title, String artist, double duration, String genre, int releasedYear) {
		super(title, artist, duration, genre);
		this.releasedYear = releasedYear;
	}
	
	public int getReleasedYear() {
		return releasedYear;
	}

	public void setReleasedYear(int releasedYear) {
		this.releasedYear = releasedYear;
	}
	
	@Override
	public double calculateSize() {
		// TODO Auto-generated method stub
		
		return this.getDuration()*2.5;
	}


	@Override
	public String toString() {
		return super.toString()+"Album \nReleased Year=" + releasedYear +"\n";
	}

	@Override
	public int compare(Music o1, Music o2) {
		// TODO Auto-generated method stub
		return o2.getTitle().compareTo(o1.getTitle());
	}
	
	
	
}

