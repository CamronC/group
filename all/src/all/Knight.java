package all;

import java.util.ArrayList;

public class Knight extends Chesspiece{
	String name="Knight";
	public Knight(int x,int y, char col) {
		xpos=x;
		ypos=y;
		color=col;
	}
	public ArrayList<coordinates> Move() {
		ArrayList<coordinates> set=new ArrayList<coordinates>();
		set.add(new coordinates(xpos+1,ypos+2));
		set.add(new coordinates(xpos+2,ypos+1));
		set.add(new coordinates(xpos-1,ypos+2));
		set.add(new coordinates(xpos-2,ypos+1));
		set.add(new coordinates(xpos+1,ypos-2));
		set.add(new coordinates(xpos+2,ypos-1));
		set.add(new coordinates(xpos-1,ypos-2));
		set.add(new coordinates(xpos-2,ypos-1));
		for(int i=0;i<set.size();i++) {
			if(set.get(i).x<0||set.get(i).x>7||set.get(i).y<0||set.get(i).y>7) {
				set.remove(i);
				i--;
			}
		}
		return set;
	}
}
