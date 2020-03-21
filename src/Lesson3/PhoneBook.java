package Lesson3;

import java.util.HashMap;
import java.util.Map;

/*
2. Написать простой класс PhoneBook(внутри использовать HashMap):
  - В качестве ключа использовать фамилию
  - В каждой записи всего два поля: phone, e-mail
  - Отдельный метод для поиска номера телефона по фамилии (ввели фамилию, получили ArrayList телефонов),
   и отдельный метод для поиска e-mail по фамилии.
   Следует учесть, что под одной фамилией может быть несколько записей.
   Итого должно получиться 3 класса Main, PhoneBook, Person.
 */
public class PhoneBook {

    public static void main(String[] args) {
        var person1 = new Person("Иванов");
        var person2 = new Person("Петров");
        var person3 = new Person("Сидоров");
        var person4 = new Person("Петров");
        var person5 = new Person("Сидоров");

        String[] str1 = {"9032553530", "ivanov@yahoo.fr"};
        String[] str2 = {"903340557" + 1, "petrov@yahoo.fr"};
        String[] str3 = {"903340557" + 2, "sidorov@yahoo.fr"};
        String[] str4 = {"903340557" + 3, "petrov2@yahoo.fr"};
        String[] str5 = {"903340557" + 4, "sidorov2@yahoo.fr"};


        HashMap<Person, HashMap<String, String>> map = new HashMap<>();
        initMap(map, person1, str1);
        initMap(map, person2, str2);
        initMap(map, person3, str3);
        initMap(map, person4, str4);
        initMap(map, person5, str5);

        System.out.println("Полный список");
        for (Person person : map.keySet()) { //for (Map.Entry<Person, HashMap<String, String>> entry : map.entrySet()) {
            System.out.println(person + ": " + map.get(person)); //System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("================");
        System.out.println("Вызов по конкретному имени: " + person2);
        getValueByName(map, person2);
    }

    private static void initMap(HashMap<Person, HashMap<String, String>> map, Person person, String[] str) {
        map.put(person, new HashMap<>());
        map.get(person).put(str[0], str[1]);

    }

    private static void getValueByName(HashMap<Person, HashMap<String, String>> map, Person person) {
        for (Map.Entry<Person, HashMap<String, String>> entry : map.entrySet())
            if (entry.getKey().toString().contains(person.getName()))
                System.out.println(entry.getValue());
//        System.out.println(map.get(person));


    }
}

