package pacman;

import java.util.Arrays;

/**
 * Each instance of this class represents a position in a maze, specified by a row index and a column index.
 * The top row and the leftmost column have index 0.
 * @immutable
 */
public class Square {
	private static Square werksquare;
	/**
	 * @invar | columnindex>=0
	 * @invar | rowindex>=0
	 */
	private MazeMap mazemap;
	private int rowindex;
	private int columnindex;
	
	public MazeMap getMazeMap() {
		MazeMap mazemapwerk=mazemap;
		return mazemapwerk ; 
		}
	
	public int getRowIndex() { return rowindex; }
	
	public int getColumnIndex() { return columnindex; }
	
	/**
	 * 
	 * 
	 */
	public boolean isPassable() { return mazemap.isPassable(rowindex,columnindex); }
	/**
	 * 
	 * @post |result!=null
	 * @post | result.getRowIndex()==rowIndex
	 * @post | result.getColumnIndex()==columnIndex
	 * @post | result.getMazeMap()==mazeMap
	 * @throws IllegalArgumentException| rowIndex<0 ||columnIndex<0 ||rowIndex>mazeMap.getHeight() ||  columnIndex>mazeMap.getWidth()
	 * 
	 */
	
	public static Square of(MazeMap mazeMap, int rowIndex, int columnIndex) {
		if (rowIndex<0)
			throw new IllegalArgumentException("rowIndex must be greater of equal to 1");
		if(columnIndex<0)
			throw new IllegalArgumentException("columnIndex must be greater of equal to 1");
		if(columnIndex>mazeMap.getWidth())
			throw new IllegalArgumentException("columnIndex can't be greater than the width of mazemap");
		if (rowIndex>mazeMap.getHeight())
			throw new IllegalArgumentException("rowIndex can't be greater than height of mazemap");
		
		
		Square werksquare =new Square();
		werksquare.columnindex=columnIndex;
		werksquare.rowindex=rowIndex;
		werksquare.mazemap=mazeMap;
		return werksquare;
	}
	
	/**
	 * Returns this square's neighbor in the given direction.
	 * If this square has no neigbor in the given direction, return the square that is furthest away in the opposite direction.
	 */
	// No formal documentation required
	public Square getNeighbor(Direction direction) {throw new RuntimeException("Not yet implemented");
		// Implementation hint: use method java.lang.Math.floorMod.
		
		
			
	}

	/**
	 * Returns whether this square's neighbor in the given direction is passable.
	 */
	// No formal documentation required
	public boolean canMove(Direction direction) {
		throw new RuntimeException("Not yet implemented");
	}

	/**
	 * Returns the directions that are different from the given excluded direction and such that the neighbor in that direction is passable.
	 * The returned array shall have no null elements and shall have no duplicates.
	 */
	// No formal documentation required
	public Direction[] getPassableDirectionsExcept(Direction excludedDirection) {
		throw new RuntimeException("Not yet implemented");
	}
	
	/**
	 * Returns whether the given square refers to the same {@code MazeMap} object and has the same row and column index as this square. 
	 * @throws IllegalArgumentException | other==null
	 * @inspects |this
	 * @inspects| other 
	 */
	public boolean equals(Square other) {
		if (other==null)
			throw new IllegalArgumentException("argument for method can't be null");
		if (other.getMazeMap()==mazemap && other.getRowIndex()==rowindex  && other.getColumnIndex()==columnindex)
			return true;
		else
			return false;
		
	}
	
}
