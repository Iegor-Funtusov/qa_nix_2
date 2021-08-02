package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IfOperators {

    public void run() {
        int a = 10 % 5;
        if (a != 0) {
            System.out.println("a != 0");
        } else {
            System.out.println("a == 0");
        }

        String res = (a != 0) ? ((a != 0) ? "a != 0" : "a == 0") : "a == 0";
        System.out.println("res = " + res);

        if (a != 0) {
            if (a != 0) {
                res = "a != 0";
            } else {
                res = "a == 0";
            }
        } else {
            res = "a == 0";
        }

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("please, enter your value:");
            a = Integer.parseInt(bufferedReader.readLine());
            System.out.println("a = " + a);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if ((a == 0 || "zzz".startsWith("z")) && "zzz".endsWith("z")) {
            System.out.println("a == 0");
            System.out.println("zzz" + ".startsWith(\"z\")");
        } else if (a == 1) {
            System.out.println("a == 1");
        } else if (a == 2) {
            System.out.println("a == 2");
        } else if (a == 3) {
            System.out.println("a == 3");
        } else {
            System.out.println("a more then 3");
        }

        switch (a) {
            case 0 : {
                System.out.println("a == 0");
            } break;
            case 1 : {
                System.out.println("a == 1");
            } break;
            case 2 : {
                System.out.println("a == 2");
            } break;
            case 3 : {
                System.out.println("a == 3");
            } break;
            default : {
                System.out.println("a more then 3");
            }
        }
    }
}
