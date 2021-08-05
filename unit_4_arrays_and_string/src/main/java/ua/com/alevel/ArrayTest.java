package ua.com.alevel;

public class ArrayTest {

    private int[] ints;

    ArrayTest(int a) {
        this.ints = new int[a];
    }

    ArrayTest() {}

    public void run() {
        int[] ints = new int[5];
        ints[2] = 8;
        ints[ints.length - 1] = 10;
        for (int i = 0; i < ints.length; i++) {
            System.out.println("i = " + ints[i]);
        }
        Integer[] integers = new Integer[5];
        integers[4] = 67;
        for (Integer integer : integers) {
            System.out.println("integer = " + integer);
        }
        char[] chars = { 'a', 'b', 'c' };
        for (char aChar : chars) {
            System.out.println("aChar = " + aChar);
        }
        int size = 4;
        int[][] matrix = new int[size][4];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = 10;
            }
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.println("j = " + matrix[i][j]);
            }
        }
        int[][] newInts = { { 1, 2, 3 }, { 4, 5 }, { 6, 7, 8, 9, 0, -9} };
        for (int i = 0; i < newInts.length; i++) {
            for (int j = 0; j < newInts[i].length; j++) {
                System.out.println(newInts[i][j]);
            }
        }

        vararg(9, 8, 6, 0, 23, 6789);
//        vararg(ints);

        vararg1(ints);

        varargNumber(6, 8.0, 45, -9.7);

        A[] aObject = new A[2];
        aObject[0] = new A1();
        aObject[1] = new A2();
    }

    private void varargNumber(Number ... numbers) {
        for (Number number : numbers) {
            System.out.println("number = " + number);
        }
    }

    private void vararg(int ... ints) {
        for (int anInt : ints) {
            System.out.println("anInt: " + anInt);
        }
    }

    private void vararg1(int[] ints) {

    }
}
