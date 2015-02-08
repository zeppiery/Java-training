package com.company;
/**
 * Created by Настя on 2/5/2015.
 */
public class Person {

    private final String name;
    private final int age;
    private final EnumPos position;

    public Person(String name, int age, EnumPos position) {
        this.name = name;
        this.age = age;
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        if (!name.equals(person.name)) return false;
        if (!position.equals(person.position)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age;
        result = 31 * result + position.hashCode();
        return result;
    }
}
