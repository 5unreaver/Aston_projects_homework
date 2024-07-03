package Lesson9;

import java.util.*;

public class TelephoneDirectoryBlank {
    public static void main(String[] args) {
        TelephoneDirectoryBlank directory = new TelephoneDirectoryBlank();

        // Добавляем записи в телефонный справочник
        directory.addToNumberList("Зильберман", "+7-800-355-35-35");
        directory.addToNumberList("Розенбаум", "+7-976-355-35-36");
        directory.addToNumberList("Петров", "+7-985-355-37-77");
        directory.addToNumberList("Зильберман", "+7-800-400-87-87");

        System.out.println("тел. Зильбермана: " + directory.get("Зильберман"));
        System.out.println("тел. Розенбаума: " + directory.get("Розенбаум"));
        System.out.println("тел. Петрова: " + directory.get("Петров"));
        System.out.println("тел. Иванова: " + directory.get("Иванов"));
        // "Иванов" для примера имени, которого нет в справочнике
    }

    private Map<String, List<String>> phoneBook;

    // Конструктор инициализирует пустой телефонный справочник
    public TelephoneDirectoryBlank() {
        phoneBook = new HashMap<>();
    }

    // Метод для добавления записи в телефонный справочник
    public void addToNumberList(String surname, String phoneNumber) {
        // Если фамилия уже существует, добавляем новый номер в список
        phoneBook.computeIfAbsent(surname, k -> new ArrayList<>()).add(phoneNumber);
    }

    // Метод для получения списка номеров по фамилии
    public List<String> get(String surname) {
        return phoneBook.getOrDefault(surname, Collections.emptyList());
    }
}