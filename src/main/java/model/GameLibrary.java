/**
 * @author Christopher Pohlman - cmpolhman
 * CIS175 - Spring 2022
 * Feb 24, 2022
 */
package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class GameLibrary {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	@OneToMany(mappedBy = "gameLibrary", fetch=FetchType.EAGER, cascade=CascadeType.MERGE)
	private List<VideoGame> videoGames;
	
	
	/**
	 * 
	 */
	public GameLibrary() {
		super();
	}
	
	
	/**
	 * @param id
	 * @param name
	 * @param videoGames
	 */
	public GameLibrary(int id, String name, List<VideoGame> videoGames) {
		super();
		this.id = id;
		this.name = name;
		this.videoGames = videoGames;
	}

	
	/**
	 * @param name
	 */
	public GameLibrary(String name) {
		super();
		this.name = name;
	}


	/**
	 * @param name
	 * @param videoGames
	 */
	public GameLibrary(String name, List<VideoGame> videoGames) {
		super();
		this.name = name;
		this.videoGames = videoGames;
	}


	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the videoGames
	 */
	public List<VideoGame> getVideoGames() {
		return videoGames;
	}
	/**
	 * @param videoGames the videoGames to set
	 */
	public void setVideoGames(List<VideoGame> videoGames) {
		this.videoGames = videoGames;
	}
	@Override
	public String toString() {
		return "GameLibrary [id=" + id + ", name=" + name + ", videoGames=" + videoGames + "]";
	}
	
	
	
	
	
}
