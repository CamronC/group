package all;

import java.util.ArrayList;

public class King extends Chesspiece{
	String name="King";
	boolean moved=false;
	public King(int x,int y, char col) {
		xpos=x;
		ypos=y;
		color=col;
	}
	public ArrayList<coordinates> Move() {
		ArrayList<coordinates> set=new ArrayList<coordinates>();
		int x=xpos;
		int y=ypos;
			set.add(new coordinates(x+1,y-1));
			set.add(new coordinates(x+1,y));
			set.add(new coordinates(x+1,y+1));
			set.add(new coordinates(x,y+1));
			set.add(new coordinates(x,y-1));
			set.add(new coordinates(x-1,y-1));
			set.add(new coordinates(x-1,y));
			set.add(new coordinates(x-1,y+1));
			for(int i=0;i<set.size();i++) {
				if(set.get(i).x<0||set.get(i).x>7||set.get(i).y<0||set.get(i).y>7) {
					set.remove(i);
					i--;
				}
			}
		return set;
	}
}
