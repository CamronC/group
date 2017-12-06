package all;

import java.util.ArrayList;

public class Pawn extends Chesspiece{
	String name="Pawn";
	boolean moved=false;
	public Pawn(int x,int y, char col) {
		xpos=x;
		ypos=y;
		color=col;
	}
	public ArrayList<coordinates> Move() {
		ArrayList<coordinates> set=new ArrayList<coordinates>();
		if(!moved) {
			if(color=='w')
				set.add(new coordinates(xpos,ypos+2));
			else
				set.add(new coordinates(xpos,ypos-2));
		}
		if(color=='w')
			set.add(new coordinates(xpos,ypos+1));
		else
			set.add(new coordinates(xpos,ypos-1));
		return set;
	}
	public void Promotion() {
		
	}
	
}
