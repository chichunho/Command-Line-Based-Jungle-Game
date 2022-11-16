package clj.model;

import clj.controller.Coordinate;
import clj.controller.PlayerTest;
import clj.controller.RequestTest;
import clj.view.View;



import org.junit.Before;

import static org.junit.Assert.*;
import org.junit.Test;

/*
Tests for checking winner
 */

public class UnitTestWinTest {
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
    BoardTest testBoard = new BoardTest();
    ModelTest testModel = new ModelTest(testBoard);

    RequestTest testRequest;
    PlayerTest testPlayer;
    Response testResponse;
    
    @Before
    public void setUp(){
        c1 = new Coordinate("C9");
        c2 = new Coordinate("E9");
        c3 = new Coordinate("D8");

        c4 = new Coordinate("D7"); //this coordinate is set under c3
        p1 = new LionTest(1);
        p2 = new RatTest(2);

        testBoard.testEmptyBoardPieces();
        // Lion at D7
        testBoard.testSetPiece(p1,c4);
        // Rat at D8
        testBoard.testSetPiece(p2,c3);
    }

    /**
     * Functionality:
     * This is testing if the model can identify a player have no more pieces to play, and
     * report the game ends
     * Expected:
     * If a player has no more pieces to play, the game shall end, otherwise
     * the game shall continue
     */
    @Test
    public void testNoPieceRemain() {
        /**
         * It simulates two players have 1 remaining piece on the game board
         * When one player capture the other piece, model shall identify and response shall be stated the game is ended to view.
         */
        PlayerTest testPlayer = new PlayerTest("test", 1);
        testRequest = new RequestTest(testPlayer, c4, 0, -1);
        int testRet = testModel.run(testRequest);
        assertEquals(12, testRet);
    }

    /**
     * Functionality:
     * This is testing if the model can identify a piece is moved to the opponent's den, and
     * report the game ends
     * Expected:
     * If a piece is moved to the opponent's den, the game shall end, otherwise
     * the game shall continue
     */
    @Test
    public void testPiecesToDen(){

        /**
         * test if the response indicates the game end when pieces move to the den
         *
         *  First, controller send request to model, asking to move a piece from a party to the direction.
         *  if the piece move to den, response should state that the game is ended.
         */
        PlayerTest testPlayer = new PlayerTest("test", 2);
        testRequest = new RequestTest(testPlayer, c3, 0,-1);
        int testRet = testModel.run(testRequest);
        assertEquals(10, testRet);
    }
}