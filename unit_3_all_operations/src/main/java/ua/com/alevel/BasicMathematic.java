package ua.com.alevel;

import java.util.Date;

public class BasicMathematic {

    public void run() {
        int a = 10;
        int b = 15;
        int c = a + b;
        System.out.println("c = " + c);

        a = 3;
        b = 2;
        c = a / b;
        System.out.println("c = " + c);
        c = a % b;
        System.out.println("c = " + c);
        a = 4;
        c = a % b;
        System.out.println("c = " + c);

        c = a * b;
        System.out.println("c = " + c);

        System.out.println(new Date());
        double d = Math.sqrt(27);
        System.out.println("d = " + d);
    }
}
