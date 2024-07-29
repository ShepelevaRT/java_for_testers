package ru.stqa.geometry;

import ru.stqa.geometry.figures.Rectangle;
import ru.stqa.geometry.figures.Square;

public class Geometry {
    public static void main(String[] args) {
        Square.printSquareArea(8.5);
        Square.printSquareArea(8.0);
        Square.printSquareArea(7.5);

        Rectangle.printRectangleArea(3.0, 5.0);
        Rectangle.printRectangleArea(9.0, 3.0);
    }

}

