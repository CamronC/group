package all;
import java.util.ArrayList;
import javax.swing.JButton;

public class Chesspiece extends JButton {
	private static final long serialVersionUID = 1L;
	public String name="";
	char color='x';
	int xpos=0;
	int ypos=0;
	//this is unique for each piece, so each returns a list of possible coordinates it can move to.
	public ArrayList<coordinates> Move() {
		return null;
	}
}