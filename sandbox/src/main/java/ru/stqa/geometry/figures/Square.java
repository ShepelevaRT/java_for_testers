package ru.stqa.geometry.figures;

public record Square(double a) {

    public double squareArea() {
        return this.a * this.a;
    }

    public static void printSquareArea(Square s) {
        String text = String.format("Площадь квадрата со стороной %f = %f", s.a, s.squareArea());
        System.out.println(text);
    }
}
