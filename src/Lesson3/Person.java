package Lesson3;

import java.util.HashMap;

public class Person {
    String name;

    protected Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
