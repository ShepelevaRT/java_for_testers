package ru.stqa.geometry.figures;

public record Rectangle(double a, double b) {

    public double rectangleArea() {
        return this.a * this.b;
    }

    public static void printRectangleArea(Rectangle s) {
        String text = String.format("Площадь прямоугольника со сторонами %f и %f = %f", s.a, s.b, s.rectangleArea());
        System.out.println(text);
    }
}
