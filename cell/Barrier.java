package cell;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import util.GlobalPreferences;
import draw.Drawable;

public class Barrier implements Drawable {

	private List<BarrierCell> barrierList;
	private Random random;
	
	public Barrier() {
		barrierList = new ArrayList<>( GlobalPreferences.AMOUNT_OF_BARRIERS );
		random = new Random();
		for( int i=0; i<barrierList.size(); ) {
			int x = (int) ( GlobalPreferences.DEFAULT_WIDTH * random.nextDouble() );
			int y = (int) ( GlobalPreferences.DEFAULT_HEIGHT * random.nextDouble() );
			barrierList.add( new BarrierCell(x,y) );
		}
	}
	
	private boolean bernoulli( double success ) {
		return random.nextDouble() < success ? true : false;
	}
	
	@Override
	public void draw( Graphics g ) {
		
	}
}
