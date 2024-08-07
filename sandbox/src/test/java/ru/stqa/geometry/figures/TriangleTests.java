package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTests {

    @Test
    void canCalculateTriangleArea() {
        Assertions.assertEquals(48.0, new Triangle(10.0, 10.0, 12.0).triangleArea());
    }
}
