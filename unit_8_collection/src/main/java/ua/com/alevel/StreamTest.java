package ua.com.alevel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

    public void banch() {
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 200_000_000; i++) {
            integers.add(i);
        }

        long sum = 0;
        long start = 0;
        long end = 0;

        // iteration
        start = System.currentTimeMillis();
        for (Integer i : integers) {
            sum += i;
        }
        end = System.currentTimeMillis() - start;
        System.out.println("end iteration = " + end);

        // stream
        start = System.currentTimeMillis();
        sum = integers.stream().reduce(0, Integer::sum);
        end = System.currentTimeMillis() - start;
        System.out.println("end stream = " + end);

        // stream parallel
        start = System.currentTimeMillis();
        sum = integers.stream().parallel().reduce(0, Integer::sum);
        end = System.currentTimeMillis() - start;
        System.out.println("end stream parallel = " + end);

        // parallelStream
        start = System.currentTimeMillis();
        sum = integers.parallelStream().reduce(0, Integer::sum);
        end = System.currentTimeMillis() - start;
        System.out.println("end parallelStream = " + end);
    }

    public void run() {
        List<Integer> list = Arrays.asList(1,4,7,45,78,34,78,4,9);
        Stream<Integer> stream = Stream.of(1,4,7,45,78,34,78,4,9);

        List<Integer> evenList = new ArrayList<>();
        for (Integer integer : list) {
            if (integer % 2 == 0) {
                evenList.add(integer);
            }
        }
        System.out.println("evenList = " + evenList);
        Collections.sort(evenList);
        System.out.println("evenList = " + evenList);

        evenList = stream
                .distinct()
                .filter(i -> i % 2 == 0)
                .sorted()
                .collect(Collectors.toList());
        System.out.println("evenList = " + evenList);

        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
//        Integer sum = integers.stream()
//                .reduce(0, Integer::sum);

        stream = Stream.of(1,4,7,45,78,34,78,4,9);
        Integer sum = stream
                .distinct()
                .filter(i -> i % 2 == 0)
                .reduce(0, Integer::sum);
        System.out.println("sum = " + sum);

        String s = "ferwf retwqe rqtwerqwer qwreqtwerqwe rqwerqwe qrqwe uuu";
        Stream<String> stream1 = Arrays.stream(s.split(" "));
        boolean existUUU = stream1.anyMatch(s1 -> s1.equals("uuu"));
        System.out.println("existUUU = " + existUUU);
    }
}
