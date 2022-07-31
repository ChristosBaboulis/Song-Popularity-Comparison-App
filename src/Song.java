
public class Song implements Comparable<Song>{
	private int id, likes;
	private String title;
	
	public Song() {}

	public Song(int id, int likes, String title) {
		this.id = id;
		this.likes = likes;
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String toString() {
		return "Song [id=" + id + ", likes=" + likes + ", title=" + title + "]\n";
	}

	public int compareTo(Song otherSong) {
		int i = 0;
		int names = title.compareTo(otherSong.title);
		if (likes > otherSong.likes) i++;
		if (likes < otherSong.likes) i--;
		if(i==0 && names > 0)i--;
		if(i==0 && names < 0)i++;
		return i;
	}
	
	public int compareDF(Song song) {
		int i;
		i = likes - song.likes;
		
		return i;
	}
}
