package ru.stqa.geometry;

import ru.stqa.geometry.figures.Circle;
import ru.stqa.geometry.figures.Rectangle;
import ru.stqa.geometry.figures.Square;
import ru.stqa.geometry.figures.Triangle;

public class Geometry {
    public static void main(String[] args) {
        Square.printSquareArea(new Square(8.5));
        Square.printSquareArea(new Square(8.0));
        Square.printSquareArea(new Square(7.5));

        Rectangle.printRectangleArea(new Rectangle(3.0, 5.0));
        Rectangle.printRectangleArea(new Rectangle(9.0, 3.0));

        Triangle.printTrianglePerimeter(new Triangle(10.0, 10.0, 12.0));
        Triangle.printTriangleArea(new Triangle(10.0, 10.0, 12.0));

        Circle.printCircleArea(new Circle(5.0));

    }

}

