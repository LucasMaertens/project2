package pacman;

/**
 * Each instance of this class represents a maze layout, specifying the width and height of the maze
 * and, for each position in the maze, whether it is passable or not.
 */
public class MazeMap {
	//zelf geschreven
	/**
	 * @invar | width>=1
	 * @invar | height>=1
	 * @invar | passable!= null
	 * @invar | passable.length==width*height
	 */
	 
	private int width;
	private int height;
	private boolean [] passable;
	//
	/**
	 * Returns the width (i.e. the number of columns) of this maze map.
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * Returns the height (i.e. the number of rows) of this maze map.
	 */
	public int getHeight() { 
		return height;
	}
	
	/**
	 * Returns whether the square in this maze at row index {@code row} and column index {@code column} is passable.
	 * The square in the top-left corner of the maze has row index 0 and column index 0.
	 * @throws IllegalArgumentException| rowIndex<0 ||columnIndex<0 ||rowIndex>getHeight() ||  columnIndex>getWidth()
	 */
	public boolean isPassable(int rowIndex, int columnIndex) { 
		if (rowIndex<0)
			throw new IllegalArgumentException("rowIndex must be greater of equal to 1");
		if(columnIndex<0)
			throw new IllegalArgumentException("columnIndex must be greater of equal to 1");
		if(rowIndex>getWidth())
			throw new IllegalArgumentException("rowIndex must be less or equal to the width of the maze ");
		if(columnIndex>getHeight())
			throw new IllegalArgumentException("columnIndex must be less or equal to height of the maze");
		if (passable[(rowIndex+columnIndex)+(rowIndex*(width-1))]==true)
			return true;
		else 
			return false;
	}
	
	/**
	 * Initializes this object so that it represents a maze layout with the given width, height, and
	 * passable positions. The passable positions are given in row-major order (i.e. the first {@code width} elements
	 * of {@code passable} specify the passability of the maze positions in the first row of the maze). 
	 * @throws IllegalArgumentException| width<1||height<1||passable.length<height*width || passable== null
	 * @post | getHeight()==height
	 * @post | getWidth()==width
	 * @post | getHeight()*getWidth()==passable.length
	 
	 * 
	 */
	public MazeMap(int width, int height, boolean[] passable) {
		if (width<1)
			throw new IllegalArgumentException("width must be greater of equal to 1");
		if (height<1 )
			throw new IllegalArgumentException("height must be greater of equal to 1");
		if (passable.length<height*width)
			throw new IllegalArgumentException("length of row major order passable must be greater of equal to height*width");
		this.width=width;
		this.height=height;
		this.passable=passable;
			
	}
	
}
