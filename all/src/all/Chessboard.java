package all;
import java.util.*;

public class Chessboard {
	Chesspiece[][] Cboard=new Chesspiece[8][8];
	void boardClear() {
		for( int i = 0; i < Cboard.length; i++ )
			   Arrays.fill( Cboard[i], null );
	}
	void boardReset() {
		boardClear();
		for(int i=0;i<8;i++) {
			Cboard[1][i]=new Pawn(1,i,'b');
			Cboard[6][i]=new Pawn(6,i,'b');
		}
		Cboard[0][3]=new King(0,3,'b');
		Cboard[0][4]=new Queen(0,4,'b');
		Cboard[0][1]=new Knight(0,1,'b');
		Cboard[0][6]=new Knight(0,6,'b');
		Cboard[0][0]=new Rook(0,0,'b');
		Cboard[0][7]=new Rook(0,7,'b');
		Cboard[0][2]=new Bishop(0,2,'b');
		Cboard[0][5]=new Bishop(0,5,'b');
		Cboard[7][3]=new King(7,3,'b');
		Cboard[7][4]=new Queen(7,4,'b');
		Cboard[7][1]=new Knight(7,1,'b');
		Cboard[7][6]=new Knight(7,6,'b');
		Cboard[7][7]=new Rook(7,0,'b');
		Cboard[7][7]=new Rook(7,7,'b');
		Cboard[7][2]=new Bishop(7,2,'b');
		Cboard[7][5]=new Bishop(7,5,'b');
	}
	void move(Chesspiece[][] Cboard,Chesspiece piece){
		//to move each of the pieces, we take the array of pieces and the piece that is to be moved.
		//the function calls the piece's move function, returning an ArrayList of possible spaces it can move to.
	 	ArrayList<coordinates> possibility=piece.Move();
	 	coordinates checker1,checker2,checker3,choice;
	 	int index=0;
	 	choice=possibility.get(0);
	 	if(piece.name=="Knight") {
	 		while(index<possibility.size()) {
	 			checker1=possibility.get(index);
	 			if(Cboard[checker1.x][checker1.y].color==piece.color) {
	 				possibility.remove(index);
	 				index--;
	 			}
	 			index++;
	 		}
	 	}else {
	 		while(index<possibility.size()) {
	 			checker1=possibility.get(index);
	 			if(Cboard[checker1.x][checker1.y].color==piece.color) {
	 				possibility.remove(index);
	 				index--;
	 			}
	 			index++;
	 		}
	 	}
	 	//choice=user button press.
	 	Cboard[choice.x][choice.y]=piece;
	}
	void Remove(Chesspiece[][] Cboard, int x, int y) {
		Cboard[x][y]=null;
	}
}
