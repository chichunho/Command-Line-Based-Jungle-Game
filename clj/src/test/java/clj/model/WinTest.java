package clj.model;


import clj.view.View;

import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.*;
import org.junit.Test;

/*
Tests for checking winner
 */

public class WinTest {
    Player testPlayer = new Player("PLayer1", 0);
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
    clj.model.Coordinate c1,c2,c3;
    clj.model.Request testRequest;
    View testView;
    Model testModel = new Model(testView);

    Response testResponse;

    @Before
    public void setUp() throws Exception {
        c1 = new Coordinate(0,2);
        c2 = new Coordinate(0,4);
        c3 = new Coordinate(1,3);
    }


    @Test
    public void testRemainingPieces() {

    }
    @Test
    public void testPiecesToDen(){
        testRequest = new clj.model.Request (testPlayer, c1, 0,-1);
        testResponse = testModel.run(testRequest);
        assertTrue(testResponse.getIsEndGame());

        testRequest = new Request(testPlayer, c2, 0,1);
        assertTrue(testResponse.getIsEndGame());

        testRequest = new Request(testPlayer,c3,1,0);

    }
    @After
    public void tearDown() throws Exception {
    }
}