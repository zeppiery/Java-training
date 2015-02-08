package Java_course;

public class Main {

    public static void main(String[] args) {
        for (String arg : args) {
            System.out.println("Аргумент = " + arg);
        }

        System.out.println("Количество= " + args.length);
    }
}
