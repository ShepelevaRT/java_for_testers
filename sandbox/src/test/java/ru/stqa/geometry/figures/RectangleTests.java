package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RectangleTests {

    @Test
    void canCalculateRectangleArea() {
        Assertions.assertEquals(15.0, new Rectangle(5.0, 3.0).rectangleArea());
    }

    @Test
    void cannotCreateRectangleWithNegativeSide() {
        try{
            new Rectangle(-5.0, 4.0);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            // OK
        }
    }

    @Test
    void testEquality() {
        var r1 = new Rectangle(5.0, 4.0);
        var r2 = new Rectangle(5.0, 4.0);
        Assertions.assertEquals(r1, r2);
    }

    @Test
    void testEquality2() {
        var r1 = new Rectangle(5.0, 4.0);
        var r2 = new Rectangle(4.0, 5.0);
        Assertions.assertEquals(r1, r2);
    }
}
