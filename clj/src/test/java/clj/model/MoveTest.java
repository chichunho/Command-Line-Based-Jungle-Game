package clj.model;
import clj.controller.Coordinate;
import clj.controller.Player;
import clj.view.View;
import clj.controller.Request;
import org.junit.Before;

import static org.junit.Assert.*;
import org.junit.Test;

public class MoveTest {
    /**
     *
     * This unit test tests the following movements of the pieces
     *
     * 1. Pieces can only move inside board
     * 2. rat can move to the water
     * 3. Lion and tiger can jump over the water
     * 4. If there is rat in the water, lion and tiger can not jump over the water
     *
     *
     */
    PieceTest[]  allAnimals = {new RatTest(1),
                                new CatTest(1),
                                new DogTest(1),
                                new WolfTest(1),
                                new LeopardTest(1),
                                new TigerTest(1),
                                new LionTest(1),
                                new ElephantTest(1)};

    BoardTest testBoard = new BoardTest();

    Coordinate topLeft, topRight, bottomLeft, bottomRight;
    Coordinate waterLeft,waterBottom;

    Request testRequest;
    View testView;
    ModelTest testModel = new ModelTest(testView);
    Player testPlayer = new Player("test",0);

    @Before
    public void setUp() throws Exception {
        // the corners of the game board
        topLeft = new Coordinate(0,0);
        topRight = new Coordinate(0,6);
        bottomLeft = new Coordinate(8,0);
        bottomRight = new Coordinate(8,6);

        waterLeft = new Coordinate(4,0);
        waterBottom = new Coordinate(6,1);

        testBoard.setPiece(allAnimals[0],waterBottom);
        testBoard.setPiece(allAnimals[1],topLeft);
        testBoard.setPiece(allAnimals[2],topRight);
        testBoard.setPiece(allAnimals[3],bottomLeft);
        testBoard.setPiece(allAnimals[4],bottomRight);
        testBoard.setPiece(allAnimals[5],waterLeft);
    }

    /**
     * Functionality:
     * This is testing if the out-of-bound checks are correctly done
     * Expected:
     * The function shall return false if the moves is out of bound
     */
    @Test
    public void outOfBoundTest(){
        //top Left
        assertFalse(testModel.testIsOutOfBound(topLeft,-1,0));
        assertFalse(testModel.testIsOutOfBound(topLeft,0,-1));

        //top right
        assertFalse(testModel.testIsOutOfBound(topRight,1,0));
        assertFalse(testModel.testIsOutOfBound(topRight,0,-1));

        //bottom left
        assertFalse(testModel.testIsOutOfBound(bottomLeft,-1,0));
        assertFalse(testModel.testIsOutOfBound(bottomLeft,0,1));

        //bottom right
        assertFalse(testModel.testIsOutOfBound(bottomRight,1,0));
        assertFalse(testModel.testIsOutOfBound(bottomRight,0,1));
    }

    /**
     * Functionality:
     * This is testing if the rat can move to water square
     * Expected:
     * The rat shall be able to move to water square
     */
    @Test
    public void ratWaterTest(){
        assertTrue(testModel.testIsOutOfBound(bottomRight,1,0));
    }

    @Test
    public void JumpWaterTest(){
        Coordinate finalPos = new Coordinate(4,3);
        assertTrue(testModel.testIsOutOfBound(waterLeft,0,1));
        assertEquals("Tiger", testBoard.getPosPiece(finalPos));
    }

    @Test public void JumpRatTest(){
        //move rat to water
        //testRequest = new Request(testIsOutOfBounder,waterBottom,1,0);
        //request tiger jump over water
        //testRequest = new Request(testIsOutOfBounder,waterLeft,0,1);
        assertFalse(testModel.testIsOutOfBound(waterLeft,0,1));

    }

}
