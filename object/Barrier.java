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

	private Random random;
	private Set<BarrierCell> barrierSet;
	
	public Barrier() {
		random = new Random();
		barrierSet = new HashSet<>( GlobalPreferences.getAmountOfBarriers() );

		int amountOfBarriers = 0;
		int blockWidth = GlobalPreferences.getWidth() / 4;
		int blockHeight = GlobalPreferences.getHeight() / 4;
		while ( true ) {
			int x = randomX();
			int y = randomY();
			for ( int j = y; j < y + blockHeight && j < GlobalPreferences.getHeight(); j+=2 ) {
				for ( int i = x; i < x + blockWidth && i < GlobalPreferences.getWidth(); i+=2 ) {
					if( bernoulli(0.5) ) {
						if( barrierSet.add(new BarrierCell(i,j)) ) {
							barrierSet.add(new BarrierCell(i+1,j));
							barrierSet.add(new BarrierCell(i,j+1));
							barrierSet.add(new BarrierCell(i+1,j+1));
							amountOfBarriers += 4;
							if( amountOfBarriers >= GlobalPreferences.getAmountOfBarriers() ) {
								return;
							}
						}
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
		return ( (int)( random.nextDouble() * GlobalPreferences.getWidth()/2 ) ) * 2;
	}
	
	private int randomY() {
		return ( (int)( random.nextDouble() * GlobalPreferences.getHeight()/2 ) ) * 2;
	}
	
	private boolean bernoulli( double success ) {
		return random.nextDouble() < success ? true : false;
	}
}
