package Threads.ExecutorsP;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MultipleThreadDemo {

    public static int factorial(int num){
        int fact=1;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for(int i=num; i>0;i--){
            fact *= i;
        }
        return fact;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for(int i=1;i<10;i++){
            int finalI = i;
            executor.submit(()->{
                long fact = factorial(finalI);
                System.out.println(fact+" ,"+Thread.currentThread().getName());
            });
        }
        executor.shutdown();
        try {
            executor.awaitTermination(100, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("total time: "+(System.currentTimeMillis()-startTime));
    }
}
