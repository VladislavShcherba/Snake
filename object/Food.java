package object;

import java.awt.Graphics;

import cell.Cell;
import cell.FoodCell;
import draw.Drawable;

public class Food implements Drawable {
	
	private FoodCell foodCell;
	
	public Food( int x, int y ) {
		foodCell = new FoodCell( x, y );
	}
	
	public Food( Cell cell ) {
		foodCell = new FoodCell( cell );
	}

	@Override
	public void draw( Graphics g ) {
		foodCell.draw(g);
	}
}
