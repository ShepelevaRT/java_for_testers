package ru.stqa.geometry.figures;

public record Circle(double r) {

    public double circleArea() {
        return Math.PI * r * r;
    }

    public static void printCircleArea(Circle c) {
        String text = String.format("Площадь круга радиусом %f = %f", c.r, c.circleArea());
        System.out.println(text);
    }
}
