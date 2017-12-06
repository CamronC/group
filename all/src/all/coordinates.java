package all;
//this class is used in giving a list of possible coordinates to be selected
public class coordinates {
	int x;
	int y;
	coordinates(int x, int y){
		this.x=x;
		this.y=y;
	}
	public String toString() {
		return x+","+y;
	}
}
