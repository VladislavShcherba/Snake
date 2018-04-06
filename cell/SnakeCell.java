package cell;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import util.Direction;
import util.GlobalPreferences;

public class SnakeCell extends Cell {
	
	protected Direction direction;
	protected boolean head;

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
	
	public SnakeCell( SnakeCell cell ) {
		super(cell);
		direction = cell.direction;
		head = cell.head;
	}
	
	public void move() {
		switch(direction) {
		case DOWN:
			y += 1;
			break;
		case LEFT:
			x -= 1;
			break;
		case RIGHT:
			x += 1;
			break;
		case UP:
			y -= 1;
			break;
		default:
			break;
		}
	}
	
	public Direction getDirection() {
		return direction;
	}
	
	public boolean isHead() {
		return head;
	}
	
	public Direction setDirection( Direction direction ) {
		Direction oldDirection = this.direction;
		this.direction = direction;
		return oldDirection;
	}
	
	public boolean setHead( boolean head ) {
		boolean oldHead = this.head;
		this.head = head;
		return oldHead;
	}

	@Override
	public void draw( Graphics g ) {
		Graphics2D g2 = (Graphics2D) g;
		int size = GlobalPreferences.DEFAULT_CELL_SIZE;
		int indent = size / 3;
		g2.setColor(Color.BLACK);
		g2.fill( new Rectangle2D.Float( size*x+1, size*y+1, size-1, size-1 ) );
		g2.setColor(Color.WHITE);
		GeneralPath rhombus = new GeneralPath();
		rhombus.moveTo(size*x+size/2, size*y);
		rhombus.lineTo(size*x+size, size*y+size/2);
		rhombus.lineTo(size*x+size/2, size*y+size);
		rhombus.lineTo(size*x, size*y+size/2);
		rhombus.closePath();
		g2.draw( rhombus );
		
		if( head ) {
			g2.draw( new Line2D.Float( size*x+size/2, size*y+indent, size*x+size/2, size*y+size-indent) );
			g2.draw( new Line2D.Float( size*x+indent, size*y+size/2, size*x+size-indent, size*y+size/2) );
		}
	}
}
