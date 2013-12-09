import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import javax.swing.JFrame;


public class Chess extends JFrame{
		
		public Chess(){
			setSize(655,675);
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
		
	}

	
	public void mouseClicked(MouseEvent arg0) {
	
		
	}

	public void mouseEntered(MouseEvent arg0) {
	}
	public void mouseExited(MouseEvent arg0) {
			
	}
	public void mousePressed(MouseEvent arg0) {

	}
	public void mouseReleased(MouseEvent arg0) {
			
	}
	public void paintComponent(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(white);
		
		g.setColor(Color.white);
        g.fillRect(0, 0, width, height);
        drawGrid(g2d);
		
	}
	public void drawGrid(Graphics2D g2d){
		g2d.setColor(black);
		
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
		for(int i =0; i<8; i++){
			for(int x=0; x<8; x++){
				if(x%2==1){
					g2d.setColor(black);
					g2d.fillRect(i,x, i*80, i*80);
				}
			}
		}
	}
	
	
	

		
		
	
final 	int width = getWidth();
final	int height = getHeight();
	Color black,white;
	int board[][];
	int currentPlayer;
}