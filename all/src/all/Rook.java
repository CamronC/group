package all;

import java.util.ArrayList;

public class Rook extends Chesspiece{
	String name="Rook";
	boolean moved=false;
	public Rook(int x,int y, char col) {
		xpos=x;
		ypos=y;
		color=col;
	}
	public ArrayList<coordinates> Move() {
		ArrayList<coordinates> set=new ArrayList<coordinates>();
		int x=xpos,y=ypos;
		while(x>0)
			set.add(new coordinates(x--,y));
		x=xpos;
		y=ypos;
		while(x<0)
			set.add(new coordinates(x++,y));
		x=xpos;
		y=ypos;
		while(y>0)
			set.add(new coordinates(x,y--));
		x=xpos;
		y=ypos;
		while(y<0)
			set.add(new coordinates(x,y++));
		return set;
	}
}
