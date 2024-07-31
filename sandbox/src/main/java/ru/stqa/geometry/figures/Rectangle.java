package ru.stqa.geometry.figures;

public class Rectangle {

    private double a;
    private double b;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double rectangleArea() {
        return this.a * this.b;
    }

    public static void printRectangleArea(Rectangle s) {
        String text = String.format("Площадь прямоугольника со сторонами %f и %f = %f", s.a, s.b, s.rectangleArea());
        System.out.println(text);
    }
}
