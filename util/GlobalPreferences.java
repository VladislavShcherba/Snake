package util;

public class GlobalPreferences {
	
	private int width = 80;
	private int height = 60;
	private int cellSize = 10;
	private int amountOfBarriers = 480;
	private int speed = 3;
	
	private static GlobalPreferences instance = new GlobalPreferences();
	
	private GlobalPreferences() {}
	
	public static void set( int width, int height, int cellSize, int amountOfBarriers, int speed ) {
		instance.width = width;
		instance.height = height;
		instance.cellSize = cellSize;
		instance.amountOfBarriers = amountOfBarriers; // !problem can be endless loop if more than amount of cells
		instance.speed = speed;
	}
	
	public static int setWidth( int width ) {
		int oldWidth = instance.width;
		instance.width = width;
		return oldWidth;
	}

	public static int setHeight( int height ) {
		int oldHeight = instance.height;
		instance.height = height;
		return oldHeight;
	}

	public static int setCellSize( int cellSize ) {
		int oldCellSize = instance.cellSize;
		instance.cellSize = cellSize;
		return oldCellSize;
	}

	public static int setAmountOfBarriers( int amountOfBarriers ) {
		int oldAmountOfBarriers = instance.amountOfBarriers;
		instance.amountOfBarriers = amountOfBarriers;
		return oldAmountOfBarriers;
	}

	public static int setSpeed( int speed ) {
		int oldSpeed = instance.speed;
		instance.speed = speed;
		return oldSpeed;
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
