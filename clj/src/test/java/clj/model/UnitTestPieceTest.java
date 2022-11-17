package clj.model;

import clj.controller.Coordinate;

import org.junit.Before;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UnitTestPieceTest {

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

    /* Rat */

    /**
     * Functionalilty:
     * This is testing if the canCapture method work as we designed
     */
    @Test
    public void ratCanCaptureTest(){
        PieceTest p1rat = p1Pieces[7];
        PieceTest p2rat = p2Pieces[7];
        PieceTest p1elephant = p1Pieces[0];
        PieceTest p2elephant = p2Pieces[0];
        PieceTest p2lion = p2Pieces[1];
        // testing if branch -> if (another == null)
        assertEquals(0, p1rat.canCapture(null));
        // tetsing if branch -> if (another.getParty() == this.getParty())
        assertEquals(1, p1rat.canCapture(p1elephant));
        // testing if branch -> if (another.getAnimal().equals("Elephant")
        // tetsing if branch -> if (this.isInWater())
        p1rat.setInWater(true);
        assertEquals(3, p1rat.canCapture(p2elephant));
        p1rat.setInWater(false);
        assertEquals(0, p1rat.canCapture(p2elephant));
        // testing if branch -> if (another.getAnimal().equals("Rat") && 
        //                      this.isInWater() != another.isInWater())
        p1rat.setInWater(true);
        assertEquals(4, p1rat.canCapture(p2rat));
        p1rat.setInWater(false);
        // testing if branch -> if (this.getRank() < another.getRank() &&
        //                      !another.isTrapped())
        assertEquals(2, p1rat.canCapture(p2lion));
    }

    /**
     * Functionality:
     * This is testing if canMoveTo method work as we designed
     */
    @Test
    public void ratCanMoveToTest(){
        PieceTest p1rat = p1Pieces[7];
        BoardObjTest dummy1 = new BoardObjTest("Den", 1);
        BoardObjTest dummy2 = new BoardObjTest("Den", 2);
        // testing if branch -> if (dest.getType().equals("Den") &&
        //                      dest.getParty() == this.getParty())
        assertEquals(1, p1rat.canMoveTo(dummy1));
        assertEquals(0, p1rat.canMoveTo(dummy2));
    }

    /* Since the canCapture and canMoveTo methods implementation of 
     * Cat, Dog, Leopard, Wolf are the same,
     * here we just use one of them to test
    */

    /**
     * Functionality:
     * This is testing if the canCapture method work as we designed
     */
    @Test
    public void catCanCaptureTest(){
        PieceTest p1cat = p1Pieces[6];
        PieceTest p2elephant = p2Pieces[0];
        PieceTest p1rat = p1Pieces[7];
        // testing if branch -> if (another == null)
        assertEquals(0, p1cat.canCapture(null));
        // tetsing if branch -> if (another.getParty() == this.getParty())
        assertEquals(1, p1cat.canCapture(p1rat));
        // testing if branch -> if (this.getRank() < another.getRank() &&
        //                      !another.isTrapped())
        assertEquals(2, p1cat.canCapture(p2elephant));
    }

    /**
     * Functionality:
     * This is testing if canMoveTo method work as we designed
     */
    @Test
    public void catCanMoveToTest(){
        BoardObjTest waterSquare = new BoardObjTest("Water", 0);
        BoardObjTest ownDen = new BoardObjTest("Den", 1);
        PieceTest p1cat = p1Pieces[6];
        // testing if branch -> if (dest.getType().equals("Den") &&
        //                      dest.getParty() == this.getParty())
        assertEquals(1, p1cat.canMoveTo(ownDen));
        // testing if branch -> if (dest.getType().equals("Water"))
        assertEquals(2, p1cat.canMoveTo(waterSquare));
    }

    /* For lion and tiger, since they can jump over river,
     * they have a different calFinalDest implementation compared to other piece,
     * since the implementation of calFinalDest is the same in lion and tiger,
     * here we just test one of them
    */

    /**
     * Functionality:
     * This is testing if the calFinalDest work as we designed
     */
     @Test
     public void lionCalFinalDestTest(){
        board = new BoardTest();
        board.testEmptyBoardPieces();

        // normal jump action
        PieceTest p1lion = p1Pieces[1];
        Coordinate expectedDest = new Coordinate("D6");
        Coordinate dest = new Coordinate("B6");
        dest = p1lion.calFinalDest(dest, board, 1, 0);
        assertEquals(dest.getCol(), expectedDest.getCol());
        assertEquals(dest.getRow(), expectedDest.getRow());

        // insert a rat in the mid-way
        PieceTest p1rat = p1Pieces[0];
        Coordinate p1ratPos = new Coordinate("C6");
        board.testSetPiece(p1rat, p1ratPos);
        dest = new Coordinate("B6");
        dest = p1lion.calFinalDest(dest, board, 1, 0);
        // the dest should be "C6", which means lion is block by the rat
        assertEquals(dest.getCol(), p1ratPos.getCol());
        assertEquals(dest.getRow(), p1ratPos.getRow());
     }

    
}
