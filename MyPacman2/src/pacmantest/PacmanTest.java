package pacmantest;

import static org.junit.jupiter.api.Assertions.*;
import pacman.MazeMap;
import pacman.PacMan;
import pacman.Square;
import pacman.Direction;
import pacman.Ghost;

import org.junit.jupiter.api.Test;

class PacmanTest {

	@Test
	void test() {
		boolean[] passable= {true,true,false,false};
		MazeMap mazemap=new MazeMap(2,2,passable);
		PacMan pacman=new PacMan(5,new Square().of(mazemap, 0, 0));
		assertEquals(true,mazemap.isPassable(0, 0));
		assertEquals(false,mazemap.isPassable(1, 1));
		assertEquals(2,mazemap.getHeight());
		assertEquals(2,mazemap.getWidth());
		assertEquals(5,pacman.getNbLives());
		pacman.die();
		
		assertEquals(4,pacman.getNbLives());
		pacman.die();
		pacman.die();
		pacman.die();
		
		assertEquals(new Square().of(mazemap, 0, 0).getMazeMap(),mazemap);
		assertEquals(new Square().of(mazemap, 1, 0).getRowIndex(),1);
		assertEquals(new Square().of(mazemap, 0, 1).getRowIndex(),0);
		assertEquals(new Square().of(mazemap, 1, 1).getColumnIndex(),1);
		assertEquals(new Square().of(mazemap, 1, 0).getColumnIndex(),0);
		assertEquals(new Square().of(mazemap, 0, 0).isPassable(),true);
		assertEquals(new Square().of(mazemap, 0, 0).equals(new Square().of(mazemap, 0, 0)),true);
		// testen va ghost
		Ghost ghost=  new Ghost(new Square().of(mazemap, 0, 0),Direction.RIGHT);
		//getdirection
		assertEquals(ghost.getDirection(),Direction.RIGHT);
		//getsquare
		assertEquals(ghost.getSquare().equals(new Square().of(mazemap, 0, 0)),new Square().of(mazemap, 0, 0).equals(ghost.getSquare()));
		//setsquare
		ghost.setSquare(new Square().of(mazemap, 1, 0));
		assertEquals(ghost.getSquare().equals(new Square().of(mazemap, 1, 0)),true);
		//setdirection
		ghost.setDirection(Direction.LEFT);
		
		// eerst terug beginnen met de Square class af te werken vooraleer door te gaan.
		
		
	}

}
