package ru.stqa.geometry.figures;

public class Circle {

    public static void printCircleArea(double r) {
        String text = String.format("Площадь круга радиусом %f = %f", r, circleArea(r));
        System.out.println(text);
    }

    public static double circleArea(double r) {
        return Math.PI * r * r;
    }


}
