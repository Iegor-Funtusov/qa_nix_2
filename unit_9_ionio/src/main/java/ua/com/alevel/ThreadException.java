package ua.com.alevel;

import java.util.Random;

public class ThreadException implements Runnable {

    @Override
    public void run() {
        int r = new Random().nextInt(2);
        if (r == 1) {
            throw new RandomException("Something problem");
        } else {
            System.out.println("problem is not exist");
        }
    }
}
