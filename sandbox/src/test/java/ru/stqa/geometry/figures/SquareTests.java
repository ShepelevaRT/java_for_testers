package ru.stqa.geometry.figures;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SquareTests {

    @Test
    void canCalculateSquareArea() {
        Assertions.assertEquals(25.0, new Square(5.0).squareArea());
    }

    @Test
    void canCalculateSquarePerimeter(){
        Assertions.assertEquals(20.0, new Square(5.0).squarePerimeter());
    }

    @Test
    void cannotCreateSquareWithNegativeSide() {
        try{
            new Square(-5.0);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            // OK
        }
    }
}
