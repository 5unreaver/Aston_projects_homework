package Lesson7.AboutCatsAndDogs;

public abstract class Animal
{
    protected String name;
    public Animal(String name) {
        this.name = name;;
    };

    public abstract void run(int obstacleLength);
    public abstract void swim(int waterLength);
}