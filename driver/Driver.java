package driver;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Set;

import cell.Cell;
import cell.SnakeCell;
import object.Barrier;
import object.Food;
import object.Snake;
import util.Direction;
import util.GlobalPreferences;

public class Driver {
	
	private Random random;
	private Snake snake;
	private Barrier barrier;
	private Food food;
	private Set<Cell> reachableCells;
	
	public Driver() {
		random = new Random();
		barrier = new Barrier();
		initSnake();
		initReachableCells();
		food = new Food( getReasonableFoodPosition() );
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
	
	private void initSnake() {
		boolean snakePositionFound = false;
		while( !snakePositionFound ) {
			SnakeCell snakeCell = new SnakeCell( (int)(random.nextDouble()*GlobalPreferences.getWidth()), (int)(random.nextDouble()*GlobalPreferences.getHeight()), Direction.RIGHT );
			snake = new Snake( snakeCell, Direction.RIGHT );
			snakePositionFound = true;
			for(int i=0; i<5; i++) {
				if( barrier.contains(snakeCell) ) {
					snakePositionFound = false;
					break;
				}
				snakeCell.move();
			}
		}
	}
	
	private void initReachableCells() {
		reachableCells = new HashSet<Cell>();
		Queue<Cell> queue = new LinkedList<Cell>();
		
		reachableCells.add( snake.getHeadCell() );
		queue.add( snake.getHeadCell() );
		
		while( queue.peek()!=null ) {
			Cell currentCell = queue.poll();
			if( currentCell.getY()+1 < GlobalPreferences.getHeight() ) {
				Cell downCell = new Cell( currentCell.getX(), currentCell.getY()+1 );
				if( !barrier.contains(downCell) && reachableCells.add( downCell ) ) {
					queue.add( downCell );
				}
			}
			if( currentCell.getY()-1 >= 0 ) {
				Cell upCell = new Cell( currentCell.getX(), currentCell.getY()-1 );
				if( !barrier.contains(upCell) && reachableCells.add(upCell) ) {
					queue.add( upCell );
				}
			}
			if( currentCell.getX()+1 < GlobalPreferences.getWidth() ) {
				Cell rightCell = new Cell( currentCell.getX()+1, currentCell.getY() );
				if( !barrier.contains(rightCell) && reachableCells.add(rightCell) ) {
					queue.add( rightCell );
				}
			}
			if( currentCell.getX()-1 >= 0 ) {
				Cell leftCell = new Cell( currentCell.getX()-1, currentCell.getY() );
				if( !barrier.contains(leftCell) && reachableCells.add(leftCell) ) {
					queue.add( leftCell );
				}
			}
		}
	}
	
	private Cell getReasonableFoodPosition() {
		Cell cell;
		do {
			cell = new Cell( (int)(random.nextDouble()*GlobalPreferences.getWidth()), (int)(random.nextDouble()*GlobalPreferences.getHeight()) );
		} while( !reachableCells.contains(cell) || snake.contains(cell) || food.equals(cell) );
		return cell;
	}
}
