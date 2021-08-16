package ua.com.alevel;

public abstract class BaseClass {

    private String name;

    public BaseClass() { }

    public BaseClass(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
