package Lesson7.Task2;

public class Circle extends Color
{
    private double radius;

    public Circle(double radius, String fillColor, String borderColor)
    {
        super(fillColor, borderColor);
        this.radius = radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double calculateArea() {
        return Math.round(Math.PI * Math.pow(radius, 2));
    }
}
