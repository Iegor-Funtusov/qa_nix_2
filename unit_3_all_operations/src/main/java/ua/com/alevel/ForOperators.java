package ua.com.alevel;

public class ForOperators {

    public void run() {

        int a = 123;
        int b = a * 2;
        System.out.println("b = " + b);
        b = a << 1;
        System.out.println("b = " + b);

        b = a / 2;
        System.out.println("b = " + b);
        b = a >> 1;
        System.out.println("b = " + b);

        a = 1;
        b = 3;

        int c = a | b;
        System.out.println("c = " + c);



//        for (int i = 0; i < 10; i++) {
//            System.out.println("i = " + i);
//        }
//
//        int i = 0;
//        while (i < 10) {
//            System.out.println("i = " + i);
//            i++;
//        }
//
//        String s = "hello world";
//        char[] chars = s.toCharArray();
//        for (int i1 = 0; i1 < chars.length; i1++) {
//            System.out.println("chars = " + chars[i1]);
//        }
//
//        int sum = 0;
//        for (int j = 0; j < 101; j++) {
//            sum = sum + j;
//        }
//        System.out.println("sum = " + sum);
    }
}
