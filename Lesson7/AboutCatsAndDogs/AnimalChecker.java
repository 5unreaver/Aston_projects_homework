package Lesson7.AboutCatsAndDogs;

public class AnimalChecker {
    public static void main(String[] args) {
        Dog dog1 = new Dog("Рекс");
        Dog dog2 = new Dog("Атос");

        Cat cat1 = new Cat("Леопольд");
        Cat cat2 = new Cat("Бонифаций");
        Cat cat3 = new Cat("Барсик");

        dog1.run(600);
        dog1.swim(5);

        dog2.run(30);
        dog2.swim(15);

        cat2.run(150);
        cat2.swim(0);

        System.out.println("\nВсего собак: " + Dog.getDogCount());
        System.out.println("Всего котов: " + Cat.getCatCount());
        System.out.println("Всего животных: " + Dog.getDogCount() + Cat.getCatCount() + "\n");

        // Создаём массив котов.
        Cat[] cats = {cat1, cat2, cat3};
        CatBowl bowl = new CatBowl(40);

        for (Cat cat : cats) {
            int minValue = 15;
            int maxValue = 20;
            // От 15 до 20 включительно.
            int randomValue = minValue + (int) (Math.random() * (maxValue - minValue + 1));

            // Проверяем, достаточно ли еды для текущего кота.
            if (bowl.getFood() >= randomValue) {
                cat.eat(bowl, randomValue);
                System.out.println("Кот " + cat.name + " съел " + randomValue + " единиц корма.");
            }
            else {
                System.out.println("Для кота " + cat.name + " мало еды.");
            }
        }

        // Проверка сытости котов.
        for (Cat cat : cats) {
            System.out.println("Кот " + cat.name + " сыт: " + cat.satietyAfter());
        }
    }
}