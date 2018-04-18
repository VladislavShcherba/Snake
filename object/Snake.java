package object;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import cell.Cell;
import cell.SnakeCell;
import draw.Drawable;
import util.Direction;


public class Snake implements Drawable {
	
	private List<SnakeCell> snakeList;
	
	public Snake( int x, int y, Direction direction ) {
		snakeList = new ArrayList<SnakeCell>();
		SnakeCell headCell = new SnakeCell( x, y, direction, true );
		snakeList.add(headCell);
	}
	
	public Snake( Cell cell, Direction direction ) {
		snakeList = new ArrayList<SnakeCell>();
		SnakeCell headCell = new SnakeCell( cell, direction, true );
		snakeList.add(headCell);
	}
	
	public void growUp() {
		SnakeCell newHead = new SnakeCell( snakeList.get(snakeList.size()-1) );
		snakeList.get( snakeList.size()-1 ).setHead(false);
		newHead.move();
		snakeList.add( newHead );
	}
	
	public void changeDirection( Direction direction ) {	
			snakeList.get( snakeList.size()-1 ).setDirection( direction );
	}
	
	public boolean move() {
		Direction oldDirection = snakeList.get( snakeList.size()-1 ).getDirection();
		for( int i = snakeList.size()-1; i>=0; i-- ) {
			snakeList.get(i).move();
			oldDirection = snakeList.get(i).setDirection(oldDirection);
		}
		
		for ( int i=0; i<snakeList.size(); i++ ) {
			for ( int j=i+1; j<snakeList.size(); j++) {
				if ( snakeList.get(i).getX()==snakeList.get(j).getX()
						&& snakeList.get(i).getY()==snakeList.get(j).getY() ) {
					return true;
				}
			}
		}
		return false;
	}
	
	public Cell getHeadCell() {
		return new Cell( snakeList.get(snakeList.size()-1) );
	}
	
	public Cell headPositionAfterMove() {
		return snakeList.get( snakeList.size()-1 ).cellPositionAfterMove();
	}
	
	public Direction getDirection() {
		return snakeList.get( snakeList.size()-1 ).getDirection();
	}
	
	public boolean contains( Cell cell ) {
		for( Cell snakeCell : snakeList ) {
			if( snakeCell.equals(cell) ) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void draw( Graphics g ) {
		for( SnakeCell snakeCell : snakeList ) {
			snakeCell.draw( g );
		}
	}
}
