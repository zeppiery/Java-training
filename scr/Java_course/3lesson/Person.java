package com.company;
/**
 * Created by Настя on 2/5/2015.
 */
public class Person implements Comparable{

    private final String name;
    private final int age;
    private final EnumPos position;

    public Person(String name, int age, EnumPos position) {
        this.name = name;
        this.age = age;
        this.position = position;
    }

    public String getName() {
        return name;
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

    @Override
    public int compareTo(Object o) {
        //return this.name.compareTo(o.getName());
        Person entry = (Person) o;

        int result = this.name.compareTo(entry.name);
        if(result != 0) {
            return result;
        }

        result = this.age - entry.age;
        if(result != 0) {
            return result;
        }

        result = this.position.compareTo(entry.position);
        if(result != 0) {
            return result;
        }
        return 0;
    }


}
