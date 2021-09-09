package ua.com.alevel;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapTest {

    public void run() {
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("test1", "test1");
        hashMap.put("test2", "test2");
        hashMap.put("test3", "test3");
        hashMap.put("test4", "test4");
        hashMap.put("test5", "test5");
        hashMap.put("test6", "test6");
        hashMap.put("test7", "test7");

        hashMap.forEach((k, v) -> {
            System.out.println("k = " + k);
        });


        Map<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("test1", "test1");
        linkedHashMap.put("test2", "test2");
        linkedHashMap.put("test3", "test3");
        linkedHashMap.put("test4", "test4");
        linkedHashMap.put("test5", "test5");
        linkedHashMap.put("test6", "test6");
        linkedHashMap.put("test7", "test7");

        linkedHashMap.forEach((k, v) -> {
            System.out.println("k = " + k);
        });

        System.out.println();

        Map<String, String> treeMap = new TreeMap<>();
        treeMap.put("test3", "test3");
        treeMap.put("test1", "test1");
        treeMap.put("test2", "test2");
        treeMap.put("test5", "test5");
        treeMap.put("test6", "test6");
        treeMap.put("test7", "test7");
        treeMap.put("test4", "test4");

        treeMap.forEach((k, v) -> {
            System.out.println("k = " + k);
        });
    }
}
