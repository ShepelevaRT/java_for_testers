package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RectangleTests {

    @Test
    void canCalculateRectangleArea() {
        Assertions.assertEquals(15.0, new Rectangle(5.0, 3.0).rectangleArea());
    }
}
