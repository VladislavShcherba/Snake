package cell;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import util.GlobalPreferences;

public class FoodCell extends Cell {
	
	public FoodCell( int x, int y ) {
		super(x, y);
	}
	
	public FoodCell( Cell cell ) {
		super(cell);
	}

	@Override
	public void draw( Graphics g ) {
		Graphics2D g2 = (Graphics2D) g;
		int size = GlobalPreferences.getCellSize();
		int indent = size / 3;
		g2.setColor(Color.YELLOW);
		g2.fill( new Rectangle2D.Float( size*x+1, size*y+1, size-1, size-1 ) );
		g2.setColor(Color.BLACK);
		g2.draw( new Rectangle2D.Float( size*x, size*y, size, size ) );
		g2.draw( new Line2D.Float( size*x+size/2, size*y+indent, size*x+size/2, size*y+size-indent) );
		g2.draw( new Line2D.Float( size*x+indent, size*y+size/2, size*x+size-indent, size*y+size/2) );
	}
}
