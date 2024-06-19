package Lesson1;

// Задание 10:
public class Exercise12
{
    public static void main(String[] args)
    {
        int[] nums = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        // Отобразить исходный массив.
        System.out.print("Исходный массив: ");
        for (int i = 0; i < nums.length; i++)
            System.out.print(" " + nums[i]);
        System.out.println();

        // Меняем значения.
        for (int i = 0; i < nums.length; i++)
            if (nums[i] < 6) nums[i] *= 2;

        System.out.print("Массив после изменения: ");
        for (int i = 0; i < nums.length; i++)
            System.out.print(" " + nums[i]);
        System.out.println();
    }
}