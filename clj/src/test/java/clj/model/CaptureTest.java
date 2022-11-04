package clj.model;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;
import org.junit.Before;

public class CaptureTest {

    Piece[] p1Pieces = {new Elephant(1),
                        new Lion(1),
                        new Tiger(1),
                        new Leopard(1),
                        new Wolf(1),
                        new Dog(1),
                        new Cat(1),
                        new Rat(1)};

    Piece[] p2Pieces = {new Elephant(2),
                        new Lion(2),
                        new Tiger(2),
                        new Leopard(2),
                        new Wolf(2),
                        new Dog(2),
                        new Cat(2),
                        new Rat(2)};

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
}
