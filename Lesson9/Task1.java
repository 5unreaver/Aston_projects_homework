package Lesson9;

import java.util.*;

public class Task1 {
    public static void main(String[] args) {

        String[] wordsArray = {
            "Лора Палмер", "Дейл Купер", "Одри Хорн", "Боб", "Донна Хейворд",
            "Маргарет Лантерман", "Шелли Джонсон", "Бобби Бригз", "Гарри С. Трумэн",
            "Дениз Брайсон", "Лиланд Палмер", "Джози Паккард", "Лео Джонсон",
            "Пит Мартелл", "Лора Палмер", "Боб", "Дейл Купер", "Гарри С. Трумэн"
        };

        // Преобразуем массив в список (коллекцию)
        List<String> wordsList = Arrays.asList(wordsArray);

        // Используем Set для поиска уникальных слов
        Set<String> uniqueWords = new HashSet<>(wordsList);

        // Используем Map для подсчета, сколько раз встречается слово
        Map<String, Integer> wordCountMap = new HashMap<>();
        for (String word : wordsList) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }

        System.out.println("Уникальные слова: " + uniqueWords);

        System.out.println("Сколько раз встречается слово:");
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
