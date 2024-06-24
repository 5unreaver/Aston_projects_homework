package Lesson5;// Задание 14:
import java.util.Scanner;
import java.util.Arrays;

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

        int[] result = exercise14(len, initialValue);
        for (int r = 0; r < result.length; r++)
        {
            System.out.print(result[r]);
        }
        // System.out.println(result); // Тут он будет выводить ссылку на массив,
        // и получаются письмена Древних Богов.
        // Обрати внимание на письмена - это ссылка на выделенную память для массива,
        // и она динамически выделяется. Там целый механизм, ибо массив мб разной длины.
    }

    public static int[] exercise14(int len, int initialValue)
    {

        // Создаем и выводим на экран массив.
        int[] nums = new int[len];
        Arrays.fill(nums, initialValue);

        /*for (int i = 0; i < len; i++)
        {
            nums[i] = initialValue;
        }*/
        return nums;
    }
}