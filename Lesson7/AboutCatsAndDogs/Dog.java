package Lesson7.AboutCatsAndDogs;

public class Dog extends Animal {
    @Override
    public void run(int obstacleLength) {
        String answerRun = (obstacleLength <= 500)?
                ("Пёс " + name + " пробежал " + obstacleLength + " м."):
                ("Пёс " + name + " не сможет пробежать " + obstacleLength + " м.");
        System.out.println(answerRun);
    }

    @Override
    public void swim(int waterLength) {
        String answerSwim = (waterLength <= 10)?
                ("Пёс " + name + " проплыл " + waterLength + " м."):
                ("Пёс " + name + " устал и вернулся на берег.");
        System.out.println(answerSwim);
    }

    // Счётчик собак.
    private static int counter;

    public Dog(String name) {
        super(name);
        counter++;
    }

    public static int getDogCount() {
        return counter;
    }
}