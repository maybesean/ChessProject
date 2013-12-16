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
			
				//checking what piece is selected
				oldx = event.getX()/80;
				oldy = event.getY()/80;
				pieceSelected = board[oldx][oldy];
			//	System.out.println(pieceSelected);
				System.out.println(oldx+" "+oldx);
				
			
			
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
		
//			board[oldX][oldY]=0;
//			board[newX][newY]=pieceSelected;
//			repaint();
			
			
			//pawn
			if((pieceSelected>=9&&pieceSelected<=16) || (pieceSelected>=25&&pieceSelected<=32)){
					movePawn(newx,newy,oldx,oldy,current_player);
			}
			//Bishop
			if((pieceSelected>=3&&pieceSelected<=4) || (pieceSelected>=19&&pieceSelected<=20)){
				
			}
			//Knight
			if((pieceSelected>=5&&pieceSelected<=6) || (pieceSelected>=21&&pieceSelected<=22)){
				
			}
			//Rook
			if((pieceSelected>=7&&pieceSelected<=8) || (pieceSelected>=23&&pieceSelected<=24)){
				
			}
			//Queen
			if(pieceSelected==2||pieceSelected==18){
				
			}
			//King
			if(pieceSelected==1||pieceSelected==17){
				
			}
	}
	public void movePawn(int newX, int newY,int oldX, int oldY, int current_player){
			int dx = newx- oldx;
			int dy = newy - oldy;
			
			if((dx==0)&&(dy==-1)&&board[newX-1][newY-1]==0){
				board[oldX][oldY]=0;
				board[newX][newY]=pieceSelected;
				repaint();
			}
			else{
				System.out.print("INVALID MOVE");
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
			   board[0][0] = 24;
			   board[1][0] = 22;
			   board[2][0] = 19;
			   board[3][0] = 18;
			   board[4][0] = 17;
			   board[5][0] = 20;
			   board[6][0] = 21;
			   board[7][0] = 23;
			   board[0][1] = 25;
			   board[1][1] = 26;
			   board[2][1] = 27;
			   board[3][1] = 28;
			   board[4][1] = 29;
			   board[5][1] = 30;
			   board[6][1] = 31;
			   board[7][1] = 32;
			   
			   //white
			   board[0][7] = 7;
			   board[1][7] = 5;
			   board[2][7] = 4;
			   board[3][7] = 2;
			   board[4][7] = 1;
			   board[5][7] = 3;
			   board[6][7] = 6;
			   board[7][7] = 8;
			   board[0][6] = 9;
			   board[1][6] = 10;
			   board[2][6] = 11;
			   board[3][6] = 12;
			   board[4][6] = 13;
			   board[5][6] = 14;
			   board[6][6] = 15;
			   board[7][6] = 16;
		// set the current player to be 1 the scores to 2 all and the game to be in play
				current_player = 1;		
				
	
	}
	
	public void drawPieces(Graphics2D g2d){
		for(int x = 0; x < 8; x++) {
			for(int y = 0; y < 8; y++) {
			//reds
			if(board[x][y]==24){
				g2d.setColor(Color.red);
				g2d.fillOval(x*80, y*80, 80, 80);
				g2d.setColor(white);
				g2d.setFont(new Font("Arial", Font.BOLD, 18));
			    g2d.drawString("   Rook"  , x*80,y*80+40);

			}
			
			if(board[x][y]==22){
				g2d.setColor(Color.red);
				g2d.fillOval(x*80, y*80, 80, 80);
				g2d.setColor(white);
				g2d.setFont(new Font("Arial", Font.BOLD, 18));
				g2d.drawString("   Knight", x*80, y*80+40);
				
			}
			if(board[x][y]==19){
				g2d.setColor(Color.red);
				g2d.fillOval(x*80, y*80, 80, 80);
				g2d.setColor(white);
				g2d.setFont(new Font("Arial", Font.BOLD, 18));
				g2d.drawString("  Bishop", x*80, y*80+40);

			}
			if(board[x][y]==18){
				g2d.setColor(Color.red);
				g2d.fillOval(x*80, y*80, 80, 80);
				g2d.setColor(white);
				g2d.setFont(new Font("Arial", Font.BOLD, 18));
				g2d.drawString("  Queen", x*80, y*80+40);

			}
			if(board[x][y]==17){
				g2d.setColor(Color.red);
				g2d.fillOval(x*80, y*80, 80, 80);
				g2d.setColor(white);
				g2d.setFont(new Font("Arial", Font.BOLD, 18));
				g2d.drawString("   King", x*80, y*80+40);

			}
			if(board[x][y]==20){
				g2d.setColor(Color.red);
				g2d.fillOval(x*80, y*80, 80, 80);
				g2d.setColor(white);
				g2d.setFont(new Font("Arial", Font.BOLD, 18));
				g2d.drawString("  Bishop", x*80, y*80+40);

			}
			if(board[x][y]==21){
				g2d.setColor(Color.red);
				g2d.fillOval(x*80, y*80, 80, 80);
				g2d.setColor(white);
				g2d.setFont(new Font("Arial", Font.BOLD, 18));
				g2d.drawString("  Knight", x*80, y*80+40);

			}
			if(board[x][y]==23){
				g2d.setColor(Color.red);
				g2d.fillOval(x*80, y*80, 80, 80);
				g2d.setColor(white);
				g2d.setFont(new Font("Arial", Font.BOLD, 18));
				g2d.drawString("   Rook", x*80, y*80+40);

			}
			if(board[x][y]==25){
				g2d.setColor(Color.red);
				g2d.fillOval(x*80, y*80, 80, 80);
				g2d.setColor(white);
				g2d.setFont(new Font("Arial", Font.BOLD, 18));
				g2d.drawString("   Pawn", x*80, y*80+40);

			}
			if(board[x][y]==26){
				g2d.setColor(Color.red);
				g2d.fillOval(x*80, y*80, 80, 80);
				g2d.setColor(white);
				g2d.setFont(new Font("Arial", Font.BOLD, 18));
				g2d.drawString("  Pawn", x*80, y*80+40);

			}
			if(board[x][y]==27){
				g2d.setColor(Color.red);
				g2d.fillOval(x*80, y*80, 80, 80);
				g2d.setColor(white);
				g2d.setFont(new Font("Arial", Font.BOLD, 18));
				g2d.drawString("   Pawn", x*80, y*80+40);

			}
			if(board[x][y]==28){
				g2d.setColor(Color.red);
				g2d.fillOval(x*80, y*80, 80, 80);
				g2d.setColor(white);
				g2d.setFont(new Font("Arial", Font.BOLD, 18));
				g2d.drawString("   Pawn", x*80, y*80+40);

			}
			if(board[x][y]==29){
				g2d.setColor(Color.red);
				g2d.fillOval(x*80, y*80, 80, 80);
				g2d.setColor(white);
				g2d.setFont(new Font("Arial", Font.BOLD, 18));
				g2d.drawString("   Pawn", x*80, y*80+40);

			}
			if(board[x][y]==30){
				g2d.setColor(Color.red);
				g2d.fillOval(x*80, y*80, 80, 80);
				g2d.setColor(white);
				g2d.setFont(new Font("Arial", Font.BOLD, 18));
				g2d.drawString("   Pawn", x*80, y*80+40);

			}
			if(board[x][y]==31){
				g2d.setColor(Color.red);
				g2d.fillOval(x*80, y*80, 80, 80);
				g2d.setColor(white);
				g2d.setFont(new Font("Arial", Font.BOLD, 18));
				g2d.drawString("   Pawn", x*80, y*80+40);

			}
			if(board[x][y]==32){
				g2d.setColor(Color.red);
				g2d.fillOval(x*80, y*80, 80, 80);
				g2d.setColor(white);
				g2d.setFont(new Font("Arial", Font.BOLD, 18));
				g2d.drawString("   Pawn", x*80, y*80+40);

			}
			
			//blues
			if(board[x][y]==7){
				g2d.setColor(Color.blue);
				g2d.fillOval(x*80, y*80, 80, 80);
				g2d.setColor(white);
				g2d.setFont(new Font("Arial", Font.BOLD, 18));
				g2d.drawString("    Rook", x*80, y*80+40);

			}
			if(board[x][y]==5){
				g2d.setColor(Color.blue);
				g2d.fillOval(x*80, y*80, 80, 80);
				g2d.setColor(white);
				g2d.setFont(new Font("Arial", Font.BOLD, 18));
				g2d.drawString("   Knight", x*80, y*80+40);

			}
			if(board[x][y]==4){
				g2d.setColor(Color.blue);
				g2d.fillOval(x*80, y*80, 80, 80);
				g2d.setColor(white);
				g2d.setFont(new Font("Arial", Font.BOLD, 18));
				g2d.drawString("   Bishop", x*80, y*80+40);

			}
			if(board[x][y]==2){
				g2d.setColor(Color.blue);
				g2d.fillOval(x*80, y*80, 80, 80);
				g2d.setColor(white);
				g2d.setFont(new Font("Arial", Font.BOLD, 18));
				g2d.drawString("   Queen", x*80, y*80+40);

			}
			if(board[x][y]==1){
				g2d.setColor(Color.blue);
				g2d.fillOval(x*80, y*80, 80, 80);
				g2d.setColor(white);
				g2d.setFont(new Font("Arial", Font.BOLD, 18));
				g2d.drawString("    King", x*80, y*80+40);

			}
			if(board[x][y]==3){
				g2d.setColor(Color.blue);
				g2d.fillOval(x*80, y*80, 80, 80);
				g2d.setColor(white);
				g2d.setFont(new Font("Arial", Font.BOLD, 18));
				g2d.drawString("  Bishop", x*80, y*80+40);

			}
			if(board[x][y]==6){
				g2d.setColor(Color.blue);
				g2d.fillOval(x*80, y*80, 80, 80);
				g2d.setColor(white);
				g2d.setFont(new Font("Arial", Font.BOLD, 18));
				g2d.drawString("   Knight", x*80, y*80+40);

			}
			if(board[x][y]==8){
				g2d.setColor(Color.blue);
				g2d.fillOval(x*80, y*80, 80, 80);
				g2d.setColor(white);
				g2d.setFont(new Font("Arial", Font.BOLD, 18));
				g2d.drawString("    Rook", x*80, y*80+40);

			}
			if(board[x][y]==9){
				g2d.setColor(Color.blue);
				g2d.fillOval(x*80, y*80, 80, 80);
				g2d.setColor(white);
				g2d.setFont(new Font("Arial", Font.BOLD, 18));
				g2d.drawString("    Pawn", x*80, y*80+40);

			}
			if(board[x][y]==10){
				g2d.setColor(Color.blue);
				g2d.fillOval(x*80, y*80, 80, 80);
				g2d.setColor(white);
				g2d.setFont(new Font("Arial", Font.BOLD, 18));
				g2d.drawString("    Pawn", x*80, y*80+40);

			}
			if(board[x][y]==11){
				g2d.setColor(Color.blue);
				g2d.fillOval(x*80, y*80, 80, 80);
				g2d.setColor(white);
				g2d.setFont(new Font("Arial", Font.BOLD, 18));
				g2d.drawString("    Pawn", x*80, y*80+40);

			}
			if(board[x][y]==12){
				g2d.setColor(Color.blue);
				g2d.fillOval(x*80, y*80, 80, 80);
				g2d.setColor(white);
				g2d.setFont(new Font("Arial", Font.BOLD, 18));
				g2d.drawString("    Pawn", x*80, y*80+40);
			}
			if(board[x][y]==13){
				g2d.setColor(Color.blue);
				g2d.fillOval(x*80, y*80, 80, 80);
				g2d.setColor(white);
				g2d.setFont(new Font("Arial", Font.BOLD, 18));
				g2d.drawString("    Pawn", x*80, y*80+40);

			}
			if(board[x][y]==14){
				g2d.setColor(Color.blue);
				g2d.fillOval(x*80, y*80, 80, 80);
				g2d.setColor(white);
				g2d.setFont(new Font("Arial", Font.BOLD, 18));
				g2d.drawString("    Pawn", x*80, y*80+40);

			}
			if(board[x][y]==15){
				g2d.setColor(Color.blue);
				g2d.fillOval(x*80, y*80, 80, 80);
				g2d.setColor(white);
				g2d.setFont(new Font("Arial", Font.BOLD, 18));
				g2d.drawString("    Pawn", x*80, y*80+40);

			}
			if(board[x][y]==16){
				g2d.setColor(Color.blue);
				g2d.fillOval(x*80, y*80, 80, 80);
				g2d.setColor(white);
				g2d.setFont(new Font("Arial", Font.BOLD, 18));
				g2d.drawString("    Pawn", x*80, y*80+40);

			}
			
			
		}
		}
	}
	
	
	

			//white pieces	
			int whiteKing = 1;
			int whiteQueen = 2;
			int whiteEastBishop = 3;
			int whiteWestBishop = 4;
			int whiteWestKnight = 5;
			int whiteEastKnight = 6;
			int whiteWestRook = 7; 
			int whiteEastRook = 8; 
			int whitepawn1=9;
			int whitepawn2=10;
			int whitepawn3=11;
			int whitepawn4=12;
			int whitepawn5=13;
			int whitepawn6=14;
			int whitepawn7=15;
			int whitepawn8=16;
			
			
			//black pieces
			int blackKing = 17;
			int blackQueen = 18;
			int blackEastBishop = 19;
			int blackWestBishop = 20;
			int blackWestKnight = 21;
			int blackEastKnight = 22;
			int blackWestRook = 23; 
			int blackEastRook = 24; 
			int blackpawn1 = 25;
			int blackpawn2 = 26;
			int blackpawn3 = 27;
			int blackpawn4 = 28;
			int blackpawn5 = 29;
			int blackpawn6 = 30;
			int blackpawn7 = 31;
			int blackpawn8 = 32;
		
			
			int oldx,oldy,newx,newy;
			int pieceSelected;
			int current_player;					// denotes who the current player is
			boolean inPlay;						// indicates if the game is being played at the moment
			Color black,white,brown,red;
			int board[][];
			int currentPlayer;
}