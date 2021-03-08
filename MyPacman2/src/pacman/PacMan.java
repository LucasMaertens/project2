package pacman;

/**
 * Each instance of this class represents the player-controlled Pac-Man character in a Pac-Man maze.
 */
public class PacMan {
	/**
	 * @invar | nblives>=0
	 * @invar | square!=null
	 */
	private int nblives;
	private Square square;
	
	public Square getSquare() { 
		return square;
	}
	
	public int getNbLives() { return nblives; }
	/**
	 * 
	 * @pthrow IllegalArgumentException | nbLives<=0 || square==null
	 * @post | getNbLives()==nbLives
	 * @post | getSquare()==square
	 * 	 */

	public PacMan(int nbLives, Square square) {
		if (nbLives<=0)
			throw new IllegalArgumentException("nblives must be greater than zero");
		if (square==null)
			throw new IllegalArgumentException("square can't be null");
		this.nblives=nbLives;
		this.square=square;
	}
	/**
	 * 
	 * @throws IllegalArgumentException| square==null
	 * @post| getSquare()==square
	 */
	public void setSquare(Square square) { 
		if(square==null)
			throw new IllegalArgumentException("Square is not allowed to be null.");
		this.square=square;
	}
	
	/**
	 * Decreases this Pac-Man character's number of lives by one.
	 * @post | getNbLives()==old(getNbLives())-1
	 * @throws RuntimeException | getNbLives()==1
	 * 
	 */
	public void die() {
		if (this.nblives==1)
			throw new RuntimeException("Game Over");
		else
			nblives--;
	}

}
