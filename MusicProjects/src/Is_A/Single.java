package Is_A;

import java.util.Scanner;

public class Single extends Music{
	
	private String theme;
	
	public Single() {
      
    }

	public Single(String title, String artist, double duration, String genre, String theme) {
		super(title, artist, duration, genre);
		// TODO Auto-generated constructor stub
		this.theme=theme;
	}
	
	

	public String getTheme() {
		return theme;
	}



	public void setTheme(String theme) {
		this.theme = theme;
	}
	
	@Override
	public String toString() {
		
		return super.toString() + "\ntheme=" + theme + "\nSize= " + calculateSize() +"\n\n";
	}

	@Override
	public double calculateSize() {
		// TODO Auto-generated method stub
		return this.getDuration()*2.3;
	}

	@Override
	public int compare(Music o1, Music o2) {
		// TODO Auto-generated method stub
		return o2.getTitle().compareTo(o1.getTitle());
	}
	
	

}
