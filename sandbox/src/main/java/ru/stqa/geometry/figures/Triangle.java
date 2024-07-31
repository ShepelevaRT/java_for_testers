package ru.stqa.geometry.figures;

import static java.lang.Math.sqrt;

public class Triangle {
    public static void printTrianglePerimeter(double a, double b, double c) {
        String text = String.format("Периметр треугольника со сторонами %f, %f и %f = %f", a,b,c, trianglePerimeter(a,b,c));
        System.out.println(text);
    }

    public static double trianglePerimeter(double a, double b, double c) {
        return a + b + c;
    }

    public static void printTriangleArea(double a, double b, double c) {
        String text = String.format("Площадь треугольника со сторонами %f, %f и %f = %f", a,b,c, triangleArea(a,b,c));
        System.out.println(text);
    }

    public static double triangleArea(double a, double b, double c) {
        var p = trianglePerimeter(a,b,c) / 2.0;
        return sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
