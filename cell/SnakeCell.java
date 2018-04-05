package cell;

import util.Direction;

public class SnakeCell extends Cell {
	
	private Direction direction;
	private boolean head;

	public SnakeCell( int x, int y, Direction direction ) {
		super( x, y );
		this.direction = direction;
		this.head = false;
	}
	
	public SnakeCell( int x, int y, Direction direction, boolean head ) {
		super( x, y );
		this.direction = direction;
		this.head = head;
	}
	
	public Direction getDirection() {
		return direction;
	}
	
	public boolean isHead() {
		return head;
	}
	
	public void setDirection( Direction direction ) {
		this.direction = direction;
	}
	
	public void setHead( boolean head ) {
		this.head = head;
	}
}
