package Lesson1;// Задание 8:
import java.util.Scanner;

public class Exercise8
{
    public static void main(String[] args)
    {
        // пример Задания №8 с заданными значениями.
        /* exercise8("Hello, world!", 5);
    }

    public static void exercise8(String str, int number)
    {
        for (int i = 0; i < number; i++)
        {
            System.out.println(str);
        } */

        // пример Задания №8 со значениями из консоли.
        Scanner console = new Scanner(System.in);

        System.out.println("Введите строку: ");
        String str = console.nextLine();

        System.out.print("Введите, сколько раз напечатать строку: ");
        int number = console.nextInt();

        // Печатаем строку указанное кол-во раз
        for (int i = 0; i < number; i++) System.out.println(str);
    }
}