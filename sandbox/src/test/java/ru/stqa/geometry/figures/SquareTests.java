package ru.stqa.geometry.figures;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SquareTests {

    @Test
    void canCalculateSquareSquareArea() {
        Assertions.assertEquals(25.0, new Square(5.0).squareArea());
    }

    @Test
    void canCalculateRectangleArea() {
        Assertions.assertEquals(15.0, new Rectangle(5.0, 3.0).rectangleArea());
    }

    @Test
    void canCalculateTriangle() {
        Assertions.assertEquals(48.0, new Triangle(10.0, 10.0, 12.0).triangleArea());
    }

    @Test
    void canCalculateCircleArea() {
        Assertions.assertEquals(78.53981633974483, new Circle(5.0).circleArea());
    }

}
