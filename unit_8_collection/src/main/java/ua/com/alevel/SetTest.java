package ua.com.alevel;

import java.util.*;

public class SetTest {

    public void run() {
//        System.out.println(new User(1, "test1").equals(new User(1, "test1")));
        Set<User> set = new HashSet<>();
        set.add(new User(UUID.randomUUID().toString(), "test3"));
        set.add(new User(UUID.randomUUID().toString(), "test4"));
        set.add(new User(UUID.randomUUID().toString(), "test1"));
        set.add(new User(UUID.randomUUID().toString(), "test2"));
        set.add(new User(UUID.randomUUID().toString(), "test5"));
        set.add(new User(UUID.randomUUID().toString(), "test6"));
        set.add(new User(UUID.randomUUID().toString(), "test7"));
        for (User user : set) {
            System.out.println("user = " + user);
        }

        System.out.println();

        set = new LinkedHashSet<>();
        set.add(new User(UUID.randomUUID().toString(), "test3"));
        set.add(new User(UUID.randomUUID().toString(), "test4"));
        set.add(new User(UUID.randomUUID().toString(), "test1"));
        set.add(new User(UUID.randomUUID().toString(), "test2"));
        set.add(new User(UUID.randomUUID().toString(), "test5"));
        set.add(new User(UUID.randomUUID().toString(), "test6"));
        set.add(new User(UUID.randomUUID().toString(), "test7"));
        for (User user : set) {
            System.out.println("user = " + user);
        }

        Set<Integer> integers = new TreeSet<>();
        integers.add(5);
        integers.add(17);
        integers.add(5);
        integers.add(4);
        integers.add(1);
        integers.add(-1);
        System.out.println("integers = " + integers);

        Set<User> users = new TreeSet<>();
        users.add(new User(UUID.randomUUID().toString(), "test3"));
        users.add(new User(UUID.randomUUID().toString(), "test4"));
        users.add(new User(UUID.randomUUID().toString(), "test2"));
        users.add(new User(UUID.randomUUID().toString(), "test2"));
        users.add(new User(UUID.randomUUID().toString(), "test5"));
        users.add(new User(UUID.randomUUID().toString(), "test6"));
        users.add(new User(UUID.randomUUID().toString(), "test7"));
        for (User user : users) {
            System.out.println("user = " + user);
        }
    }
}
