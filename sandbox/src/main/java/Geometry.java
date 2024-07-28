public class Geometry {
    public static void main(String[] args) {
        var side = 7.;
        System.out.println("Площадь квадрата со стороной " + side + " = " + squareArea(side));

        printSquareArea(8.5);
        printSquareArea(8.0);
        printSquareArea(7.5);

        printRectangleArea(3.0, 5.0);
        printRectangleArea(9.0, 3.0);
    }

    private static void printRectangleArea(double a, double b) {
        System.out.println("Площадь прямоугольника со сторонами " + a + " и " + b + " = " + rectangleArea(a, b));
    }

    private static double rectangleArea(double a, double b) {
        return a * b;
    }

    static void printSquareArea(double side) {
        System.out.println("Площадь квадрата со стороной " + side + " = " + squareArea(side));
    }

    private static double squareArea(double a) {
        return a * a;
    }
}
