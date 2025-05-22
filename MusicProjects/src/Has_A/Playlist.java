package Has_A;

import java.util.ArrayList;
import java.util.Scanner;

import Is_A.Music;

public class Playlist {

	private String name;
	
	public ArrayList<Music> arrMus = new ArrayList<>();
	
	public Playlist () {
		
	}
	
	
	public Playlist(String name) {
		this.name=name;
	}
	
	
	
	public void addTracksForPlaylist(Music music) {
		arrMus.add(music);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String displayPlaylist() {
		String out = "Playlist Name : "+ this.name + "\n";
		for(int i = 0 ; i<arrMus.size(); i++) {
			Music m1 = arrMus.get(i);
			out += m1.toString();
		}
		return out;
	}
	
	
}

