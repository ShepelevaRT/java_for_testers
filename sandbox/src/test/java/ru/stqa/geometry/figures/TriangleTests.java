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

    @Test
    void testEquality() {
        var t1 = new Triangle(5.0, 4.0, 3.0);
        var t2 = new Triangle(5.0, 4.0, 3.0);
        Assertions.assertEquals(t1, t2);
    }

    @Test
    void testEquality2() {
        var t1 = new Triangle(5.0, 4.0, 3.0);
        var t2 = new Triangle(5.0,3.0, 4.0);
        Assertions.assertEquals(t1, t2);
    }

    @Test
    void testEquality3() {
        var t1 = new Triangle(5.0, 4.0, 3.0);
        var t2 = new Triangle(4.0,5.0, 3.0);
        Assertions.assertEquals(t1, t2);
    }

    @Test
    void testEquality4() {
        var t1 = new Triangle(5.0, 4.0, 3.0);
        var t2 = new Triangle(4.0,3.0, 5.0);
        Assertions.assertEquals(t1, t2);
    }

    @Test
    void testEquality5() {
        var t1 = new Triangle(5.0, 4.0, 3.0);
        var t2 = new Triangle(3.0,5.0, 4.0);
        Assertions.assertEquals(t1, t2);
    }

    @Test
    void testEquality6() {
        var t1 = new Triangle(5.0, 4.0, 3.0);
        var t2 = new Triangle(3.0,4.0, 5.0);
        Assertions.assertEquals(t1, t2);
    }

}
