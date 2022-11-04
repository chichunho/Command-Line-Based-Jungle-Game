package clj.model;

import static org.junit.Assert.assertEquals;
import clj.controller.Coordinate;
import org.junit.Test;


public class InitializeTest
{
    

    /**
     * Functionality:
     * This is testing if the initialize process executed properly
     * Expected:
     * All pieces are located at their default position in the begining
     */
    @Test
    public void BoardInitializeTest()
    {
        BoardTest testboard = new BoardTest();
        assertEquals("Tiger", testboard.pick((new Coordinate(1,1))).getAnimal());
        assertEquals("Elephant", testboard.pick((new Coordinate(1,3))).getAnimal());
        assertEquals("Cat", testboard.pick((new Coordinate(2,2))).getAnimal());
        assertEquals("Wolf", testboard.pick((new Coordinate(3,3))).getAnimal());
        assertEquals("Leopard", testboard.pick((new Coordinate(5,3))).getAnimal());
        assertEquals("Dog", testboard.pick((new Coordinate(6,2))).getAnimal());
        assertEquals("Lion", testboard.pick((new Coordinate(7,1))).getAnimal());
        assertEquals("Rat", testboard.pick((new Coordinate(7,3))).getAnimal());
        assertEquals("Tiger", testboard.pick((new Coordinate(7,9))).getAnimal());
        assertEquals("Elephant", testboard.pick((new Coordinate(7,7))).getAnimal());
        assertEquals("Cat", testboard.pick((new Coordinate(6,8))).getAnimal());
        assertEquals("Wolf", testboard.pick((new Coordinate(5,7))).getAnimal());
        assertEquals("Leopard", testboard.pick((new Coordinate(3,7))).getAnimal());
        assertEquals("Dog", testboard.pick((new Coordinate(2,8))).getAnimal());
        assertEquals("Lion", testboard.pick((new Coordinate(1,9))).getAnimal());
        assertEquals("Rat", testboard.pick((new Coordinate(1,7))).getAnimal());
    }
}
