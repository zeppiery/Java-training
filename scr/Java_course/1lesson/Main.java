package com.company;
/**
 * Created by Настя on 2/5/2015.
 */
//package com.Company;
public class Main {
    public static void main(String[] args) {
        Person director = new Person("Petro", 50, EnumPos.DIRECTOR);
        Person developer1 = new Person("Ivan", 40, EnumPos.DEVELOPER);
        Person developer2 = new Person("Stepan", 30, EnumPos.DEVELOPER);
        Person qa1 = new Person("Tamara", 25, EnumPos.QA);
        Person qa2 = new Person("Stepan", 30, EnumPos.DEVELOPER);

        System.out.println("director and developer1 is " + (director == developer1) + " and director.equals(developer1) is " + director.equals(developer1));
        System.out.println("developer1==developer2 is " + (developer1 == developer2) + " and developer1.equals(developer2) is " + developer1.equals(developer2));
        System.out.println("developer2==qa2 is " + (developer2 == qa2) + " and developer2.equals(qa2) is " + developer2.equals(qa2));
        System.out.println("qa1==qa2 is " + (qa1 == qa2) + " and qa1.equals(qa2) is " + qa1.equals(qa2));

    }
}
