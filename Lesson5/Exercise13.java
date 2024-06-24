package Lesson5;

public class Exercise13
{
    public static void main(String[] args)
    {
        task13();
    }

    public static void task13()
    {
        int a = 6;

        // Создаем двумерный массив размером 6 на 6.
        int[][] nums = new int[a][a];

        // Заполняем диагонали.
        for (int i = 0; i < a; i++)
        {
            nums[i][i] = 1;
            nums[i][a - 1 - i] = 1;
        }

        // Выводим массив.
        for (int i = 0; i < a; i++)
        {
            for (int j = 0; j < a; j++) System.out.print(nums[i][j] + " ");

            System.out.println();
        }
    }
}