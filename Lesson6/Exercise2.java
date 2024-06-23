package Lesson6;

// Задание 2:
public class Exercise2
{
    public static void main(String[] args)
    {
        /* Просто тестирование класса
        Person person1 = new Person("Петров Аркадий Давидович", "Бухгалтер", "petrarka@gmail.com", "+78005553535", 55000, 43);
        person1.outPrintInfo(); */

        Person[] persArray = new Person[5];
        persArray[0] = new Person("Петров Аркадий Давидович", "Бухгалтер",
                "petrarka@gmail.com", "+78005553535", 55000, 43);
        persArray[1] = new Person("Петрова Виолетта Марковна", "Старший бухгалтер",
                "petrvia@gmail.com", "+78005553536", 80000, 47);
        persArray[2] = new Person("Лей Екатерина Игнатьевна", "Аналитик",
                "leyka@gmail.com", "+78115556736", 60000, 33);
        persArray[3] = new Person("Зильберман Генрих Делеорович", "Разработчик",
                "silbergen@gmail.com", "+78115119736", 65000, 38);
        persArray[4] = new Person("Смирнов Сергей Владимирович", "Дизайнер",
                "smirnoff@gmail.com", "+78115133436", 63000, 39);
    }
}