package all;

import java.util.ArrayList;

public class Queen extends Chesspiece{
	String name="Queen";
	public Queen(int x,int y, char col) {
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
		x=xpos;
		y=ypos;
		while(x>=0&&y<=7) {
			set.add(new coordinates(x,y));
			x--;
			y++;
		}
		x=xpos;
		y=ypos;
		while(x<=7&&y>=0) {
			set.add(new coordinates(x,y));
			x++;
			y--;
		}
		x=xpos;
		y=ypos;
		while(x>=0&&y>=0) {
			set.add(new coordinates(x,y));
			x--;
			y--;
		}
		x=xpos;
		y=ypos;
		while(x<=7&&y<=7) {
			set.add(new coordinates(x,y));
			x++;
			y--;
		}
		return set;
	}	
}