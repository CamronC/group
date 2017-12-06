package all;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.*;
import javax.swing.border.*;

import all.Player;

import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class all extends JFrame implements MouseListener {

    public final JPanel GUI = new JPanel(new BorderLayout(4, 4));
    public JButton[][] boardSquares = new JButton[8][8];
    public Image[][] chessPiece = new Image[2][6];
    public JPanel chessBoard;
    private ArrayList<Player> wplayer,bplayer;
    public final JLabel message = new JLabel(
            "SPONGEBOB 4 PRESIDENT");
    public static final String COLUMN = "ABCDEFGH";
    public static final int 
    	QUEEN = 0, 
    	KING = 1,
        ROOK = 2,
        KNIGHT = 3,
        BISHOP = 4,
        PAWN = 5;
    public static final int[] 
    	START_ROW = {
    			ROOK, KNIGHT, BISHOP, KING, QUEEN, BISHOP, KNIGHT, ROOK
    };
    public static final int 
    	BLACK = 0,
    	WHITE = 1;

    public all() { initializeGui();
    }
    
    public final void initializeGui() {
        createImages(); // creates chess piece images

        //main GUI
        GUI.setBorder(new EmptyBorder(8,8,8,8));
        JToolBar tools = new JToolBar();
        tools.setFloatable(false);
        GUI.add(tools, BorderLayout.PAGE_START);
        Action newGameAction = new AbstractAction("CLICK ME IF YOU ARENT TOO SCARED TO PLAY!!!") {

            @Override
            public void actionPerformed(ActionEvent e) {
                setupNewGame();
            }
        };
        tools.add(newGameAction);
        tools.add(message);
        
        
        //creates the dimensions for the chessboard
        
        
        
        chessBoard = new JPanel(new GridLayout(0, 9)) {
            public final Dimension getSize() {
                Dimension d = super.getSize();
                Dimension size = null;
                Component comp = getParent();
                if (comp == null) { size = new Dimension((int)d.getWidth(),(int)d.getHeight());
                } else if (comp!=null && comp.getWidth()>d.getWidth() && comp.getHeight()>d.getHeight()) 
                { 
                	size = comp.getSize();
                } else {
                	size = d;
                }
                int w = (int) size.getWidth();
                int h = (int) size.getHeight();
                // the smaller of the two sizes
                int x = (w>h ? h : w);
                return new Dimension(x,x);
            }
        };
        chessBoard.setBorder(new CompoundBorder(
                new EmptyBorder(8,8,8,8),
                new LineBorder(Color.BLACK)
                ));
        
        
        // changes the background for the grid
        
        
        Color white = new Color(235,235,235);
        chessBoard.setBackground(white);
        JPanel boardSize = new JPanel(new GridBagLayout());
        boardSize.setBackground(white);
        boardSize.add(chessBoard);
        GUI.add(boardSize);

        // create the chess board squares
        Insets buttonMargin = new Insets(0, 0, 0, 0);
        for (int i = 0; i < boardSquares.length; i++) {
            for (int j = 0; j < boardSquares[i].length; j++) {
                JButton b = new JButton();
                b.setMargin(buttonMargin);
                // creates 64x64 tiles for our same size pieces 
                ImageIcon icon = new ImageIcon(new BufferedImage(64, 64, BufferedImage.BITMASK));
                b.setIcon(icon);
                if ((j % 2 == 1 && i % 2 == 1) || (j % 2 == 0 && i % 2 == 0)) {
                    b.setBackground(Color.RED);
                } else {
                    b.setBackground(Color.BLACK);
                }
                boardSquares[j][i] = b;
            }
        }

        //filling the board
        
        
        chessBoard.add(new JLabel(""));
        // fill the top row
        for (int i = 0; i < 8; i++) {
            chessBoard.add(
                    new JLabel(COLUMN.substring(i, i + 1),
                    SwingConstants.CENTER));
        }
        // fill the black non-pawn piece row
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                switch (j) {
                    case 0:
                        chessBoard.add(new JLabel("" + (9-(i + 1)),
                                SwingConstants.CENTER));
                    //orients the layout of pieces
                    default:
                        chessBoard.add(boardSquares[i][j]);
                }
            }
        }
    }
    
    public static ArrayList<Player> fetch_players()         //Function to fetch the list of the players
	{
		Player tempplayer;
		ObjectInputStream input = null;
		ArrayList<Player> players = new ArrayList<Player>();
		try
		{
			File infile = new File(System.getProperty("user.dir")+ File.separator + "chessgamedata.dat");
			input = new ObjectInputStream(new FileInputStream(infile));
			try
			{
				while(true)
				{
					tempplayer = (Player) input.readObject();
					players.add(tempplayer);
				}
			}
			catch(EOFException e)
			{
				input.close();
			}
		}
		catch (FileNotFoundException e)
		{
			players.clear();
			return players;
		}
		catch (IOException e)
		{
			e.printStackTrace();
			try {input.close();} catch (IOException e1) {}
			JOptionPane.showMessageDialog(null, "Unable to read the required Game files !!");
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Game Data File Corrupted !! Click Ok to Continue Builing New File");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return players;
	}

    public final JComponent getGui() {
        return GUI;
    }

    public final void createImages() {
        try {
            URL url = new URL("https://i.imgur.com/9Awn4XX.png");
            BufferedImage piece = ImageIO.read(url);
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 6; j++) {
                	chessPiece[i][j] = piece.getSubimage( j * 64, i * 64, 64, 64);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    // icons of the initial chess board piece places 
    public final void setupNewGame() {
        message.setText("YOUR MOVE");
        // set up the white pieces
        for (int i = 0; i < START_ROW.length; i++) {
        	boardSquares[i][6].setIcon(new ImageIcon(
        			chessPiece[WHITE][PAWN]));
        }
        for (int i = 0; i < START_ROW.length; i++) {
        	boardSquares[i][7].setIcon(new ImageIcon(
        			chessPiece[WHITE][START_ROW[i]]));
        }
        // set up the black pieces
        for (int i = 0; i < START_ROW.length; i++) {
        	boardSquares[i][0].setIcon(new ImageIcon(
        			chessPiece[BLACK][START_ROW[i]]));
        }
        for (int i = 0; i < START_ROW.length; i++) {
        	boardSquares[i][1].setIcon(new ImageIcon(
        			chessPiece[BLACK][PAWN]));
        }
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {

            @Override
            public void run() {
                all cg = new all();

                JFrame f = new JFrame("CHESS PROJECT");
                f.add(cg.getGui());
                // Ensures JVM closes after frame closes
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setLocationByPlatform(true);
                // makes sure things fit in order to display the components
                f.pack();
                //min size
                f.setMinimumSize(f.getSize());
                f.setVisible(true);
            }
        };
        SwingUtilities.invokeLater(r);
    }

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}