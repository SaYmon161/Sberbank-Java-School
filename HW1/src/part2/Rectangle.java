package HW1.src.part2;

public class Rectangle {
    double sideA;

    double sideB;

    public Rectangle(double sideA, double sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
    }

    public double getArea(double sideA, double sideB) {
        return sideA*sideB;
    }
}
