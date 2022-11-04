package clj.model;

import clj.controller.Coordinate;
import clj.controller.Player;
import clj.controller.Request;
import clj.view.View;



import org.junit.Before;

import static org.junit.Assert.*;
import org.junit.Test;

/*
Tests for checking winner
 */

public class WinTest {
    /**
     *          ————————————————
     *          | C1 | DEN| C2 |
     *          ————————————————
     *               | C3 |
     *               —————
     *
     *  Ccoordinte c1 is position from the left of den
     *  Coordinate c2 is position from the right of den
     *  Coordinate c3 is position from the bottom of den
     */
    Coordinate c1,c2,c3,c4;
    PieceTest p1,p2;
    View testView;
    ModelTest testModel = new ModelTest(testView);
    BoardTest testBoard = new BoardTest();

    Request testRequest;
    Player testPlayer;
    Response testResponse;
    @Before
    public void setUp() throws Exception {
        c1 = new Coordinate(0,2);
        c2 = new Coordinate(0,4);
        c3 = new Coordinate(1,3);

        c4 = new Coordinate(2,3); //this coordinate is set under c3
        p1 = new LionTest(1);
        p2 = new RatTest(2);
        testBoard.setPiece(p1,c4);
        testBoard.setPiece(p2,c3);

    }


    @Test
    public void testRemainingPieces() {
        /**
         * It simulates two players have 1 remaining piece on the game board
         * When one player capture the other piece, model shall identify and response shall be stated the game is ended to view.
         */
        testRequest = new Request(testPlayer,c4,0,1);
        testResponse = testModel.run(testRequest);
        assertTrue(testResponse.getIsEndGame());
        /**
         * If the player didnt capture other piece, then all players at least have 1 piece on board
         * model shall identify and response shall be stated that the game continues
         */
        testRequest = new Request(testPlayer,c4, 0,-1);
        testResponse = testModel.run(testRequest);
        assertFalse(testResponse.getIsEndGame());
    }
    @Test
    public void testPiecesToDen(){

        /**
         * test if the response indicates the game end when pieces move to the den
         *
         *  First, controller send request to model, asking to move a piece from a party to the direction.
         *  if the piece move to den, response should state that the game is ended.
         */
        testRequest = new Request(testPlayer, c1, 1,0);
        testResponse = testModel.run(testRequest);
        assertTrue(testResponse.getIsEndGame());

        testRequest = new Request(testPlayer, c2, -1,0);
        testResponse = testModel.run(testRequest);
        assertTrue(testResponse.getIsEndGame());

        testRequest = new Request(testPlayer,c3,0,1);
        testResponse = testModel.run(testRequest);
        assertTrue(testResponse.getIsEndGame());

        /**
         * test if the response indicate the game continue
         */

        testRequest = new Request(testPlayer, c1, 0,-1);
        testResponse = testModel.run(testRequest);
        assertFalse(testResponse.getIsEndGame());

        testRequest = new Request(testPlayer, c2, 1,0);
        testResponse = testModel.run(testRequest);
        assertFalse(testResponse.getIsEndGame());

        testRequest = new Request(testPlayer,c3,0,-1);
        testResponse = testModel.run(testRequest);
        assertFalse(testResponse.getIsEndGame());

    }
}