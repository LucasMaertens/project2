package pacman;

import java.util.Random;

/**
 * Each instance of this class represents a ghost in a Pac-Man maze.
 * 
 */

public class Ghost {
	private Square square;
	private Direction direction;
	
	/*
	 * @basic
	 */
	public Square getSquare() { return square; }
	
	/**
	 * Returns the direction in which this ghost will preferably move next.
	 *@basic
	 */
	public Direction getDirection() { 
		
		return direction;
	}
	
	/**
	 * 
	 * @throws IllegalArgumentException| square==null||direction==null
	 * @post | getSquare()==square
	 * @post | getDirection()==direction
	 */
	public Ghost(Square square, Direction direction) { 
		if (square==null)
			throw new IllegalArgumentException("square can not be null");
		if (direction==null)
			throw new IllegalArgumentException("direction can not be null");
		
		this.square=square;
		this.direction=direction;
		
	}
	/**
	 * 
	 * @throws IllegalArgumentException| (square instanceof Square)==false
	 * @post| getSquare()==square
	 * @mutates|this
	 */
	public void setSquare(Square square) {
		if (square instanceof Square)
			
			this.square=square;
		else 
			throw new IllegalArgumentException("argument must be instance of Square");
	}
	
	/**
	 * 
	 * @post | getDirection()==direction
	 * @mutates| this
	 */
	
	public void setDirection(Direction direction) { 
		
			this.direction=direction;
		
	}
	
	private static int MOVE_FORWARD_PREFERENCE = 10;
	
	// No formal document required
	public Direction chooseNextMoveDirection(Random random) {
		int moveForwardPreference = getSquare().canMove(getDirection()) ? MOVE_FORWARD_PREFERENCE : 0;
		Direction[] passableDirections = getSquare().getPassableDirectionsExcept(getDirection().getOpposite());
		if (passableDirections.length == 0)
			return getDirection().getOpposite();
		int result = random.nextInt(moveForwardPreference + passableDirections.length);
		if (result < moveForwardPreference)
			return getDirection();
		return passableDirections[result - moveForwardPreference];
	}
	
	// No formal document required
	public void move(Random random) {
		setDirection(chooseNextMoveDirection(random));
		setSquare(getSquare().getNeighbor(getDirection()));
	}
}
