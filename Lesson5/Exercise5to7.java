package Lesson5;// Задания 5-7:
import java.util.Scanner;

public class Exercise5to7
{
    public static void main(String[] args) // в скобках = то, что принимает метод.
    {
        int c = 10; // и эту переменную мы можем закинуть в метод ниже.
        boolean ex5 = exercise5(20, 10);
        System.out.println(ex5);

        Scanner console = new Scanner(System.in);

        System.out.println("Введите число для задания 6: ");
        int ex6value = console.nextInt();
        exercise6(ex6value);

        System.out.println("Введите число для задания 7: ");
        int ex7value = console.nextInt();
        boolean ex7 = exercise7(ex7value);
        System.out.println(ex7);
    }
        // Задание 5:
        public static boolean exercise5(int a, int b) // без разницы, какие названия, они просто использ-ся внутри метода.
        // void = если функция ничего не возвращает
        {
            /*
            if ((a+b) <= 20 && (a+b) > 10)
            // & = битовое И (битовое - операция сложения над битами чисел, т. е. над каждым битом числа).
            // && = просто И (с булевыми значения).
            return true;
            else return false;
            // любая ветка должна возвращать return boolean.
            // метод - чёрный ящик, и в его определении (строка 14) содержится
            // его описание (что он принимает и что он возвращает).
            */

            return ((a+b) <= 20 && (a+b) > 10);
        }

        // Задание 6:
        public static void exercise6(int ex6value)
        {
            /* if(ex6value >= 0)
            System.out.println("Число положительное.");
            else System.out.println("Число отрицательное."); */

            // тернарный оператор:
            String securityAnswer = (ex6value >= 0)?"Число положительное.":"Число отрицательное.";
            System.out.println(securityAnswer);
        }

        // Задание 7:
        public static boolean exercise7(int ex7value)
        {
            // if(ex7value >= 0) return true; // тафтология, ибо если больше нуля, то это уже true
            // else return false;

            return ex7value >= 0;
        }
}