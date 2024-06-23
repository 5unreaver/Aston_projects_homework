// Задание 3:
package Lesson6;

import java.util.Collection;
import java.util.ArrayList;
import java.time.LocalTime;

public class Park
{
    private String name;
    private Collection<Attraction> attractions;

    public Park(String name)
    {
        this.name = name;
        this.attractions = new ArrayList<>();
    }

    public class Attraction
    {
        public String name;
        public LocalTime openingTime;
        public LocalTime closingTime;
        public int price;

        // Конструктор аттракции
        public Attraction(String name, LocalTime openingTime, LocalTime closingTime, int price)
        {
            this.name = name;
            this.openingTime = openingTime;
            this.closingTime = closingTime;
            this.price = price;
        }
    }

    public void addAttraction(Attraction attraction)
    {
        attractions.add(attraction);
    }

    // Метод для получения списка аттракционов:
    public Collection<Attraction> getAttractions()
    {
        return attractions;
    }

    public static void main(String[] args)
    {
        Park park1 = new Park("Порт Авентура");

        LocalTime openingTime = LocalTime.of(8, 0);    // 08:00
        LocalTime closingTime = LocalTime.of(19, 0);   // 19:00

        // Создание и добавление аттракциона.
        Park.Attraction tutukiSplash = park1.new Attraction("Tutuki Splash",
                openingTime, closingTime, 15);

        park1.addAttraction(tutukiSplash);

        // Вывод аттракционов на консоль:
        Collection<Attraction> attractions = park1.getAttractions();
        for (Attraction attraction : attractions)
        {
            System.out.println("Название аттракциона: " + attraction.name);
            System.out.println("Время открытия: " + attraction.openingTime);
            System.out.println("Время закрытия: " + attraction.closingTime);
            System.out.println("Цена: " + attraction.price);
            System.out.println();
        }
    }
}