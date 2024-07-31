package ru.stqa.geometry;

import ru.stqa.geometry.figures.Circle;
import ru.stqa.geometry.figures.Rectangle;
import ru.stqa.geometry.figures.Square;
import ru.stqa.geometry.figures.Triangle;

public class Geometry {
    public static void main(String[] args) {
        Square.printSquareArea(8.5);
        Square.printSquareArea(8.0);
        Square.printSquareArea(7.5);

        Rectangle.printRectangleArea(3.0, 5.0);
        Rectangle.printRectangleArea(9.0, 3.0);

        Triangle.printTrianglePerimeter(10.0, 10.0, 12.0);
        Triangle.printTriangleArea(10.0, 10.0, 12.0);

        Circle.printCircleArea(5.0);

    }

}

