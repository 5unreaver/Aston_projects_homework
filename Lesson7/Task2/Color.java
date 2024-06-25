package Lesson7.Task2;

// Абстрактный класс для общей логики фигур.
abstract class Color implements Figures {
    private String fillColor;
    private String borderColor;

    public Color(String fillColor, String borderColor) {
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }

    // Метод для формирования строки характеристик фигуры
    public String getCharacteristics() {
        return "[периметр: " + calculatePerimeter() + ", " +
                "площадь: " + calculateArea() + ", " +
                "цвет фона: " + getFillColor() + ", " +
                "цвет границы: " + getBorderColor() + "]";
    }
}