package ru.stqa.geometry.figures;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SquareTests {

    @Test
    void canCalculateSquareArea() {
        Assertions.assertEquals(25.0, Square.squareArea(5.0));
    }

    @Test
    void canCalculateRectangleArea() {
        Assertions.assertEquals(15.0, Rectangle.rectangleArea(5.0, 3.0));
    }

    @Test
    void canCalculateTriangle() {
        Assertions.assertEquals(48.0, Triangle.triangleArea(10.0, 10.0, 12.0));
    }

    @Test
    void canCalculateCircleArea() {
        Assertions.assertEquals(78.53981633974483, Circle.circleArea(5.0));
    }

}
