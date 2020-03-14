package Lesson3;
/*
 1. Создать массив с набором слов (20-30 слов, должны встречаться повторяющиеся):
  - Найти список слов, из которых состоит текст (дубликаты не считать);
  - Посчитать сколько раз встречается каждое слово (использовать HashMap);
 */

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Collections {
    private static String[] array = {"ночь", "улица", "фонарь", "аптека", "бессмысленый", "и", "тусклый", "свет", "живи",
            "еще", "хоть", "четверть", "века", "все", "будет", "так", "исхода", "нет", "умрешь", "начнешь", "опять", "сначала",
            "и", "повторится", "все", "как", "встарь", "ночь", "ледяная", "рябь", "канала", "аптека", "улица", "фонарь"};

    public static void main(String[] args) {
        HashSet<String> hashList = new HashSet<>(Arrays.asList(array));
        System.out.println("Исходный массив: " + Arrays.toString(array));
        System.out.println("Всего слов в массиве: " + array.length);
        System.out.println("Без учета повторящихся слов: " + hashList.size());
        HashMap<String, Integer> counter = new HashMap<>();
        for (String word : array) {
            if ( !counter.containsKey(word) ) {
                counter.put(word, 1);
            }
            else {
                counter.put(word, counter.get(word) + 1);
            }
        }
        for (String word : counter.keySet()) {
            System.out.printf("Слово '%s' встречается %d раз(а);\n", word, counter.get (word));
        }
        System.out.println("===================");
    }
}

