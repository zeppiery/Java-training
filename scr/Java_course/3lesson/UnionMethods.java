package com.company;

import java.util.Arrays;

public class  UnionMethods {

    public static void main(String[] args) {
        Person director = new Person("Petro", 50, EnumPos.DIRECTOR);
        Person developer1 = new Person("Ivan", 40, EnumPos.DEVELOPER);
        Person developer2 = new Person("Stepan", 30, EnumPos.DEVELOPER);
        Person qa1 = new Person("Tamara", 25, EnumPos.QA);
        Person qa2 = new Person("Stepan", 30, EnumPos.DEVELOPER);
        Person[] PersonArrayLeft = new Person[]{director,developer1,developer2,qa2};
        Person[] PersonArrayRight = new Person[]{developer1,developer2,qa1};
        Person[] PersonExpectResult = new Person[]{director,developer1,developer2,qa1,qa2};
        System.out.println("EmplArrayLeft:= " + Arrays.toString(PersonArrayLeft));
        System.out.println("EmplArrayRight:= " + Arrays.toString(PersonArrayRight));

        UnionMethods Main = new UnionMethods();
        Person[] PersonReturnValue;
        System.out.println("Merge method:");
        PersonReturnValue = Main.merge(PersonArrayLeft, PersonArrayRight);
        System.out.println("Inner Union method:");
        PersonReturnValue = Main.innerUnion(PersonArrayLeft, PersonArrayRight);
        System.out.println("Outer Union Method:");
        PersonReturnValue = Main.outerUnion(PersonArrayLeft, PersonArrayRight);

        System.out.println("returnValue:= " + Arrays.toString(PersonReturnValue));
        //System.out.println("expectResult:= " + Arrays.toString(PersonExpectResult));
    }

    public Person[] merge(Person[] personArrayLeft, Person[] personArrayRight) {//метод Merge
        Person[] buffArray = new Person[personArrayLeft.length+personArrayRight.length];
        Arrays.sort(personArrayLeft);
        Arrays.sort(personArrayRight);
        System.arraycopy(personArrayLeft,0,buffArray,0,personArrayLeft.length);
        System.out.println("buffArray:= " + Arrays.toString(buffArray));
        int countFoundedElement = 0;

        for (Person arrayElement: personArrayRight){
            if (Arrays.binarySearch(personArrayLeft,arrayElement)<0) {
                buffArray[personArrayLeft.length+countFoundedElement] = arrayElement;
                countFoundedElement++;
            }
        }

        Person[] resArray = Arrays.copyOf(buffArray,personArrayLeft.length+countFoundedElement);
        return resArray;
    }
    public Person[] innerUnion(Person[] personArrayLeft, Person[] personArrayRight) {//метод
        Arrays.sort(personArrayLeft);
        Arrays.sort(personArrayRight);
        Person[] buffArray = new Person[personArrayLeft.length+personArrayRight.length];
        Person[] resArray = new Person[personArrayLeft.length+personArrayRight.length];
        System.arraycopy(personArrayLeft,0,buffArray,0,personArrayLeft.length);
        System.arraycopy(personArrayRight,0,buffArray,personArrayLeft.length,personArrayRight.length);
        System.out.println("buffArray:= " + Arrays.toString(buffArray));
        Arrays.sort(buffArray);
        int countFoundedElement = 0;
        Person prevEml=new Person("test", 0, EnumPos.DIRECTOR);

        for (Person arrayElement: buffArray){
            if (Arrays.binarySearch(personArrayLeft, arrayElement) >= 0
                    && Arrays.binarySearch(personArrayRight, arrayElement)>=0
                    && (!arrayElement.equals(prevEml))) {
                resArray[countFoundedElement] = arrayElement;
                prevEml=arrayElement;
                countFoundedElement++;
            }
        }

        resArray = Arrays.copyOf(buffArray,countFoundedElement);
        return resArray;
    }

    public Person[] outerUnion(Person[] personArrayLeft, Person[] personArrayRight) {//метод
        Arrays.sort(personArrayLeft);
        Arrays.sort(personArrayRight);
        Person[] buffArray = new Person[personArrayLeft.length+personArrayRight.length];
        Person[] resArray = new Person[personArrayLeft.length+personArrayRight.length];
        System.arraycopy(personArrayLeft,0,buffArray,0,personArrayLeft.length);
        System.arraycopy(personArrayRight,0,buffArray,personArrayLeft.length,personArrayRight.length);
        System.out.println("buffArray:= " + Arrays.toString(buffArray));
        Arrays.sort(buffArray);
        int countFoundedElement = 0;

        for (Person arrayElement: buffArray){
            if (Arrays.binarySearch(personArrayLeft, arrayElement)>=0
                    && Arrays.binarySearch(personArrayRight, arrayElement)<0){
                resArray[countFoundedElement] = arrayElement;
                countFoundedElement++;
            }
        }

        for (Person arrayElement: buffArray){
            if (Arrays.binarySearch(personArrayLeft, arrayElement) < 0
                    && Arrays.binarySearch(personArrayRight, arrayElement) >= 0) {
                resArray[countFoundedElement] = arrayElement;
                countFoundedElement++;
            }
        }

            resArray = Arrays.copyOf(buffArray,countFoundedElement);
            return resArray;
    }
}
