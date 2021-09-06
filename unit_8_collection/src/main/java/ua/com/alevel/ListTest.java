package ua.com.alevel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListTest {

    private static final int SIZE = 1_000_000;

    public void run() {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        long start = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            arrayList.add(i);
        }
        long end = System.currentTimeMillis() - start;
        System.out.println("add arrayList finish = " + end);

        start = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            linkedList.add(i);
        }
        end = System.currentTimeMillis() - start;
        System.out.println("add linkedList finish = " + end);

        Iterator<Integer> iterator = arrayList.iterator();
        start = System.currentTimeMillis();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
        end = System.currentTimeMillis() - start;
        System.out.println("remove arrayList finish = " + end);

        iterator = linkedList.iterator();
        start = System.currentTimeMillis();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
        end = System.currentTimeMillis() - start;
        System.out.println("remove linkedList finish = " + end);

//        arrayList
//        add O(1)
//        remove O(n)

//        linkedList
//        add 0(n)
//        add 0(1)
    }
}
