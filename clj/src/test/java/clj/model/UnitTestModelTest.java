package clj.model;

import clj.controller.Coordinate;
import clj.controller.PlayerTest;
import clj.controller.RequestTest;

import org.junit.Before;

import static org.junit.Assert.*;
import org.junit.Test;

public class UnitTestModelTest {
    /**
     *          ————————————————
     *          | C1 | DEN| C2 |
     *          ————————————————
     *               | C3 |
     *               —————
     *               | C4 |
     *               _____
     * 
     *  Ccoordinte c1 is position from the left of den
     *  Coordinate c2 is position from the right of den
     *  Coordinate c3 is position from the bottom of den
     */
    Coordinate c1,c2,c3,c4;
    PieceTest p1lion,p2rat,p1tiger,p2cat, p2elephant, p1rat, p1cat;
    BoardTest testBoard = new BoardTest();
    ModelTest testModel = new ModelTest(testBoard);

    RequestTest testRequest;
    PlayerTest testPlayer;

    Coordinate topLeft, topRight, bottomLeft, bottomRight;
    
    @Before
    public void setUp(){
        topLeft = new Coordinate("A9");
        topRight = new Coordinate("G9");
        bottomLeft = new Coordinate("A1");
        bottomRight = new Coordinate("G1");

        c1 = new Coordinate("C9");
        c2 = new Coordinate("E9");
        c3 = new Coordinate("D8");
        c4 = new Coordinate("D7"); //this coordinate is set under c3

        p1lion = new LionTest(1);
        p2rat = new RatTest(2);
        p1tiger = new TigerTest(1);
        p2cat = new CatTest(2);
        p2elephant = new ElephantTest(2);
        p1rat = new RatTest(1);
        p1cat = new CatTest(1);

        testBoard.testEmptyBoardPieces();

        testPlayer = new PlayerTest("test", 1);
    }

    /**
     * Functionality:
     * This is testing if the out-of-bound checks are correctly done
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
     * This is testing if the model can identify that 
     * the player select a empty square
     */
    @Test
    public void testSelectEmptySquare(){
        testRequest = new RequestTest(testPlayer, topLeft, 1, 0);
        // testing if branch -> if (pickedPiece == null)
        assertEquals(1, testModel.runRequest(testRequest));
    }

    /**
     * Functionality:
     * This is testing if the model can identify that
     * the player is select a enemy piece
     */
    @Test
    public void testSelectEnemyPiece(){
        testBoard.testSetPiece(p2rat, c3);
        testRequest = new RequestTest(testPlayer, c3, 1, 0);
        // testing if branch -> if (pickedPiece.getParty() != request.getPlayerParty())
        assertEquals(2, testModel.runRequest(testRequest));
    }

    /**
     * Functionality:
     * This is testing if the model can identify that
     * the move will cause out of bound
     */
    @Test
    public void testIsOutOfBound(){
        testBoard.testSetPiece(p1lion, topLeft);
        testRequest = new RequestTest(testPlayer, topLeft, -1, 0);
        // testsing if branch -> if (isOutOfBound(dest))
        assertEquals(3, testModel.runRequest(testRequest));
    }

    /**
     * Functionality:
     * This is testing if the model can identify that
     * the player move his/her piece to his/her own den
     */
    @Test
    public void testMoveToOwnDen(){
        testBoard.testSetPiece(p1lion, c3);
        testRequest = new RequestTest(testPlayer, c3, 0, -1);
        // testing first switch branch -> case 1
        assertEquals(4, testModel.runRequest(testRequest));
    }

    /**
     * Functionality:
     * This is testing if the rat in the river mid-way can blcok the lion or tiger jump action
     */
    @Test
    public void testRatBlockJump(){
        Coordinate p2ratPos = new Coordinate("C6");
        Coordinate p1tigerPos = new Coordinate("A6");
        testBoard.testSetPiece(p2rat, p2ratPos);
        testBoard.testSetPiece(p1tiger, p1tigerPos);
        testRequest = new RequestTest(testPlayer, p1tigerPos, 1, 0);
        // testing first switch branch -> case 2
        // testing case 2 if branch -> if (pickedPiece.getAnimal().equals("Lion") ||
        //                              pickedPiece.getAnimal().equals("Tiger"))
        assertEquals(5, testModel.runRequest(testRequest));
    }

    /**
     * Functionality:
     * This is testing if the model can identify that
     * the piece is not allowed to enter river
     */
    @Test
    public void testFailEnterWater(){
        Coordinate p1catPos = new Coordinate("A6");
        testBoard.testSetPiece(p1cat, p1catPos);
        testRequest = new RequestTest(testPlayer, p1catPos, 1, 0);
        // testing first switch branch -> case 2
        assertEquals(6, testModel.runRequest(testRequest));
    }

    /**
     * Functionality:
     * This is testing if the model can identify that
     * the player want to capture a friendly piece / move to a square containing a friendly piece
     */
    @Test
    public void testCaptureFriendlyPiece(){
        Coordinate p1tigerPos = new Coordinate("A1");
        Coordinate p1lionPos = new Coordinate("B1");
        testBoard.testSetPiece(p1lion, p1lionPos);
        testBoard.testSetPiece(p1tiger, p1tigerPos);
        testRequest = new RequestTest(testPlayer, p1lionPos, -1, 0);
        // testsing second switch branch -> case 1
        assertEquals(7, testModel.runRequest(testRequest));
    }

    /**
     * Functionality:
     * This is testing if the model can identify that
     * the player is trying to capture a higher rank enemy
     */
    @Test
    public void testCaptureStrongerPiece(){
        Coordinate p1lionPos = new Coordinate("A1");
        Coordinate p2elephantPos = new Coordinate("B1");
        testBoard.testSetPiece(p1lion, p1lionPos);
        testBoard.testSetPiece(p2elephant, p2elephantPos);
        testRequest = new RequestTest(testPlayer, p1lionPos, 1, 0);
        // testing second switch branch -> case 2
        assertEquals(8, testModel.runRequest(testRequest));
    }

    /**
     * Functionality:
     * This is testing if the model can identify that
     * the rat in river is not allowed to capture the elephant on land
     */
    @Test
    public void testWaterRatCaptureElephant(){
        Coordinate p1ratPos = new Coordinate("B6");
        p1rat.setInWater(true);
        Coordinate p2elephantPos = new Coordinate("A6");
        testBoard.testSetPiece(p1rat, p1ratPos);
        testBoard.testSetPiece(p2elephant, p2elephantPos);
        testRequest = new RequestTest(testPlayer, p1ratPos, -1, 0);
        // testing second switch branch -> case 3
        assertEquals(9, testModel.runRequest(testRequest));
    }

    /**
     * Functionality:
     * This is testing if the model can identify that
     * the rat in water is not allowed to capture the rat on land or vice versa
     */
    @Test
    public void testWaterRatCaptureLandRatV(){
        Coordinate p1ratPos = new Coordinate("B6");
        p1rat.setInWater(true);
        Coordinate p2ratPos = new Coordinate("A6");
        testBoard.testSetPiece(p1rat, p1ratPos);
        testBoard.testSetPiece(p2rat, p2ratPos);
        testRequest = new RequestTest(testPlayer, p1ratPos, -1, 0);
        // testing second switch branch -> case 3
        assertEquals(10, testModel.runRequest(testRequest));
    }

    /**
     * Functionality:
     * This is testing if the model can identify a piece is moved to the opponent's den, and
     * report the game ends
     */
    @Test
    public void testPiecesToDen(){
        // Lion at D7
        testBoard.testSetPiece(p1lion,c4);
        // Rat at D8
        testBoard.testSetPiece(p2rat,c3);

        /**
         * test if the response indicates the game end when pieces move to the den
         *
         *  First, controller send request to model, asking to move a piece from a party to the direction.
         *  if the piece move to den, response should state that the game is ended.
         */
        PlayerTest testPlayer = new PlayerTest("test", 2);
        testRequest = new RequestTest(testPlayer, c3, 0,-1);
        // testing if branch -> if (board.at(dest).getType().equals("Den"))
        assertEquals(11, testModel.runRequest(testRequest));
    }

    @Test
    public void testContinueGame(){
        testBoard.testSetPiece(p1cat, bottomLeft);
        testBoard.testSetPiece(p2elephant, bottomRight);
        testRequest = new RequestTest(testPlayer, bottomLeft, 0,-1);
        // testing if branch -> if (pieceCount[0] > 0 && pieceCount[1] > 0)
        assertEquals(12, testModel.runRequest(testRequest));
    }
    /**
     * Functionality:
     * This is testing if the model can identify a player have no more pieces to play, and
     * report the game ends
     */
    @Test
    public void testNoPieceRemain() {
        // Lion at D7
        testBoard.testSetPiece(p1lion,c4);
        // Rat at D8
        testBoard.testSetPiece(p2rat,c3);
        /**
         * It simulates two players have 1 remaining piece on the game board
         * When one player capture the other piece, model shall identify and response shall be stated the game is ended to view.
         */
        PlayerTest testPlayer = new PlayerTest("test", 1);
        testRequest = new RequestTest(testPlayer, c4, 0, -1);
        // testing if branch -> if (pieceCount[0] > 0 && pieceCount[1] > 0)
        assertEquals(13, testModel.runRequest(testRequest));
    }

    
}