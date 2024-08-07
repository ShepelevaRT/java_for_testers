package ru.stqa.geometry.figures;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SquareTests {

    @Test
    void canCalculateSquareArea() {
        Assertions.assertEquals(25.0, new Square(5.0).squareArea());
    }
}
