package ua.com.alevel;

public class ArrayType {

    public void run() {
        Integer[] ints = new Integer[10];
        ints[0] = 10;
        System.out.println("ints = " + ints[0]);
        System.out.println("ints = " + ints[3]);
        System.out.println("ints = " + ints[ints.length - 1]);

        Integer[] ints1 = { 4, 7, 89 };
        ints1[0] = 4;
        ints1[1] = 7;
        ints1[2] = 89;
    }
}
