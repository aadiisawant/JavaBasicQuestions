package ComparatorQues;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Person implements Comparable<Person>{

    String name;
    int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person o) {
//        return Integer.compare(this.age, o.age);
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
            new Person("aditya",24),
            new Person("ram",25),
            new Person("ben",21)
        );

        persons
                .stream()
//                .sorted(Comparator.comparing(p -> p.name))
                .sorted()
                .forEach(System.out::println);
    }
}
