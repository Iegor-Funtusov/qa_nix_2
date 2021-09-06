package ua.com.alevel;

import java.util.UUID;

public class CollectionMain {

    public static void main(String[] args) {
//        for (int i = 0; i < 40; i++) {
//            new ListTest().run();
//        }
//        new SetTest().run();
//
//        AnonimClass anonimClass1 = new AnonimClassImpl();
//        AnonimClass anonimClass2 = new AnonimClass() {
//            @Override
//            public void test1(String s) {
//
//            }
//
//            @Override
//            public void test2(String s, Integer integer) {
//
//            }
//        };

        LambdaInter lambdaInter1 = new LambdaInterImpl();
        int sum = lambdaInter1.sum(10, 6);
        System.out.println("sum = " + sum);

        LambdaInter lambdaInter2 = new LambdaInter() {
            @Override
            public int sum(int a, int b) {
                return a + b;
            }
        };
        sum = lambdaInter2.sum(10, 7);
        System.out.println("sum = " + sum);

        LambdaInter lambdaInter3 = (a, b) -> a + b;
        sum = lambdaInter3.sum(10, 8);
        System.out.println("sum = " + sum);

        LambdaInter lambdaInter4 = Integer::sum;
        sum = lambdaInter4.sum(10, 9);
        System.out.println("sum = " + sum);

        LambdaString lambdaString1 = new LambdaString() {
            @Override
            public void print(String s) {
                System.out.println("s = " + s);
            }
        };
        lambdaString1.print("hello");

        LambdaString lambdaString2 = s -> System.out.println("s = " + s);
        lambdaString2.print("hello 2");

        RandomString randomString = () -> UUID.randomUUID().toString();
        System.out.println("randomString = " + randomString.randomUUID());
    }

    private static AnonimClass getAnonimClass() {

        return new AnonimClass() {
            @Override
            public void test1(String s) {

            }

            @Override
            public void test2(String s, Integer integer) {

            }
        };
    }
}
