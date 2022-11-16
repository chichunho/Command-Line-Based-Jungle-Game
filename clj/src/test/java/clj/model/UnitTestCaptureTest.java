package clj.model;

import clj.controller.Coordinate;

import org.junit.Before;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UnitTestCaptureTest {

    PieceTest[] p1Pieces;
    PieceTest[] p2Pieces;
    BoardTest board;

    @Before
    public void init(){
        p1Pieces = new PieceTest[8];
        p2Pieces = new PieceTest[8];

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
     * This is testing if a piece can capture enemy piece with equal or lower ranks,
     * This test will not test rat
     * Expected:
     * The higher rank animal shall be able to capture the same or lower rank animal, and
     * the lower rank animal shall not be able to capture the higher rank animal
     */
    @Test
    public void captureEnemyPieces(){
        // for each animal i
        for (int i = 0; i < 7; i++){
            // for each animal j
            for (int j = 0; j < 7; j++){
                // if the rank of j is equal or lower than animal i, the function shall return 0
                if (i <= j){
                    assertEquals(p1Pieces[i].canCapture(p2Pieces[j]), 0);
                }
                // otherwise, it shall return 2
                else{
                    assertEquals(p1Pieces[i].canCapture(p2Pieces[j]), 2);
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
        // this shall return 1 if both of them are in the same party
        assertEquals(p1Pieces[0].canCapture(p1Pieces[1]), 1);
    }

    /**
     * Functionality:
     * This is testing if rat can capture enemy elephant
     * Expected:
     * The rat shall be able to capture the elephant
     */
    @Test
    public void RatCaptureElephant(){
        // this shall return 0
        assertEquals(p1Pieces[7].canCapture(p2Pieces[0]), 0);
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
        p1Pieces[0].setTrapped(true);
        // this shall return true
        assertEquals(p2Pieces[1].canCapture(p1Pieces[0]), 0);
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
        p1Pieces[7].setInWater(true);
        // this shall return 4
        assertEquals(p2Pieces[7].canCapture(p1Pieces[7]), 4);
        // this shall also return 4 if the position is exchanged
        assertEquals(p1Pieces[7].canCapture(p2Pieces[7]), 4);
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
        p1Pieces[7].setInWater(true);
        p2Pieces[7].setInWater(true);
        // this should return 0
        assertEquals(p2Pieces[7].canCapture(p1Pieces[7]), 0);
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
        Coordinate tigerPos = new Coordinate(0, 8);
        // the new position for tiger
        Coordinate tigerNewPos = new Coordinate(0, 3);
        // move it directly to (3, 0)
        board.testSkip(tigerPos, tigerNewPos);

        // there is a enemy rat in front of the tiger
        Coordinate tigerDest = new Coordinate(0, 2);
        // capture the enemy rat
        board.move(tigerNewPos, tigerDest);
        // the piece count of opposite party shall decreased from 8 to 7
        assertEquals(board.getPieceCount()[0], 7);
    }
}
