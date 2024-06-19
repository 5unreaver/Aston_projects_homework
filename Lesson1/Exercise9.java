package Lesson1;// Задание 9:
import java.util.Scanner;

public class Exercise9
{
    public static void main(String[] args)
    {
        Scanner console = new Scanner(System.in);
        System.out.print("Введите год: ");
        int year = console.nextInt();

        boolean leapCheck = (year % 4 == 0) && (year % 100 != 0 || year % 400 == 0);
        System.out.println(year + (leapCheck ? " является" : " не является") + " високосным годом.");
    }
}
