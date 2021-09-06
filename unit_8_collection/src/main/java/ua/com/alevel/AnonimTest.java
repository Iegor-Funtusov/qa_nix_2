package ua.com.alevel;

import java.util.*;
import java.util.stream.Collectors;

public class AnonimTest {

    public void run() {
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);

        integers = integers.stream().filter(this::isEven).collect(Collectors.toList());
        integers = integers.stream().filter(MathUtil::isEven).collect(Collectors.toList());

        List<String> strings = integers.stream().map(i -> String.valueOf(i)).collect(Collectors.toList());
        List<String> strings1 = integers.stream().map(String::valueOf).collect(Collectors.toList());

        strings1 = integers.stream()
                .distinct()
                .filter(MathUtil::isEven)
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.toList());


        Set<User> set = new HashSet<>();
        set.add(new User(UUID.randomUUID().toString(), "test3"));
        set.add(new User(UUID.randomUUID().toString(), "test4"));
        set.add(new User(UUID.randomUUID().toString(), "test1"));
        set.add(new User(UUID.randomUUID().toString(), "test2"));
        set.add(new User(UUID.randomUUID().toString(), "test5"));
        set.add(new User(UUID.randomUUID().toString(), "test6"));
        set.add(new User(UUID.randomUUID().toString(), "test7"));

        List<UserDto> userDtos = set.stream().map(UserDto::new).collect(Collectors.toList());

    }

    private boolean isEven(int a) {
        return a % 2 == 0;
    }

    private interface Even {
        boolean isEven(int a);
    }
}
