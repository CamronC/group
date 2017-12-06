package all;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JOptionPane;


/**
 * This is the Player Class
 * It provides the functionality of keeping track of all the users
 * Objects of this class is updated and written in the Game's Data Files after every Game
 *
 */
public class Player implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String name;
	private Integer gamesplayed;
	private Integer gameswon;
	
	//Constructor
	public Player(String name)
	{
		this.name = name.trim();
		//this.lname = lname.trim();
		gamesplayed = new Integer(0);
		gameswon = new Integer(0);
	}
	
	//Name Getter
	public String name()
	{
		return name;
	}
	
	//Returns the number of games played
	public Integer gamesplayed()
	{
		return gamesplayed;
	}
	
	//Returns the number of games won
	public Integer gameswon()
	{
		return gameswon;
	}
	
	//Calculates the win percentage of the player
	public Integer winpercent()
	{
		return new Integer((gameswon*100)/gamesplayed);
	}
	
	//Increments the number of games played
	public void updateGamesPlayed()
	{
		gamesplayed++;
	}
	
	//Increments the number of games won
	public void updateGamesWon()
	{
		gameswon++;
	}
}