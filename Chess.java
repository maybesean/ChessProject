import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import javax.swing.JFrame;
public class Chess extends JFrame{
		
		public Chess(){
			setSize(655,675);
			setTitle("Chess");
			setResizable(false);
			ChessWidget widget = new ChessWidget();
			getContentPane().add(widget);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		}
	
public static void main(String[] args) {
	// create a main object and make it visible
	Chess object = new Chess();
	object.setVisible(true);
	}


}
class ChessWidget extends JComponent implements  MouseListener{
	//creating public variables 
	
	
	
	public ChessWidget(){
		black = new Color(0, 0, 0);
		white = new Color(255, 255, 255);
		board = new int[8][8];
		initialState();
		
		// set a mouse listener for this widget
				addMouseListener(this);
	}

	
	public void mouseClicked(MouseEvent event) {
	
		
	}

	public void mouseEntered(MouseEvent event) {
	}
	public void mouseExited(MouseEvent event) {
			
	}
	public void mousePressed(MouseEvent event) {
			
				oldx = event.getX()/80;
				oldy = event.getY()/80;
				pieceSelected = board[oldx][oldy];
			    System.out.println(pieceSelected);
				System.out.println(oldx+" "+oldy);
				
			
			
	}
	public void mouseReleased(MouseEvent event) {
			newx= event.getX()/80;
			newy=event.getY()/80;
			attemptMove(newx,newy,oldx,oldy,current_player);
			//System.out.println(newx+" "+newy);
	}
	public void paintComponent(Graphics g){
		
		Graphics2D g2d = (Graphics2D) g;
        drawGrid(g2d);
        drawPieces(g2d); 
		
	}
	public void attemptMove(int newX, int newY, int oldX, int oldY, int current_player){
		//need to check if game is in play
		//need to check if player is in check
		//need to check if position is occupied
		

			
			//pawn
			if((pieceSelected==whitePawn) || (pieceSelected==blackPawn)){
				movePawn(newx,newy,oldx,oldy,current_player);
			}
			//Bishop
			if((pieceSelected==blackBishop) || (pieceSelected==whiteBishop)){
				moveBishop(newx,newy,oldx,oldy,current_player);
			}
			//Knight
			if((pieceSelected==whiteKnight) || (pieceSelected==blackKnight)){
				moveKnight(newx,newy,oldx,oldy,current_player);
			}
			//Rook
			if((pieceSelected==whiteRook)|| (pieceSelected==blackRook)){
				moveRook(newX,newY,oldX,oldY,current_player);
			}
			//Queen
			if(pieceSelected==whiteQueen||pieceSelected==blackQueen){
				moveQueen(newx,newy,oldx,oldy,current_player);
			}
			//King
			if(pieceSelected==whiteKing||pieceSelected==blackKing){
				moveKing(newX,newY,oldX,oldY,current_player);
			}
	}

	
	public void moveBishop(int newX, int newY,int oldX, int oldY, int current_player){
		int dx = newX-oldX;
		int dy = newY-oldY;
			if(pieceSelected==blackBishop){
				if ((dx == dy) || (dx == -dy)){
					board[oldX][oldY]=0;
	    			board[newX][newY]=pieceSelected;
	    			repaint();
				}
			}
			
			if(pieceSelected==whiteBishop){
				if ((dx == dy) || (dx == -dy)){
					board[oldX][oldY]=0;
	    			board[newX][newY]=pieceSelected;
	    			repaint();
				}
			}
	}
			
		
		public void moveKing(int newX, int newY,int oldX, int oldY, int current_player){
		int dx = newX-oldX;
		int dy = newY-oldY;
		
		
		//Still doesnt take into account the if pieces are in front of it 
		if(((dy == -1) || (dy == 0) || (dy == 1)) && ((dx == -1) || (dx == 0) || (dx == 1))) {
			board[oldX][oldY]=0;
			board[newX][newY]=pieceSelected;
			repaint();
		 }
	}
	
	public void moveKnight(int newX, int newY, int oldX, int oldY, int current_player){
			int dx = newX-oldX;
			int dy = newY-oldY;
			
			if((((dy == -2) && (dx == -1)) || ((dy == -2) && (dx == 1)) || ((dy == -1) && (dx == 2)) || ((dy == 1) && (dx == 2)) 
				|| ((dy == 2) && (dx == 1)) || ((dy == 2) && (dx == -1)) || ((dy == 1) && (dx == -2))
					  || ((dy == -1) && (dx == -2)))){
						board[oldX][oldY]=0;
		    			board[newX][newY]=pieceSelected;
		    			repaint();
					}
		}
	public void movePawn(int newX, int newY, int oldX, int oldY, int current_player){
		int dx = newX - oldX;
	    int dy = newY - oldY;	
	    			
	    			//blues
	    		if(pieceSelected==whitePawn){
	    			if ((dx == 0) && (dy == -1) && board[newX][newY]==0){
		    			board[oldX][oldY]=0;
		    			board[newX][newY]=pieceSelected;
		    			repaint();
	    			}
	    			//if the pawn is on stating position, move 2 if user desires
	    			else if(oldy==6){	
	    				if((dx == 0) && (dy==-2) && board[newX][newY]==0){
		    			board[oldX][oldY]=0;
		    			board[newX][newY]=pieceSelected;
		    			repaint();
	    			}
		    	}
	    	}
	
	    			
	    			//reds
	    		if(pieceSelected==blackPawn){
	    			if ((dx == 0) && (dy == 1) && board[newX][newY]==0){
		    			board[oldX][oldY]=0;
		    			board[newX][newY]=pieceSelected;
		    			repaint();
		    			}
	    				//if the pawn is on stating position, move 2 if user desires
	    			else if(oldy==1){
		    			 if((dx == 0) && (dy==2) && board[newX][newY]==0){
		    			board[oldX][oldY]=0;
		    			board[newX][newY]=pieceSelected;
		    			repaint();
		    			 	}
	    				}
	    			}
	    	
	  }
	
		public void moveQueen(int newX, int newY, int oldX, int oldY, int current_player){
		int dx = newX - oldX; 
		int dy = newY - oldY;
		 
		if(pieceSelected==whiteQueen){
			System.out.print("Yay");
			if((dx ==dy) || (dx == -dy)){
				board[oldX][oldY]=0;
    			board[newX][newY]=pieceSelected;
    			repaint();
			}
			
			if ((dx==0)||(dy==0)){
				board[oldX][oldY]=0;
    			board[newX][newY]=pieceSelected;
    			repaint();
			}
		}
		
		if(pieceSelected==blackQueen){
			System.out.print("Yay");
			if((dx ==dy) || (dx == -dy)){
				board[oldX][oldY]=0;
    			board[newX][newY]=pieceSelected;
    			repaint();
			}
			
			if ((dx==0)||(dy==0)){
				board[oldX][oldY]=0;
    			board[newX][newY]=pieceSelected;
    			repaint();
			}
		}
		
		
		
		
	}
	
	public void moveRook(int newX, int newY, int oldX, int oldY, int current_player){
		int dx = newX - oldX;
		int dy = newY - oldY;
		
		if(dx==0){
			board[oldX][oldY]=0;
			board[newX][newY]=pieceSelected;
			repaint();
		}
		else if(dy==0){
			board[oldX][oldY]=0;
			board[newX][newY]=pieceSelected;
			repaint();
		}
		
	
	
}
	
	
	
	public void drawGrid(Graphics2D g2d){
	
		
		g2d.drawLine(0, 0, 0, 639);
		g2d.drawLine(0, 0, 639, 0);
		g2d.drawLine(0, 639, 639, 639);
		g2d.drawLine(639, 0, 639, 639);
		
		// draw the horizontal lines using a loop from one to 7, coordiates of each line is (0, x*80, 640, x*80) also
		// draw vertical lines with coordinates of (x*80, 0, x*80, 640)
		for(int i = 1; i < 8; i++) {
			g2d.drawLine(0, i*80, 640, i*80);
			g2d.drawLine(i*80, 0, i*80, 640);
		}
		//drawing the black and white squares 
		for (int row = 0; row < 8; row++)
	        for (int col = 0; col < 8; col++) {
	        	if ( (row % 2 == 0 && col % 2 == 0) ||  ( row % 2 == 1 &&  col % 2 == 1)  ){
	        		g2d.setColor(black);
					g2d.fillRect(row*80,col*80,80,80);

	        	}
	        }
	}
	
	public void initialState(){
		
			
			   //black
			   board[0][0] = blackRook;							
			   board[1][0] = blackKnight ;
			   board[2][0] = blackBishop ;
			   board[3][0] = blackQueen;
			   board[4][0] = blackKing;
			   board[5][0] = blackBishop;
			   board[6][0] = blackKnight;
			   board[7][0] = blackRook ;
			   board[0][1] = blackPawn ;
			   board[1][1] = blackPawn ;
			   board[2][1] = blackPawn ;
			   board[3][1] = blackPawn ;
			   board[4][1] = blackPawn ;
			   board[5][1] = blackPawn ;
			   board[6][1] = blackPawn ;
			   board[7][1] = blackPawn ;
			   
			   //white
			   board[0][7] = whiteRook;
			   board[1][7] = whiteKnight;
			   board[2][7] = whiteBishop;
			   board[3][7] = whiteKing;
			   board[4][7] = whiteQueen ;
			   board[5][7] = whiteBishop ;
			   board[6][7] = whiteKnight ;
			   board[7][7] = whiteRook;
			   board[0][6] = whitePawn ;
			   board[1][6] = whitePawn ;
			   board[2][6] = whitePawn ;
			   board[3][6] = whitePawn ;
			   board[4][6] = whitePawn ;
			   board[5][6] = whitePawn ;
			   board[6][6] = whitePawn ;
			   board[7][6] = whitePawn ;
		// set the current player to be 1 the scores to 2 all and the game to be in play
				current_player = 1;		
				
	
	}
	
	public void drawPieces(Graphics2D g2d){
		for(int x = 0; x < 8; x++) {
			for(int y = 0; y < 8; y++) {
			//white pieces 
				
				//white pawns
			if(board[x][y]==whitePawn){
				g2d.setColor(Color.blue);
				g2d.fillOval(x*80, y*80, 80, 80);
				g2d.setColor(white);
				g2d.setFont(new Font("Arial", Font.BOLD, 18));
			    g2d.drawString("   Pawn"  , x*80,y*80+40);
			}
			// white king 
			if(board[x][y]==whiteKing){
				g2d.setColor(Color.blue);
				g2d.fillOval(x*80, y*80, 80, 80);
				g2d.setColor(white);
				g2d.setFont(new Font("Arial", Font.BOLD, 18));
			    g2d.drawString("   King"  , x*80,y*80+40);
			}
			//white queen 			
			if(board[x][y]==whiteQueen){
				g2d.setColor(Color.blue);
				g2d.fillOval(x*80, y*80, 80, 80);
				g2d.setColor(white);
				g2d.setFont(new Font("Arial", Font.BOLD, 18));
			    g2d.drawString("   Queen"  , x*80,y*80+40);

			}
			// white bishops 
			if(board[x][y]==whiteBishop){
				g2d.setColor(Color.blue);
				g2d.fillOval(x*80, y*80, 80, 80);
				g2d.setColor(white);
				g2d.setFont(new Font("Arial", Font.BOLD, 18));
			    g2d.drawString("   Bishop"  , x*80,y*80+40);
				}
			//	white knight
			if(board[x][y]==whiteKnight){
				g2d.setColor(Color.blue);
				g2d.fillOval(x*80, y*80, 80, 80);
				g2d.setColor(white);
				g2d.setFont(new Font("Arial", Font.BOLD, 18));
			    g2d.drawString("   Knight"  , x*80,y*80+40);

				}
			//white rook
			if(board[x][y]==whiteRook){
				g2d.setColor(Color.blue);
				g2d.fillOval(x*80, y*80, 80, 80);
				g2d.setColor(white);
				g2d.setFont(new Font("Arial", Font.BOLD, 18));
			    g2d.drawString("   Rook"  , x*80,y*80+40);
				}
			
			//black pieces 
			
			
			// black pawns 
			if(board[x][y]==blackPawn){
				g2d.setColor(Color.red);
				g2d.fillOval(x*80, y*80, 80, 80);
				g2d.setColor(white);
				g2d.setFont(new Font("Arial", Font.BOLD, 18));
			    g2d.drawString("   Pawn"  , x*80,y*80+40);
				}
			//	black king 
			if(board[x][y]==blackKing){
				g2d.setColor(Color.red);
				g2d.fillOval(x*80, y*80, 80, 80);
				g2d.setColor(white);
				g2d.setFont(new Font("Arial", Font.BOLD, 18));
			    g2d.drawString("   King"  , x*80,y*80+40);

				}
			//	black queen 
			if(board[x][y]==blackQueen){
				g2d.setColor(Color.red);
				g2d.fillOval(x*80, y*80, 80, 80);
				g2d.setColor(white);
				g2d.setFont(new Font("Arial", Font.BOLD, 18));
			    g2d.drawString("   Queen"  , x*80,y*80+40);
				}
			//	black bishop
			if(board[x][y]==blackBishop){
				g2d.setColor(Color.red);
				g2d.fillOval(x*80, y*80, 80, 80);
				g2d.setColor(white);
				g2d.setFont(new Font("Arial", Font.BOLD, 18));
			    g2d.drawString("   Bishop"  , x*80,y*80+40);
				}
			// black knight 
			if(board[x][y]==blackKnight){
				g2d.setColor(Color.red);
				g2d.fillOval(x*80, y*80, 80, 80);
				g2d.setColor(white);
				g2d.setFont(new Font("Arial", Font.BOLD, 18));
		  	  g2d.drawString("   Knight"  , x*80,y*80+40);
				}
			//	black rook 
			if(board[x][y]==blackRook){
				g2d.setColor(Color.red);
				g2d.fillOval(x*80, y*80, 80, 80);
				g2d.setColor(white);
				g2d.setFont(new Font("Arial", Font.BOLD, 18));
			    g2d.drawString("   Rook"  , x*80,y*80+40);
				}
			}
		}
	}
	
	
	

			//white pieces	
			int whiteKing = 1;
			int whiteQueen = 2;
			int whiteBishop = 3;
			int whiteKnight = 4;
			int whiteRook = 5; 
			int whitePawn = 11; 
			//black pieces
			int blackKing = 6;  	 
			int blackQueen = 7; 	 
			int blackBishop = 8; 
			int blackKnight = 9; //set to 13
			int blackRook = 10;   //set to 15
			int blackPawn = 22;
		
			
			int oldx,oldy,newx,newy;
			int pieceSelected;
			int current_player;					// denotes who the current player is
			boolean inPlay;						// indicates if the game is being played at the moment
			Color black,white,brown,red;
			int board[][];
			int currentPlayer;
}