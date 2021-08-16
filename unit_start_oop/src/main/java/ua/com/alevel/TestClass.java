package ua.com.alevel;

public class TestClass extends BaseClass {

    private String value;

    public TestClass() {
        System.out.println("TestClass.TestClass1");
    }

    public TestClass(String value) {
        this();
        System.out.println("TestClass.TestClass2");
        this.value = value;
    }

    public TestClass(String value, String name) {
        super(name);
        System.out.println("TestClass.TestClass3");
        this.value = value;
    }

    public void test() {}

    public void test(String name) {}
}
