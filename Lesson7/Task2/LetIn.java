package Lesson7.Task2;

public class LetIn {
    public static void main(String[] args) {
        // Создание объектов фигур
        Circle circle = new Circle(5,"Зеленый","Черный");
        Rectangle rectangle = new Rectangle(3, 4,"Жёлтый","Бордовый");
        Triangle triangle = new Triangle(3, 4, 5,"Розовый","Бежевый");

        // Вывод характеристик круга
        System.out.println("Круг: " + circle.getCharacteristics() + ";");
        System.out.println("Прямоугольник: " + rectangle.getCharacteristics() + ";");
        System.out.println("Треугольник: " + triangle.getCharacteristics() + ";");
    }
}
