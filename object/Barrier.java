package object;

import java.awt.Graphics;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import cell.BarrierCell;
import cell.Cell;
import util.GlobalPreferences;
import draw.Drawable;

public class Barrier implements Drawable {

	private Set<BarrierCell> barrierSet;
	private Random random;
	
	public Barrier() {
		barrierSet = new HashSet<>( GlobalPreferences.getAmountOfBarriers() );
		random = new Random();

		int amountOfBarriers = 0;
		int blockWidth = GlobalPreferences.getWidth() / 4;
		int blockHeight = GlobalPreferences.getHeight() / 4;
		while ( true ) {
			int x = randomX();
			int y = randomY();
			for ( int j = y; j < y + blockHeight && j < GlobalPreferences.getHeight(); j++ ) {
				for ( int i = x; i < x + blockWidth && i < GlobalPreferences.getWidth(); i++ ) {
					if( bernoulli(0.5) && barrierSet.add(new BarrierCell(i,j))
							&& ++amountOfBarriers >= GlobalPreferences.getAmountOfBarriers() ) {
						return;
					}
				}
			}
		}
	}
	
	public boolean contains( Cell cell ) {
		return barrierSet.contains( cell );
	}
	
	@Override
	public void draw( Graphics g ) {
		for( BarrierCell cell : barrierSet ) {
			cell.draw(g);
		}
	}
	
	private int randomX() {
		return (int) ( random.nextDouble() * GlobalPreferences.getWidth() );
	}
	
	private int randomY() {
		return (int) ( random.nextDouble() * GlobalPreferences.getHeight() );
	}
	
	private boolean bernoulli( double success ) {
		return random.nextDouble() < success ? true : false;
	}
}
