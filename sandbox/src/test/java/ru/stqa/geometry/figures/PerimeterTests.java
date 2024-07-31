package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PerimeterTests {

    @Test
    void canCalculatePerimeter() {
        Assertions.assertEquals(32.0, new Triangle(10.0, 10.0, 12.0).trianglePerimeter());
    }
}
