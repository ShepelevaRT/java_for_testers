package ru.stqa.geometry.figures;

public record Rectangle(double a, double b) {

    public Rectangle {
        if (a < 0 || b < 0) {
            throw new IllegalArgumentException("Rectangle side should be non-negative");
        }
    }

    public double rectangleArea() {
        return this.a * this.b;
    }

    public static void printRectangleArea(Rectangle s) {
        String text = String.format("Площадь прямоугольника со сторонами %f и %f = %f", s.a, s.b, s.rectangleArea());
        System.out.println(text);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rectangle rectangle = (Rectangle) o;
        return ((Double.compare(this.a, rectangle.a) == 0) && (Double.compare(this.b, rectangle.b) == 0))
                || ((Double.compare(this.b, rectangle.a) == 0) && (Double.compare(this.a, rectangle.b) == 0));
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
