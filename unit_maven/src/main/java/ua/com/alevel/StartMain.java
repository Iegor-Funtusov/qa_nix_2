package ua.com.alevel;

import java.math.BigDecimal;

public class StartMain {

    public static void main(String[] args) {
//        System.out.println("args = " + args[0]);
//        System.out.println("args = " + args[1]);
//        new PrimitiveType().run();
//        new ReferenceType().run();
//        new ArrayType().run();

        System.out.println(2.0 - 1.9);

        BigDecimal left = new BigDecimal("2.0");
        BigDecimal right = new BigDecimal("1.9");
        BigDecimal res = left.subtract(right);
        Double aDouble = res.doubleValue();
        System.out.println("aDouble = " + aDouble);

//        NullProblem nullProblem = new NullProblem();
//        System.out.println("nullProblem = " + nullProblem);
//        String s = nullProblem.getI2().toString();
    }
}
