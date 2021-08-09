package ua.com.alevel;

public class AQAA {

    private final int age;
    private final String name;

    AQAA(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "AQAA{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
