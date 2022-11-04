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
    PieceTest[]  allAnimals = {new RatTest(1),new CatTest(1),new DogTest(1), new WolfTest(1),new LeopardTest(1),new TigerTest(1),
                                new LionTest(1),new ElephantTest(1)};
    BoardTest testBoard = new BoardTest();

    Coordinate TopLeft, TopRight, BottomLeft, BottomRight;
    Coordinate waterLeft,waterBottom;

    Request testRequest;
    View testView;
    ModelTest testModel = new ModelTest(testView);
    Player testPlayer = new Player("test",0);
    @Before
    public void setUp() throws Exception {
        TopLeft = new Coordinate(0,0);
        TopRight = new Coordinate(0,6);
        BottomLeft = new Coordinate(8,0);
        BottomRight = new Coordinate(8,6);

        waterLeft = new Coordinate(4,0);
        waterBottom = new Coordinate(6,1);

        testBoard.setPiece(allAnimals[0],waterBottom);
        testBoard.setPiece(allAnimals[1],TopLeft);
        testBoard.setPiece(allAnimals[2],TopRight);
        testBoard.setPiece(allAnimals[3],BottomLeft);
        testBoard.setPiece(allAnimals[4],BottomRight);
        testBoard.setPiece(allAnimals[5],waterLeft);
    }
    @Test
    public void outOfBoundTest(){
        //Top Left
        testRequest = new Request(testPlayer,TopLeft,1,0);
        assertFalse(testModel.testPlay(TopLeft,1,0));

        testRequest = new Request(testPlayer,TopLeft,0,-1);
        assertFalse(testModel.testPlay(TopLeft,0,-1));
        //top right
        testRequest = new Request(testPlayer,TopRight,1,0);
        assertFalse(testModel.testPlay(TopRight,1,0));

        testRequest = new Request(testPlayer,TopRight,0,1);
        assertFalse(testModel.testPlay(TopRight,0,1));
        //bottom left
        testRequest = new Request(testPlayer,BottomLeft,-1,0);
        assertFalse(testModel.testPlay(BottomLeft,-1,0));

        testRequest = new Request(testPlayer,BottomLeft,0,-1);
        assertFalse(testModel.testPlay(BottomLeft,0,-1));
        //bottom right
        testRequest = new Request(testPlayer,BottomRight,-1,0);
        assertFalse(testModel.testPlay(BottomRight,-1,0));

        testRequest = new Request(testPlayer,BottomRight,0,1);
        assertFalse(testModel.testPlay(BottomRight,0,1));


    }
    @Test
    public void ratWaterTest(){
        testRequest = new Request(testPlayer,waterBottom,1,0);
        assertTrue(testModel.testPlay(BottomRight,1,0));
    }

    @Test
    public void JumpWaterTest(){
        Coordinate finalPos = new Coordinate(4,3);
        testRequest = new Request(testPlayer,waterLeft,0,1);
        assertTrue(testModel.testPlay(waterLeft,0,1));
        assertEquals("Tiger", testBoard.getPosPiece(finalPos));
    }

    @Test public void JumpRatTest(){
        //move rat to water
        testRequest = new Request(testPlayer,waterBottom,1,0);
        //request tiger jump over water
        testRequest = new Request(testPlayer,waterLeft,0,1);
        assertFalse(testModel.testPlay(waterLeft,0,1));

    }

}
