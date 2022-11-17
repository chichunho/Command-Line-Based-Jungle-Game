package clj.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import clj.controller.Coordinate;

public class UnitTestBoardTest {

    Coordinate c1, c2;
    PieceTest p1lion, p2rat;
    BoardTest testBoard;

    @Before
    public void init(){
        c1 = new Coordinate("D8");
        c2 = new Coordinate("D7");

        testBoard = new BoardTest();
        testBoard.testEmptyBoardPieces();
        p1lion = new LionTest(1);
        p1lion.setTrapped(true);
        p2rat = new RatTest(2);
        // Lion at D7
        testBoard.testSetPiece(p1lion,c2);
        // Rat at D8
        testBoard.testSetPiece(p2rat,c1);
    }

    /**
     * Functionality:
     * This is testing if the initialize process executed properly
     */
    @Test
    public void BoardInitializeTest()
    {
        BoardTest testboard = new BoardTest();
        assertEquals("Tiger", testboard.pick((new Coordinate("A1"))).getAnimal());
        assertEquals("Tiger", testboard.pick((new Coordinate("G9"))).getAnimal());

        assertEquals("Elephant", testboard.pick((new Coordinate("A3"))).getAnimal());
        assertEquals("Elephant", testboard.pick((new Coordinate("G7"))).getAnimal());

        assertEquals("Cat", testboard.pick((new Coordinate("B2"))).getAnimal());
        assertEquals("Cat", testboard.pick((new Coordinate("F8"))).getAnimal());

        assertEquals("Wolf", testboard.pick((new Coordinate("C3"))).getAnimal());
        assertEquals("Wolf", testboard.pick((new Coordinate("E7"))).getAnimal());

        assertEquals("Leopard", testboard.pick((new Coordinate("E3"))).getAnimal());
        assertEquals("Leopard", testboard.pick((new Coordinate("C7"))).getAnimal());

        assertEquals("Dog", testboard.pick((new Coordinate("F2"))).getAnimal());
        assertEquals("Dog", testboard.pick((new Coordinate("B8"))).getAnimal());

        assertEquals("Lion", testboard.pick((new Coordinate("G1"))).getAnimal());
        assertEquals("Lion", testboard.pick((new Coordinate("A9"))).getAnimal());

        assertEquals("Rat", testboard.pick((new Coordinate("G3"))).getAnimal());
        assertEquals("Rat", testboard.pick((new Coordinate("A7"))).getAnimal());

    }

    /**
     * Functionality:
     * This is testing if the board update the counting when a piece is removeed from the board
     */
    @Test
    public void boardChangeAfterCapture(){
        testBoard.move(c1, c2);
        // the piece count of opposite party shall be 0
        assertEquals(0, testBoard.getPieceCount()[0]);
    }
}
