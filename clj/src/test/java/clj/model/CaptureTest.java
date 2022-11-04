package clj.model;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class CaptureTest {

    PieceTest[] p1Pieces = {new ElephantTest(1),
                            new LionTest(1),
                            new TigerTest(1),
                            new LeopardTest(1),
                            new WolfTest(1),
                            new DogTest(1),
                            new CatTest(1),
                            new RatTest(1)};

    PieceTest[] p2Pieces = {new ElephantTest(2),
                            new LionTest(2),
                            new TigerTest(2),
                            new LeopardTest(2),
                            new WolfTest(2),
                            new DogTest(2),
                            new CatTest(2),
                            new RatTest(2)};

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
    }

    @Test
    public void ratCaptureEnemyRatBothInWater(){
        p1Pieces[7].testSetInWater(true);
        p2Pieces[7].testSetInWater(true);
        assertTrue(p2Pieces[7].canCapture(p1Pieces[7]));
    }
}
