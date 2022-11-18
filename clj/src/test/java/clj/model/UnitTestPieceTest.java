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

    /**
     * Functionality:
     * This is testing the method inherit form the parent class
     */
    @Test
    public void commonTest(){
        String[] animalName = {"Elephant", "Lion", "Tiger", "Leopard", "Wolf", "Dog", "Cat", "Rat"};
        int[] animalRank = {8, 7, 6, 5, 4, 3, 2, 1};
        for (int i = 0; i < 8; i++){
            assertEquals(animalName[i], p1Pieces[i].getAnimal());
            assertEquals(animalName[i], p2Pieces[i].getAnimal());
            assertEquals(animalRank[i], p1Pieces[i].getRank());
            assertEquals(animalRank[i], p2Pieces[i].getRank());
            assertEquals(1, p1Pieces[i].getParty());
            assertEquals(2, p2Pieces[i].getParty());
            p1Pieces[i].setTrapped(true);
            p1Pieces[i].setInWater(true);
            p2Pieces[i].setTrapped(true);
            p2Pieces[i].setInWater(true);
            assertEquals(true, p1Pieces[i].isTrapped());
            assertEquals(true, p1Pieces[i].isInWater());
            assertEquals(true, p2Pieces[i].isTrapped());
            assertEquals(true, p2Pieces[i].isInWater());
        }
    }

    /**
     * Functionality:
     * This is testing if the canCapture method is work as we designed.
     * Except rat, all pieces have the same canCapture method implementation
     */
    @Test
    public void canCaptureTest(){
        for (int i = 0; i < 7; i++){
            for (int j = i; j < 8; j++){
                assertEquals(0, p1Pieces[i].canCapture(p2Pieces[j]));
                assertEquals(0, p1Pieces[i].canCapture(null));
                assertEquals(1, p1Pieces[i].canCapture(p1Pieces[j]));
            }
        }

        for (int i = 7; i > 0; i--){
            for (int j = i-1; j > 0; j--){
                assertEquals(2, p1Pieces[i].canCapture(p2Pieces[j]));
            }
        }

        for (int i = 7; i > 0; i--){
            for (int j = i-1; j > 0; j--){
                p2Pieces[j].setTrapped(true);
                assertEquals(0, p1Pieces[i].canCapture(p2Pieces[j]));
            }
        }
    }

    /**
     * Functionalilty:
     * This is testing if the canCapture method work as we designed (rat only)
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
     * This is testing if canMoveTo method work as we designed (rat only)
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

     /**
      * Functionality:
      * This is testing if the calFinalDest work as we designed (jump animals only)
      */
    @Test
    public void lionTigerCalFinalDestTest(){
        board = new BoardTest();
        board.testEmptyBoardPieces();
        PieceTest p1lion = p1Pieces[1];
        PieceTest p1tiger = p1Pieces[2];
        PieceTest[] jumpAnimals = {p1lion, p1tiger};
        Coordinate dest = new Coordinate("B6");
        Coordinate expectedDest;

        for (int i = 0; i < 2; i++){
            // normal jump action
            expectedDest = new Coordinate("D6");
            dest = jumpAnimals[i].calFinalDest(dest, board, 1, 0);
            assertEquals(dest.getCol(), expectedDest.getCol());
            assertEquals(dest.getRow(), expectedDest.getRow());
        }
        

        // insert a rat in the mid-way
        PieceTest p1rat = p1Pieces[0];
        Coordinate p1ratPos = new Coordinate("C6");
        board.testSetPiece(p1rat, p1ratPos);
        for(int i = 0; i < 2; i++){
            dest = new Coordinate("B6");
            dest = p1lion.calFinalDest(dest, board, 1, 0);
            // the dest should be "C6", which means lion is block by the rat
            assertEquals(dest.getCol(), p1ratPos.getCol());
            assertEquals(dest.getRow(), p1ratPos.getRow());
        }
    }   
}
