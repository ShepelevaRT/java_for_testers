package ru.stqa.geometry.figures;

import static java.lang.Math.sqrt;

public class Triangle {

    private double a;
    private double b;
    private double c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
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
