package ua.com.alevel;

import java.util.ArrayList;
import java.util.List;

public class ExceptionExecutor {

    public void run() {
        Thread thread = Thread.currentThread();
        System.out.println("thread = " + thread.getName());
        List<ThreadException> testExecutors = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            testExecutors.add(new ThreadException());
        }
        for (int i = 0; i < 10; i++) {
            try {
                testExecutors.get(i).run();
            } catch (RandomException e) {
                System.out.println("e = " + e.getMessage());
            }
        }
    }
}
