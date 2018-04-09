package cell;

import java.util.Objects;

import draw.Drawable;

public abstract class Cell implements Drawable {
	
	protected int x;
	protected int y;
	
	public Cell( int x, int y ) {
		this.x = x;
		this.y = y;
	}
	
	public Cell( Cell cell ) {
		x = cell.x;
		y = cell.y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int setX( int x ) {
		int oldX = this.x;
		this.x = x;
		return oldX;
	}
	
	public int setY( int y ) {
		int oldY = this.y;
		this.y = y;
		return oldY;
	}
	
	@Override
	public boolean equals( Object otherObject ) {
		if( this == otherObject ) {
			return true;
		}
		if( otherObject == null ) {
			return false;
		}
		if( !(otherObject instanceof Cell) ) {
			return false;
		}
		
		Cell other = (Cell) otherObject;
		return x == other.x && y == other.y;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash( x, y );
	}
}
