package ru.stqa.geometry;

import ru.stqa.geometry.figures.Circle;
import ru.stqa.geometry.figures.Rectangle;
import ru.stqa.geometry.figures.Square;
import ru.stqa.geometry.figures.Triangle;

import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Geometry {
    public static void main(String[] args) {
        Supplier<Square> randomSquare = () -> new Square(new Random().nextDouble(100.0));
        var squares = Stream.generate(randomSquare).limit(5);
        Consumer<Square> print = Square::printSquareArea;
        squares.peek(Square::printSquareArea).forEach(Square::printSquareArea);

//        Rectangle.printRectangleArea(new Rectangle(3.0, 5.0));
//        Rectangle.printRectangleArea(new Rectangle(9.0, 3.0));
//
//        Triangle.printTrianglePerimeter(new Triangle(10.0, 10.0, 12.0));
//        Triangle.printTriangleArea(new Triangle(10.0, 10.0, 12.0));
//
//        Circle.printCircleArea(new Circle(5.0));


    }

}

