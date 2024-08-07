package ru.stqa.geometry.figures;

import static java.lang.Math.sqrt;

public record Triangle(double a, double b, double c) {

    public Triangle {
        if (a < 0 || b < 0 || c < 0) {
            throw new IllegalArgumentException("Triangle side should be non-negative");
        } else if ((a + b) <= c || (a + c) <= b || (b + c) <= a) {
            throw new IllegalArgumentException("The sum of two sides must be greater than the third side");
        }
    }

    public double trianglePerimeter () {
        return this.a + this.b + this.c;
    }

    public double triangleArea() {
        var p = trianglePerimeter() / 2.0;
        return sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public static void printTrianglePerimeter(Triangle s) {
        String text = String.format("Периметр треугольника со сторонами %f, %f и %f = %f", s.a,s.b,s.c, s.trianglePerimeter());
        System.out.println(text);
    }

    public static void printTriangleArea(Triangle s) {
        String text = String.format("Площадь треугольника со сторонами %f, %f и %f = %f", s.a,s.b, s.c, s.triangleArea());
        System.out.println(text);
    }
}
