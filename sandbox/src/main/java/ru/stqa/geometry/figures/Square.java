package ru.stqa.geometry.figures;

public record Square(double a) {

    public Square{
        if (a < 0) {
            throw new IllegalArgumentException("Square side should be non-negative");
        }
    }

    public double squareArea() {
        return this.a * this.a;
    }

    public static void printSquareArea(Square s) {
        String text = String.format("Площадь квадрата со стороной %f = %f", s.a, s.squareArea());
        System.out.println(text);
    }

    public double squarePerimeter() {
        return this.a * 4;
    }
}
