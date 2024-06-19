package Lesson1;// Задание 14:
import java.util.Scanner;

public class Exercise14
{
    public static void main(String[] args)
    {
        Scanner console = new Scanner(System.in);

        // Запрашиваем длину массива.
        System.out.print("Введите длину массива: ");
        int len = console.nextInt();

        // Запрашиваем начальное значение.
        System.out.print("Введите начальное значение массива: ");
        int initialValue = console.nextInt();

        // Создаем и выводим на экран массив.
        int[] nums = new int[len];
        System.out.print("Получившийся массив: ");
        for (int i = 0; i < len; i++)
        {
            nums[i] = initialValue;
            System.out.print(nums[i] + " ");
        }
    }
}