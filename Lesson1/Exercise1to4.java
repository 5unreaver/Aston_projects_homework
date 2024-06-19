package Lesson1;

// Задания 1-4:
public class Exercise1to4 {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
    }

    // Задание 1:
    public static void printThreeWords() {
        System.out.println("Orange\nBanana\nApple");
    }

    // Задание 2:
    public static void checkSumSign() {
        int a = 10, b = 20;

        if((a + b) >= 0) System.out.println("Сумма положительная");
        else System.out.println("Сумма отрицательная");
    }

    // Задание 3:
    public static void printColor() {
        int value = -100;

        if(value <= 0) System.out.println("Красный");
        else if (value <= 100) System.out.println("Жёлтый"); /* value автоматически не мб
        меньше или равно нулю. else вып-ся,
        если условия выше не выполнились. */
        else System.out.println("Зелёный");
    }

    // Задание 4:
    public static void compareNumbers() {
        int a = 10, b = 20;

        if(a >= b) System.out.println("a >= b");
        else System.out.println("a < b");
    }
}