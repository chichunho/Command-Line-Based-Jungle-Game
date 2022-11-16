package clj.model;
import clj.controller.Coordinate;
import clj.view.View;
import clj.controller.Request;
import org.junit.Before;

import static org.junit.Assert.*;
import org.junit.Test;

public class UnitTestMoveTest {
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
    Coordinate waterLeft,waterBottom, waterSquare;

    Request testRequest;
    View testView;
    ModelTest testModel = new ModelTest(testView);

    @Before
    public void setUp() throws Exception {
        // the corners of the game board
        topLeft = new Coordinate("A9");
        topRight = new Coordinate("G9");
        bottomLeft = new Coordinate("A1");
        bottomRight = new Coordinate("G1");

        waterLeft = new Coordinate("A6");
        waterBottom = new Coordinate("B3");
        waterSquare = new Coordinate("B6");

        testBoard.testSetPiece(allAnimals[0],waterBottom);
        testBoard.testSetPiece(allAnimals[1],topLeft);
        testBoard.testSetPiece(allAnimals[2],topRight);
        testBoard.testSetPiece(allAnimals[3],bottomLeft);
        testBoard.testSetPiece(allAnimals[4],bottomRight);
        testBoard.testSetPiece(allAnimals[5],waterLeft);
    }

    /**
     * Functionality:
     * This is testing if the out-of-bound checks are correctly done
     * Expected:
     * The function shall return true if the moves is out of bound
     */
    @Test
    public void outOfBoundTest(){
        // top Left
        // move to the left
        assertTrue(testModel.testIsOutOfBound(topLeft,-1,0));
        // move forward
        assertTrue(testModel.testIsOutOfBound(topLeft,0,-1));

        //top right
        // move to the right
        assertTrue(testModel.testIsOutOfBound(topRight,1,0));
        // move forward
        assertTrue(testModel.testIsOutOfBound(topRight,0,-1));

        //bottom left
        // move to the left
        assertTrue(testModel.testIsOutOfBound(bottomLeft,-1,0));
        // move backward
        assertTrue(testModel.testIsOutOfBound(bottomLeft,0,1));

        //bottom right
        // move to the right
        assertTrue(testModel.testIsOutOfBound(bottomRight,1,0));
        // move backward
        assertTrue(testModel.testIsOutOfBound(bottomRight,0,1));
    }

    /**
     * Functionality:
     * This is testing if the rat can move to water square
     * Expected:
     * The rat shall be able to move to water square
     */
    @Test
    public void ratWaterTest(){
        assertEquals(allAnimals[0].canMoveTo(testBoard.at(waterSquare)), 0);
    }

    // TODO fill the functionality and expected
    @Test
    public void JumpWaterTest(){
        Coordinate finalPos = new Coordinate(3,3);
        Coordinate result = allAnimals[5].calFinalDest(waterSquare, testBoard, 1, 0);
        assertEquals(result.getCol(), finalPos.getCol());
        assertEquals(result.getRow(), finalPos.getRow());
    }

    // TODO fill the functionality and expected
    @Test public void JumpRatTest(){
        Coordinate ratPos = new Coordinate("B6");
        testBoard.testSetPiece(allAnimals[0], ratPos);
        Coordinate result = allAnimals[5].calFinalDest(waterSquare, testBoard, 1, 0);
        assertEquals(result.getCol(), ratPos.getCol());
        assertEquals(result.getRow(), ratPos.getRow());
    }

}
