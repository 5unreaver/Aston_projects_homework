package Lesson1;

// Задание 10:
public class Exercise10
{
    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        int size = 10;

        // Отобразить исходный массив.
        System.out.print("Исходный массив: ");
        for (int i = 0; i < size; i++)
            System.out.print(" " + nums[i]);
        System.out.println();

        // Меняем значения.
        for (int i = 0; i < size; i++) {
            if (nums[i] == 0) nums[i] = 1;
            else nums[i] = 0;
        }

        System.out.print("Измененный массив: ");
        for (int i = 0; i < size; i++)
            System.out.print(" " + nums[i]);
        System.out.println();
    }
}