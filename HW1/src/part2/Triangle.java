package HW1.src.part2;

public class Triangle extends Shape {
    double sideA;

    double sideB;

    double sideC;

    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public double getArea(double sideA, double sideB, double sideC) {
        double halfPerimeter = (sideA + sideB + sideC)/2;

        return Math.sqrt(halfPerimeter*(halfPerimeter - sideA)*(halfPerimeter - sideB)*(halfPerimeter * sideC));
    }

}
