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

    @Test
    public void captureEnemyPieces(){
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                if (i <= j){
                    assertTrue(p1Pieces[i].canCapture(p2Pieces[j]));
                }
                else{
                    assertFalse(p1Pieces[i].canCapture(p2Pieces[j]));
                }
            }
        }
    }

    @Test
    public void captureFriendPieces(){
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                assertFalse(p1Pieces[i].canCapture(p2Pieces[j]));
            }
        }
    }

    @Test
    public void RatCaptureElephant(){
        assertTrue(p1Pieces[7].canCapture(p2Pieces[0]));
    }

    @Test
    public void captureTrappedEnemy(){
        p1Pieces[0].testSetTrapped(true);
        assertTrue(p2Pieces[1].canCapture(p1Pieces[0]));
    }

    @Test
    public void ratCaptureEnemyRatInWater(){
        p1Pieces[7].testSetInWater(true);
        assertFalse(p2Pieces[7].canCapture(p1Pieces[7]));
        assertFalse(p1Pieces[7].canCapture(p2Pieces[7]));
    }

    @Test
    public void ratCaptureEnemyRatBothInWater(){
        p1Pieces[7].testSetInWater(true);
        p2Pieces[7].testSetInWater(true);
        assertTrue(p2Pieces[7].canCapture(p1Pieces[7]));
    }

    @Test
    public void boardChangeAfterCapture(){
        board = new BoardTest();

        Coordinate tigerPos = new Coordinate(8, 0);
        Coordinate tigerNewPos = new Coordinate(3, 0);
        board.testMove(tigerPos, tigerNewPos);

        Coordinate tigerDest = new Coordinate(2, 0);
        board.testMove(tigerNewPos, tigerDest);
        int[] pieceCount = board.testGetPieceCount();
        assertEquals(pieceCount[1], 7);
    }
}
