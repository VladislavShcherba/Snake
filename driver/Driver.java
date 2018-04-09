package driver;

import java.util.Random;

import cell.Cell;
import object.Barrier;
import object.Food;
import object.Snake;
import util.Direction;
import util.GlobalPreferences;

public class Driver {
	
	private Snake snake;
	private Barrier barrier;
	private Food food;
	private Random random;
	
	public Driver() {
		barrier = new Barrier();
		snake = new Snake( getReasonableSnakeInitialPosition(), Direction.RIGHT );
		food = new Food( getReasonableFoodPosition() );
		random = new Random();
	}
	
	public boolean handleNextStep() {
		boolean gameOver = false;
		if( snake.headPositionAfterMove().equals(food) ) {
			snake.growUp();
			food = new Food( getReasonableFoodPosition() );
		} else {
			if( barrier.contains(snake.headPositionAfterMove()) ) {
				gameOver = true;
			} else {
				if( snake.move() ) {
					gameOver = true;
				}
			}
		}
		return gameOver;
	}
	
	private Cell getReasonableFoodPosition() { // should be changed
		Cell cell = new Cell( (int) (random.nextDouble()*GlobalPreferences.getWidth()), (int)(random.nextDouble()*GlobalPreferences.getHeight()) );
		while( barrier.contains(cell) || snake.c) {
			
		}
	}
	
	private Cell getReasonableSnakeInitialPosition() { // should be changed
		return new Cell( 5, 5 );
	}
}
