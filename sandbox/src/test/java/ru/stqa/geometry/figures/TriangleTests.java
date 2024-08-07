package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTests {

    @Test
    void canCalculateTriangleArea() {
        Assertions.assertEquals(48.0,
                new Triangle(10.0, 10.0, 12.0).triangleArea());
    }

    @Test
    void cannotCreateTriangleWithNegativeSide() {
        try{
            new Triangle(-5.0, 3.0, 4.0);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            // OK
        }
    }

    @Test
    void cannotCreateTriangleWhereTheSumOfTwoSideLessThanThirdSide() {
        try{
            new Triangle(1.0, 2.0, 4.0);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            // OK
        }
    }

}
