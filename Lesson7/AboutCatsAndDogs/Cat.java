package Lesson7.AboutCatsAndDogs;

public class Cat extends Animal
{
    @Override
    public void run(int obstacleLength) {
        String answerRun = (obstacleLength <= 200)?
                ("Кот " + name + " пробежал " + obstacleLength + " м."):
                ("Кот " + name + " не сможет пробежать" + obstacleLength + " м.");
        System.out.println(answerRun);
    }

    @Override
    public void swim(int waterLength) {
        String answerSwim = (waterLength == 0)?
                ("Кот " + name + " доволен, что ему не сказали плыть."):
                ("Кот " + name + " не пойдёт в воду.");
        System.out.println(answerSwim);
    }

    // Счётчик котов.
    private static int counter;

    // Значение голода.
    private boolean isFull;

    public Cat(String name) {
        super(name);
        counter++;
        this.isFull = false;
    }

    public static int getCatCount() {
        return counter;
    }

    public void eat(CatBowl bowl, int food) {
        if (bowl.getFood() >= food) {
            bowl.decreaseFood(food);
            this.isFull = true;
        }
    }

    public boolean satietyAfter() {
        return isFull;
    }
}