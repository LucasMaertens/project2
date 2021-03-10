package pacman;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;
import pacman.Square;
import pacman.PacMan;
import pacman.Dot;
import pacman.MazeMap;
import pacman.Ghost;

class SquareTest {
	boolean[] passable= {true,true,false,false,true,true};
	MazeMap mazemap=new MazeMap(3,2,passable);
	Square vierkant =new Square();
	Square vierkant2=new Square();
	Square vierkant3=new Square();
	Square vierkant4=new Square();
	Square vierkant5=new Square();
	Square vierkant6=new Square();
	
	@Test
	void of() {
		
		vierkant =Square.of(mazemap, 0, 0);
		vierkant2=Square.of(mazemap, 0, 1);
		vierkant3=Square.of(mazemap, 0, 2);
		vierkant4=Square.of(mazemap, 1, 0);
		vierkant5=Square.of(mazemap, 1, 1);
		vierkant6=Square.of(mazemap, 1, 2);
		
		//Square vierkantfout=Square.of(mazemap, -1, 0);
		//Square vierkantfout2=Square.of(mazemap, 1, 4);
		//Square vierkantfout3=Square.of(null, 1, 0);
	}
	@Test	
	void ispassable() {
		
		vierkant3=Square.of(mazemap, 0, 2);
	
		vierkant6=Square.of(mazemap, 1, 2);
		assertEquals(new Square().of(mazemap, 1, 1).isPassable(),true);
		assertEquals(vierkant6.isPassable(),true);
		assertEquals(vierkant3.isPassable(),false);
	}
	@Test
	void getheight() {
		assertEquals(2,mazemap.getHeight());
	}
	@Test
	void getwidth() {
		assertEquals(3,mazemap.getWidth());
	}
	
	@Test	
	void getmazemap() {	
		vierkant =Square.of(mazemap, 0, 0);
		
		assertEquals(vierkant.getMazeMap(),mazemap);
}
	@Test
	void getrowindex() {
		
		vierkant2=Square.of(mazemap, 0, 1);
		vierkant3=Square.of(mazemap, 0, 2);
		
		assertEquals(vierkant2.getRowIndex(),0);
		assertEquals(vierkant3.getRowIndex(),0);
	
	}
	@Test
	void getcolumnidex() {
		
		vierkant6=Square.of(mazemap, 1, 2);
		assertEquals(vierkant6.getColumnIndex(),2);
		
	}
	@Test	
	void equals() {	
		Square vierkant=Square.of(mazemap, 0, 0);
		assertEquals(vierkant.equals(vierkant),true);
		}
	@Test
	void getbuur() {
		vierkant =Square.of(mazemap, 0, 0);
		vierkant2=Square.of(mazemap, 0, 1);
		vierkant3=Square.of(mazemap, 0, 2);
		vierkant4=Square.of(mazemap, 1, 0);
		vierkant5=Square.of(mazemap, 1, 1);
		vierkant6=Square.of(mazemap, 1, 2);
		assertEquals(vierkant.getNeighbor(Direction.LEFT).equals(vierkant3),true);
		assertEquals(vierkant4.getNeighbor(Direction.UP).equals(vierkant),true);
		assertEquals(vierkant3.getNeighbor(Direction.RIGHT).equals(vierkant),true);
		assertEquals(vierkant5.getNeighbor(Direction.DOWN).equals(vierkant2),true);
	}
		
		
		
	@Test
	void canmove() {
		vierkant =Square.of(mazemap, 0, 0);
		vierkant2=Square.of(mazemap, 0, 1);
		vierkant3=Square.of(mazemap, 0, 2);
		vierkant4=Square.of(mazemap, 1, 0);
		vierkant5=Square.of(mazemap, 1, 1);
		vierkant6=Square.of(mazemap, 1, 2);
		assertEquals(vierkant5.canMove(Direction.RIGHT),true);
		assertEquals(vierkant5.canMove(Direction.UP),true);
		assertEquals(vierkant5.canMove(Direction.DOWN),true);
		
		assertEquals(vierkant2.canMove(Direction.LEFT),true);
		assertEquals(vierkant.canMove(Direction.RIGHT),true);
		assertEquals(vierkant2.canMove(Direction.LEFT),true);
		assertEquals(vierkant6.canMove(Direction.DOWN),false);
	}
	@Test	
	void getdoorgang() {
		vierkant =Square.of(mazemap, 0, 0);
		vierkant2=Square.of(mazemap, 0, 1);
		vierkant3=Square.of(mazemap, 0, 2);
		vierkant4=Square.of(mazemap, 1, 0);
		vierkant5=Square.of(mazemap, 1, 1);
		vierkant6=Square.of(mazemap, 1, 2);
		assertEquals(Direction.UP,vierkant5.getPassableDirectionsExcept(Direction.RIGHT)[0]);
		assertEquals(3,vierkant5.getPassableDirectionsExcept(Direction.LEFT).length);
		assertEquals(0,vierkant6.getPassableDirectionsExcept(Direction.LEFT).length);
		assertEquals(Direction.RIGHT,vierkant.getPassableDirectionsExcept(Direction.UP)[0]);
		assertEquals(3,vierkant3.getPassableDirectionsExcept(Direction.DOWN).length);
	}
	
		
		
	
}
class GhostTest extends Square{
	boolean[] passable= {true,true,false,false,true,true};
	MazeMap mazemap=new MazeMap(3,2,passable);
	Square vierkant =Square.of(mazemap, 0, 0);
	Square vierkant2=Square.of(mazemap, 0, 1);
	Square vierkant3=Square.of(mazemap, 0, 2);
	Square vierkant4=Square.of(mazemap, 1, 0);
	Square vierkant5=Square.of(mazemap, 1, 1);
	Square vierkant6=Square.of(mazemap, 1, 2);
	Ghost ghost= new Ghost(vierkant,Direction.DOWN);
	Ghost ghost2=new Ghost(vierkant2,Direction.LEFT);
	Ghost ghost3=new Ghost(vierkant3,Direction.DOWN);
	@Test
	void getdirection() {assertEquals(ghost.getDirection(),Direction.DOWN);
	}
		
	@Test
	void getsquare() {
		assertEquals(ghost.getSquare().equals(new Square().of(mazemap, 0, 0)),new Square().of(mazemap, 0, 0).equals(ghost.getSquare()));
		assertEquals(ghost2.getSquare().equals(new Square().of(mazemap, 0, 1)),true);
	}
		
	@Test	
	void setsquare() {
		ghost.setSquare(vierkant2);
		assertEquals(ghost.getSquare().equals(ghost2.getSquare()),true);
	}
	@Test	
	void setdirection() {
		ghost.setDirection(Direction.LEFT);
		assertEquals(ghost.getDirection(),Direction.LEFT);
	}
	Random rnd= new Random();
	void kiesrichting() {
		assertEquals(ghost.chooseNextMoveDirection(rnd) instanceof Direction,true);
		
	}
	void Move() {
		ghost.move(rnd);
		
	}

}		
		
class Pacmantestje{
	boolean[] passable= {true,true,false,false,true,true};
	MazeMap mazemap=new MazeMap(3,2,passable);
	Square vierkant =Square.of(mazemap, 0, 0);
	Square vierkant2=Square.of(mazemap, 0, 1);
	Square vierkant3=Square.of(mazemap, 0, 2);
	Square vierkant4=Square.of(mazemap, 1, 0);
	Square vierkant5=Square.of(mazemap, 1, 1);
	Square vierkant6=Square.of(mazemap, 1, 2);
	Ghost ghost= new Ghost(vierkant,Direction.DOWN);
	Ghost ghost2=new Ghost(vierkant2,Direction.LEFT);
	Ghost ghost3=new Ghost(vierkant3,Direction.DOWN);
	
	PacMan pacman=new PacMan(5,vierkant);
	
	@Test
	void die() {
		assertEquals(5,pacman.getNbLives());
		pacman.die();
		pacman.die();
		pacman.die();
		assertEquals(2,pacman.getNbLives());
	}
	@Test
	void setsquare() {
		pacman.setSquare(vierkant2);
		assertEquals(pacman.getSquare().equals(vierkant2),true);
	}
	@Test
	void getsquare() {
		assertEquals(vierkant.getColumnIndex(),pacman.getSquare().getColumnIndex());
		assertEquals(vierkant.getRowIndex(),pacman.getSquare().getRowIndex());
		assertEquals(vierkant.equals(pacman.getSquare()),true);
	}
}

class DotTest{
	boolean[] passable= {true,true,false,false,true,true};
	MazeMap mazemap=new MazeMap(3,2,passable);
	Square vierkant =Square.of(mazemap, 0, 0);
	Dot dot=new Dot(vierkant);
	@Test
	void getsquare() {
		assertEquals(vierkant,dot.getSquare());
	}
}

class MazemapTest{
	boolean[] passable= {true,true,false,false,true,true};
	MazeMap mazemap=new MazeMap(3,2,passable);
	Square vierkant =Square.of(mazemap, 0, 0);
	
	@Test
	void getwidth() {
		assertEquals(mazemap.getWidth(),3);
	}
	@Test
	void getheight() {
		assertEquals(mazemap.getHeight(),2);
	}
	@Test
	void ispassable() {
		assertEquals(mazemap.isPassable(0, 0),true);
	}
	
}
	

	



