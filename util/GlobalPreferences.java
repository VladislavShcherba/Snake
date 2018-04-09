package util;

import exception.AmountOfBarriersException;

public class GlobalPreferences {
	
	private int width = 80;
	private int height = 60;
	private int cellSize = 10;
	private int amountOfBarriers = 480;
	private int speed = 3;
	
	private static GlobalPreferences instance = new GlobalPreferences();
	
	private GlobalPreferences() {}
	
	public static void set( int width, int height, int cellSize, int amountOfBarriers, int speed ) throws AmountOfBarriersException {
		if( amountOfBarriers > width*height/2 ) {
			throw new AmountOfBarriersException();
		}
		instance.width = width;
		instance.height = height;
		instance.cellSize = cellSize;
		instance.amountOfBarriers = amountOfBarriers;
		instance.speed = speed;
	}
	
	public static int getWidth() {
		return instance.width;
	}

	public static int getHeight() {
		return instance.height;
	}

	public static int getCellSize() {
		return instance.cellSize;
	}

	public static int getAmountOfBarriers() {
		return instance.amountOfBarriers;
	}

	public static int getSpeed() {
		return instance.speed;
	}	
}
