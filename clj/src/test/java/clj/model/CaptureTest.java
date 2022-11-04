package clj.model;

import clj.controller.Coordinate;

import static org.junit.Assert.assertTrue;

import org.junit.Before;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class CaptureTest {

    PieceTest[] p1Pieces;
    PieceTest[] p2Pieces;
    BoardTest board;

    @Before
    public void init(){
        p1Pieces[0] = new ElephantTest(1);
        p1Pieces[1] = new LionTest(1);
        p1Pieces[2] = new TigerTest(1);
        p1Pieces[3] = new LeopardTest(1);
        p1Pieces[4] = new WolfTest(1);
        p1Pieces[5] = new DogTest(1);
        p1Pieces[6] = new CatTest(1);
        p1Pieces[7] = new RatTest(1);

        p2Pieces[0] = new ElephantTest(2);
        p2Pieces[1] = new LionTest(2);
        p2Pieces[2] = new TigerTest(2);
        p2Pieces[3] = new LeopardTest(2);
        p2Pieces[4] = new WolfTest(2);
        p2Pieces[5] = new DogTest(2);
        p2Pieces[6] = new CatTest(2);
        p2Pieces[7] = new RatTest(2);
    }

    /**
     * Functionality:
     * This is testing if a piece can capture enemy piece with equal or lower ranks
     * Expected:
     * The higher rank animal shall be able to capture the same or lower rank animal, and
     * the lower rank animal shall not be able to capture the higher rank animal
     */
    @Test
    public void captureEnemyPieces(){
        // for each animal i
        for (int i = 0; i < 8; i++){
            // for each animal j
            for (int j = 0; j < 8; j++){
                // if the rank of j is equal or lower than animal i, the function shall return true
                if (i <= j){
                    assertTrue(p1Pieces[i].canCapture(p2Pieces[j]));
                }
                // otherwise, it shall return false
                else{
                    assertFalse(p1Pieces[i].canCapture(p2Pieces[j]));
                }
            }
        }
    }

    /**
     * Functionality:
     * This is testing if a piece can capture friendly piece
     * Expected:
     * A piece shall not be able to capture another friendly piece
     */
    @Test
    public void captureFriendPieces(){
        // this shall return false if both of them are in the same party
        assertFalse(p1Pieces[0].canCapture(p1Pieces[1]));
    }

    /**
     * Functionality:
     * This is testing if rat can capture enemy elephant
     * Expected:
     * The rat shall be able to capture the elephant
     */
    @Test
    public void RatCaptureElephant(){
        // this shall return true
        assertTrue(p1Pieces[7].canCapture(p2Pieces[0]));
    }

    /**
     * Functionality:
     * This is testing if a piece can capture enemy piece which is trapped,
     * without concerning the ranks
     * Expected:
     * The lion shall be able to capture the enemy elephant in trap
     */
    @Test
    public void captureTrappedEnemy(){
        // set the trapped flag of the elephant from player 1 to true
        p1Pieces[0].testSetTrapped(true);
        // this shall return true
        assertTrue(p2Pieces[1].canCapture(p1Pieces[0]));
    }

    /**
     * Functionality:
     * This is testing if the rat can capture enemy rat under water, and vice versa
     * Expected:
     * The rat shall not able to capture enemy rat under water, and vice versa
     */
    @Test
    public void ratCaptureEnemyRatInWater(){
        // set the water flag of the rat from player 1 to true
        p1Pieces[7].testSetInWater(true);
        // this shall return false
        assertFalse(p2Pieces[7].canCapture(p1Pieces[7]));
        // this shall also return true if the position is exchanged
        assertFalse(p1Pieces[7].canCapture(p2Pieces[7]));
    }

    /**
     * Functionality:
     * This is testing if they can capture each other given that both rat are under water
     * Expected:
     * The rat shall be able to capture another rat if they are both under water
     */
    @Test
    public void ratCaptureEnemyRatBothInWater(){
        // set the water flag from both player to true
        p1Pieces[7].testSetInWater(true);
        p2Pieces[7].testSetInWater(true);
        // this should return true
        assertTrue(p2Pieces[7].canCapture(p1Pieces[7]));
    }

    /**
     * Functionality:
     * This is testing if the piece is removed from the board
     * Expected:
     * The piece count of the party which lose a piece shall be decreased by 1
     */
    @Test
    public void boardChangeAfterCapture(){
        // new a game board
        board = new BoardTest();

        // at the beginning, the tiger is located at (8, 0)
        Coordinate tigerPos = new Coordinate(8, 0);
        // the new position for tiger
        Coordinate tigerNewPos = new Coordinate(3, 0);
        // move it to (3, 0)
        board.testMove(tigerPos, tigerNewPos);

        // there is a enemy rat in front of the tiger
        Coordinate tigerDest = new Coordinate(2, 0);
        // capture the enemy rat
        board.testMove(tigerNewPos, tigerDest);
        // get the piece count from the board
        int[] pieceCount = board.testGetPieceCount();
        // the piece count of opposite party shall decreased from 8 to 7
        assertEquals(pieceCount[1], 7);
    }
}
