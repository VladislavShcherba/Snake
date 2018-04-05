package cell;

import java.util.ArrayList;
import java.util.List;

import exception.DirectionChangeException;
import util.Direction;


public class Snake {
	
	private List<SnakeCell> snakeList;
	
	public Snake( int x, int y, Direction direction ) {
		snakeList = new ArrayList<SnakeCell>();
		SnakeCell headCell = new SnakeCell( x, y, direction, true );
		snakeList.add(headCell);
	}
	
	public void growUp() {
		
		int oldHeadX = snakeList.get( snakeList.size()-1 ).getX();
		int oldHeadY = snakeList.get( snakeList.size()-1 ).getY();
		Direction oldHeadDirection = snakeList.get( snakeList.size()-1 ).getDirection();
		
		int newHeadX = oldHeadX;
		int newHeadY = oldHeadY;
		switch(oldHeadDirection) {
		case DOWN:
			newHeadY += 1;
			break;
		case LEFT:
			newHeadX -= 1;
			break;
		case RIGHT:
			newHeadX += 1;
			break;
		case UP:
			newHeadY -= 1;
			break;
		default:
			break;
		}
		
		SnakeCell newHead = new SnakeCell( newHeadX, newHeadY, oldHeadDirection, true );
		snakeList.get( snakeList.size()-1 ).setHead( false );
		snakeList.add( newHead );
	}
	
	public void changeDirection( Direction direction ) throws DirectionChangeException {
		
		if ( snakeList.get( snakeList.size()-1 ).getDirection().getOpposite() == direction ) {
			throw new DirectionChangeException();
		} else {
			snakeList.get( snakeList.size()-1 ).setDirection( direction );
		}
	}
}
