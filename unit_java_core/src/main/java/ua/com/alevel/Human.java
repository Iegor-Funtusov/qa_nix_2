package ua.com.alevel;

import java.util.Objects;

public abstract class Human {

    public static int A = 10;

    private int age = 0;
    private int inn;
    private String name;

    private transient String ggg;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getInn() {
        return inn;
    }

    public void setInn(int inn) {
        this.inn = inn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return inn == human.inn;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, inn, name);
    }

    static abstract class AAA {}

    class BBB extends AAA {}

    final class CCC {}
}
