package Lesson7.Task2;

public interface Figures {
    double calculatePerimeter(); // метод расчёта периметра
    double calculateArea(); // метод расчёта площади

    String getFillColor(); // метод получения цвета заливки
    String getBorderColor(); // метод получения цвета границы
}