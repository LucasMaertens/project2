package pacman;

import java.util.Arrays;

/**
 * Each instance of this class represents a position in a maze, specified by a row index and a column index.
 * The top row and the leftmost column have index 0.
 * @invar|getColumnIndex()>=0
 * @invar | getRowIndex()>=0
 * @immutable // ben je dit zeker?
 *
 */
public class Square {
	
	/**
	 * @invar | columnindex>=0
	 * @invar | rowindex>=0
	 *
	 */
	private MazeMap mazemap;
	private int rowindex;
	private int columnindex;
	/**
	 * @basic
	 * @creates| mazemapwerk
	 */
	public MazeMap getMazeMap() {
		MazeMap mazemapwerk=mazemap;
		return mazemap; 
		}
	/**
	 * 
	 * @basic
	 */
	public int getRowIndex() { return rowindex; }
	/**
	 * 
	 * @basic
	 */
	public int getColumnIndex() { return columnindex; }
	
	/**
	 *
	 * @inspects |this
	 * @post| result==getMazeMap().isPassable(getRowIndex(),getColumnIndex())
	 * @creates|result
	 */
	public boolean isPassable() { 
		return getMazeMap().isPassable(this.getRowIndex(),this.getColumnIndex()); }
	/**
	 * @creates |werksquare
	 * @post | result!=null
	 * @post | result.getRowIndex()==rowIndex
	 * @post | result.getColumnIndex()==columnIndex
	 * @post | result.getMazeMap()==mazeMap
	 * @throws IllegalArgumentException| rowIndex>=mazeMap.getHeight() ||  columnIndex>=mazeMap.getWidth()
	 * @throws IllegalArgumentException | columnIndex<0
	 * @throws IllegalArgumentException | rowIndex<0
	 * 
	 * @inspects| rowIndex,columnIndex //mazemap kan hier niet staan wordt onderlijnd
	 * //@mutates werksquare PAKT HIJ NIET+foutmelding dat het niet mag
	 */
	
	public static Square of(MazeMap mazeMap, int rowIndex, int columnIndex) {
		if (rowIndex<0)
			throw new IllegalArgumentException("rowIndex must be greater of equal to 1");
		if(columnIndex<0)
			throw new IllegalArgumentException("columnIndex must be greater of equal to 1");
		if(columnIndex>=mazeMap.getWidth())
			throw new IllegalArgumentException("columnIndex can't be greater than the width of mazemap");
		if (rowIndex>=mazeMap.getHeight())
			throw new IllegalArgumentException("rowIndex can't be greater than height of mazemap");
		if (mazeMap instanceof MazeMap==false)
			throw new IllegalArgumentException("mazemap must be not null");
		
		Square werksquare =new Square();
		werksquare.columnindex=columnIndex;
		werksquare.rowindex=rowIndex;
		werksquare.mazemap=mazeMap;
		return werksquare;
	}
	
	/**
	 * 
	 * Returns this square's neighbor in the given direction.
	 * If this square has no neigbor in the given direction, return the square that is furthest away in the opposite direction.
	 * 
	 */
	// No formal documentation required
	public Square getNeighbor(Direction direction) {
		// Implementation hint: use method java.lang.Math.floorMod.
		Square buur = new Square();
		
		
		if (direction==Direction.RIGHT) 
			if(Math.floorMod(getColumnIndex(),mazemap.getWidth()-1)!=0)
					
					buur=Square.of(mazemap, getRowIndex(), getColumnIndex()+1);
			else 
				if(getColumnIndex()==0)
					buur=Square.of(mazemap, getRowIndex(), getColumnIndex()+1);
				else
					buur=Square.of(mazemap, getRowIndex(), 0);
		
		if (direction==Direction.LEFT)
			
			if(Math.floorMod(getColumnIndex(),mazemap.getWidth()-1)==0)
				if (getColumnIndex()==0)
				
					buur=Square.of(mazemap, getRowIndex(), mazemap.getWidth()-1);
				else
					buur=Square.of(mazemap, getRowIndex(), getColumnIndex()-1);
			else 
				buur=Square.of(mazemap, getRowIndex(), getColumnIndex()-1);
		if(direction==Direction.UP)
			if(Math.floorMod(getRowIndex(),mazemap.getHeight()-1)==0)
				if( getRowIndex()==0)
					buur=Square.of(mazemap,  mazemap.getHeight()-1, getColumnIndex());
				else	
					buur=Square.of(mazemap, getRowIndex()-1, getColumnIndex());
				
			else 
				buur=Square.of(mazemap, getRowIndex()-1, getColumnIndex());
		if(direction==Direction.DOWN)
			if (Math.floorMod(getRowIndex(),mazemap.getHeight()-1)==0)
				if (getRowIndex()==0)
					
					buur=Square.of(mazemap, getRowIndex()+1, getColumnIndex());
				else
					buur=Square.of(mazemap, 0, getColumnIndex());
			else
				buur=Square.of(mazemap, getRowIndex()+1, getColumnIndex());
		
		return buur;
			
			
		
		
			
	}

	/**
	 * Returns whether this square's neighbor in the given direction is passable.
	 * 
	 */
	// No formal documentation required
	public boolean canMove(Direction direction) {
	    Square buur=new Square();
		buur=getNeighbor(direction);
		
		if(buur.isPassable()==true)
			return true;
		else 
			return false;
	}

	/**
	 * Returns the directions that are different from the given excluded direction and such that the neighbor in that direction is passable.
	 * The returned array shall have no null elements and shall have no duplicates.
	 */
	// No formal documentation required
	public Direction[] getPassableDirectionsExcept(Direction excludedDirection) {
		Direction[] lijst=new Direction[3];
		int counter=0;
		
		int j=0;
		if (excludedDirection==Direction.LEFT) {
				
				if (this.canMove(Direction.values()[0])==true)
					lijst[0]=Direction.values()[0];
				
					
				if (this.canMove(Direction.values()[1])==true)
					lijst[1]=Direction.values()[1];
					
				if(this.canMove(Direction.values()[3])==true)
					lijst[2]=Direction.values()[3];
					
				for(int i=0;i<3;i++)
					if (lijst[i]==null)
						counter++;
			
				
				
		}			
					
		if(excludedDirection==Direction.RIGHT) {
					
				if (this.canMove(Direction.values()[1]))
						
					lijst[0]=Direction.values()[1];
				if (this.canMove(Direction.values()[2]))
						lijst[1]=Direction.values()[2];
				if(this.canMove(Direction.values()[3]))
						lijst[2]=Direction.values()[3];
				for(int i=0;i<3;i++)
						if (lijst[i]==null)
							counter++;
					
				
		}
		
	    if	(excludedDirection==Direction.UP) {
			if (this.canMove(Direction.values()[0]))
				lijst[0]=Direction.values()[0];
			if (this.canMove(Direction.values()[1]))
			    lijst[1]=Direction.values()[1];
			if(this.canMove(Direction.values()[2]))
				lijst[2]=Direction.values()[2];
			for(int i=0;i<3;i++)
				if (lijst[i]==null)
					counter++;
			
			
			}
			
		if (excludedDirection==Direction.DOWN) {
			if (this.canMove(Direction.values()[0]))
				lijst[0]=Direction.values()[0];
			if (this.canMove(Direction.values()[3]))
			    lijst[1]=Direction.values()[3];
			if(this.canMove(Direction.values()[2]))
				lijst[2]=Direction.values()[2];
			
			for(int i=0;i<3;i++)
				if (lijst[i]==null)
					counter++;
				
			
			}
		Direction[] nieuwelijst=new Direction[3-counter];
		for(int i=0;i<3;i++)
			if (lijst[i]!=null)
				nieuwelijst[j]=lijst[i];
				j++;
		if(counter!=0)
			return nieuwelijst;
		else
			return lijst;
		 
		 
	}
	
	/**
	 * Returns whether the given square refers to the same {@code MazeMap} object and has the same row and column index as this square. 
	 * @throws IllegalArgumentException | other==null
	 * @inspects |this
	 * @inspects| other 
	 * 
	 * 	 */
	public boolean equals(Square other) {
		if (other==null)
			throw new IllegalArgumentException("argument for method can't be null");
		if (other.getMazeMap()==mazemap && other.getRowIndex()==rowindex  && other.getColumnIndex()==columnindex)
			return true;
		else
			return false;
		
	}
	
}
