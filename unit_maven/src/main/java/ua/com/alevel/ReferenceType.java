package ua.com.alevel;

public class ReferenceType {

    public void run() {
        int a = 10;
        int b = a;
        System.out.println("b = " + b);

        User user = new User();
        user.setAge(10);
        user.setName("test");

        System.out.println("user = " + user);

        User user1 = user;
        user1.setAge(15);
        System.out.println("user1 = " + user1);
        System.out.println("user = " + user);

        User user2 = new User().build(user1);
        System.out.println("user2 = " + user2);
        System.out.println("user = " + user);
        System.out.println("user1 = " + user1);
    }
}
