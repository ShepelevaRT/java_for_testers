package ru.stqa.geometry;

import ru.stqa.geometry.figures.Circle;
import ru.stqa.geometry.figures.Rectangle;
import ru.stqa.geometry.figures.Square;
import ru.stqa.geometry.figures.Triangle;

import java.util.List;
import java.util.function.Consumer;

public class Geometry {
    public static void main(String[] args) {
        var squares = List.of(new Square(8.5), new Square(8.0), new Square(7.5));

//        for (Square square : squares) {
//            Square.printSquareArea(square);
//        }

        Consumer<Square> print = Square::printSquareArea;
        squares.forEach(print);

//        Rectangle.printRectangleArea(new Rectangle(3.0, 5.0));
//        Rectangle.printRectangleArea(new Rectangle(9.0, 3.0));
//
//        Triangle.printTrianglePerimeter(new Triangle(10.0, 10.0, 12.0));
//        Triangle.printTriangleArea(new Triangle(10.0, 10.0, 12.0));
//
//        Circle.printCircleArea(new Circle(5.0));

    }

}

