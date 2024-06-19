package Lesson1;// Задания 5-7:
import java.util.Scanner;

public class Exercise5to7
{
    public static void main(String[] args)
    {
        exercise5();
        exercise6();
        exercise7();
    }
        // Задание 5:
        public static void exercise5()
        {
            Scanner console = new Scanner(System.in);

            System.out.println("Введите цифру №1: ");
            int a = console.nextInt();

            System.out.println("Введите цифру №2: ");
            int b = console.nextInt();

            if ((a+b) <= 20 & (a+b) > 10)
            System.out.println(true);
            else System.out.println(false);
        }

        // Задание 6:
        public static void exercise6()
        {
            Scanner console = new Scanner(System.in);

            System.out.println("Введите число: ");
            int a = console.nextInt();

            if(a >= 0)
            System.out.println("Число положительное.");
            else System.out.println("Число отрицательное.");
        }

        // Задание 7:
        public static void exercise7()
        {
            Scanner console = new Scanner(System.in);

            System.out.println("Введите число: ");
            int a = console.nextInt();

            if(a >= 0) System.out.println(true);
            else System.out.println(false);
        }
}