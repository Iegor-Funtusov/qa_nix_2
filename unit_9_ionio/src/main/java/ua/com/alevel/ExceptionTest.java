package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;

public class ExceptionTest {

    String p;

    public void run() {
//        Throwable throwable;
//        Error error;
//        Exception exception;
//        RuntimeException runtimeException;
//        IOException ioException;
//        SQLException sqlException;
        try {
            test1();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void test1() throws Exception {
        test2();
//        test3();
    }

    private void test2() {
        try {
//            System.exit(1);
//            System.out.println("p = " + p.length());
//            String s = "123n";
//            int i1 = Integer.parseInt(s);
            int i = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException = " + e.getMessage());
            throw new ArithmeticException(e.getMessage());
//            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException = " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException = " + e.getMessage());
            e.printStackTrace();
        } finally {
            System.out.println("finally");
        }
//        catch (Exception e) {
//            if (e instanceof ArithmeticException) {
//                System.out.println("ArithmeticException = " + e.getMessage());
//            }
//            if (e instanceof NumberFormatException) {
//                System.out.println("NumberFormatException = " + e.getMessage());
//            }
//        }
        System.out.println("next !!!");
    }

    private void test3() throws Exception {
        int i = 10 / 0;
    }
}
