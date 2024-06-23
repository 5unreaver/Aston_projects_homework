package Lesson6;

// Задание 1:
public class Person
{
    private String fullName; /* к. п., переменные описывают
    свойтсва будущих объектов. Переменные, объявленные в классе,
    называют полями экземпляра.
    Каждый объект класса содержит собственные копии таких переменных. */
    private String position;
    private String email;
    private String phone;
    private double salary;
    private int age;

    // Конструктор класса "Сотрудник"
    public Person(String fullName, String position, String email, String phone, double salary, int age)
    {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    /* Метод для вывода информации о сотруднике в консоль.
    Методы в классе описывают поведение будущих объектов */
    public void outPrintInfo() {
        System.out.println("ФИО: " + fullName);
        System.out.println("Должность: " + position);
        System.out.println("Email: " + email);
        System.out.println("Телефон: " + phone);
        System.out.println("Зарплата: " + salary);
        System.out.println("Возраст: " + age);
    }
}