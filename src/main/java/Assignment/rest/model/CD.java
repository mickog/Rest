package Assignment.rest.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CD {
	
	private String id;
	private String title;
	private int duration;
	private String artistName;
	
	public String getArtistName() {
		return artistName;
	}
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String desc) {
		this.title = desc;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
    @Override
    public String toString() {
        return "CD [id=" + id + ", artistName=" + artistName
                + ", title =" + title + ", duration=" + duration + "]";
    }   
}
