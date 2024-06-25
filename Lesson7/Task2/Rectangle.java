package Lesson7.Task2;

// Класс для прямоугольника
public class Rectangle extends Color {
        private double width;
        private double height;
        private String fillColor;
        private String borderColor;

        public Rectangle(double width, double height, String fillColor, String borderColor) {
            super(fillColor, borderColor);
            this.width = width;
            this.height = height;
        }

        @Override
        public double calculatePerimeter() {
            return 2 * (width + height);
        }

        @Override
        public double calculateArea() {
            return width * height;
        }
}
