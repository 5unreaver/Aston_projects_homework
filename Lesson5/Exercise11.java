package Lesson5;

// Задание 11:
public class Exercise11
{
    public static void main(String[] args)
    {
        task11();
    }

    public static void task11()
    {
        int nums[] = new int[100];

        // Отобразить исходный массив.
        System.out.println("Исходный массив:");
        for (int i = 0; i < nums.length; i++)
        {
            nums[i] = i + 1;
            if (i != nums.length - 1) System.out.print(nums[i] + ", ");
            else System.out.print(nums[i] + ".");

            // После десяток с новой строки
            if ((i + 1) % 10 == 0) System.out.println();
        }
    }
}