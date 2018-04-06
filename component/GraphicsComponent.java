package component;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;

import util.Direction;
import cell.BarrierCell;
import cell.FoodCell;
import cell.SnakeCell;

public class GraphicsComponent extends JComponent {

	public static final int DEFAULT_WIDTH = 1900;
	public static final int DEFAULT_HEIGHT = 1200;
	public static final int DEFAULT_CELL_SIZE = 10;
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void paintComponent( Graphics g ) {
		Graphics2D g2 = (Graphics2D) g;
		//g2.setColor(Color.LIGHT_GRAY);
		/*for( int i=0; i<DEFAULT_WIDTH/DEFAULT_CELL_SIZE; i++ ) {
			for( int j=0; j<DEFAULT_HEIGHT/DEFAULT_CELL_SIZE; j++ ) {
				Rectangle2D rectangle = new Rectangle2D.Float(i*DEFAULT_CELL_SIZE, j*DEFAULT_CELL_SIZE, DEFAULT_CELL_SIZE, DEFAULT_CELL_SIZE);
				g2.draw(rectangle);
				Shape s;
			}
		}*/
		/*g2.setColor(Color.RED);
		g2.drawRect(5, 5, 10, 10);
		g2.setColor(Color.BLACK);
		g2.fillRect(6, 6, 9, 9);*/
		BarrierCell bs = new BarrierCell(5,5);
		bs.draw(g2);
		FoodCell fs = new FoodCell(7,7);
		fs.draw(g2);
		SnakeCell sc = new SnakeCell(9,9,Direction.UP,true);
		sc.draw(g2);
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension( DEFAULT_WIDTH, DEFAULT_HEIGHT ); 
	}
}
