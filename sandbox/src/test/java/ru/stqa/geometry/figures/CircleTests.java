package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CircleTests {

    @Test
    void canCalculateCircleArea() {
        Assertions.assertEquals(78.53981633974483, new Circle(5.0).circleArea());
    }
}
