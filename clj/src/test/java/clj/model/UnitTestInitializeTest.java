package clj.model;

import static org.junit.Assert.assertEquals;
import clj.controller.Coordinate;
import org.junit.Test;


public class UnitTestInitializeTest
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
        assertEquals("Tiger", testboard.pick((new Coordinate("A1"))).getAnimal());
        assertEquals("Tiger", testboard.pick((new Coordinate("G9"))).getAnimal());

        assertEquals("Elephant", testboard.pick((new Coordinate("A3"))).getAnimal());
        assertEquals("Elephant", testboard.pick((new Coordinate("G7"))).getAnimal());

        assertEquals("Cat", testboard.pick((new Coordinate("B2"))).getAnimal());
        assertEquals("Cat", testboard.pick((new Coordinate("F8"))).getAnimal());

        assertEquals("Wolf", testboard.pick((new Coordinate("C3"))).getAnimal());
        assertEquals("Wolf", testboard.pick((new Coordinate("E7"))).getAnimal());

        assertEquals("Leopard", testboard.pick((new Coordinate("E3"))).getAnimal());
        assertEquals("Leopard", testboard.pick((new Coordinate("C7"))).getAnimal());

        assertEquals("Dog", testboard.pick((new Coordinate("F2"))).getAnimal());
        assertEquals("Dog", testboard.pick((new Coordinate("B8"))).getAnimal());

        assertEquals("Lion", testboard.pick((new Coordinate("G1"))).getAnimal());
        assertEquals("Lion", testboard.pick((new Coordinate("A9"))).getAnimal());

        assertEquals("Rat", testboard.pick((new Coordinate("G3"))).getAnimal());
        assertEquals("Rat", testboard.pick((new Coordinate("A7"))).getAnimal());

    }
}
