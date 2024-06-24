package Lesson5;// Задание 9:
import java.util.Scanner;

public class Exercise9
{
    public static void main(String[] args)
    {
        Scanner console = new Scanner(System.in);

        System.out.println("Введите год: ");
        int ex9year = console.nextInt();
        boolean leapCheckOut = exercise9(ex9year);
        System.out.println("Год високосный? Ответ: " + leapCheckOut);
    }

    public static boolean exercise9(int ex9year)
    {
        boolean leapCheckIn = (ex9year % 4 == 0) && (ex9year % 100 != 0 || ex9year % 400 == 0);
        return leapCheckIn;
    }
}