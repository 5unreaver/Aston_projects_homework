package Lesson7.AboutCatsAndDogs;

public class CatBowl
{
    private int food;

    // Конструктор, который оценивает кол-во еды.
    public CatBowl(int food) {
        this.food = (food < 0) ? 0 : food;
    }

    // Метод для получения текущего кол-ва еды.
    public int getFood() {
        return food;
    }

    // Метод для уменьшения еды.
    public void decreaseFood(int amount) {
        if (amount > 0 && this.food >= amount)
            this.food -= amount;
    }

    // Метод для добавления еды.
    public void addFood(int amount) {
        if (amount > 0) this.food += amount;
    }
}