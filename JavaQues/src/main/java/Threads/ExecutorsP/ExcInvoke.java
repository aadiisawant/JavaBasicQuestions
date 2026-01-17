package Threads.ExecutorsP;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class ExcInvoke {
    public static void main(String[] args) {
        Callable<Integer> callable1 = () -> {
            Thread.sleep(1000);
            System.out.println("ONE");
            return 1;
        };
        Callable<Integer> callable2 = () -> {
            Thread.sleep(1000);
            System.out.println("TWO");
            return 2;
        };
        Callable<Integer> callable3 = () -> {
            Thread.sleep(1000);
            System.out.println("THREE");
            return 3;
        };
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        List<Callable<Integer>>list = Arrays.asList(callable1, callable2, callable3);
        try {
            List<Future<Integer>> futures = executorService.invokeAll(list, 1, TimeUnit.SECONDS);
            for(Future<Integer> nums : futures){
                try {
                    System.out.println(nums.get());
                } catch (CancellationException e){
                    System.out.println(e);
                }
                catch (ExecutionException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        executorService.shutdown();
    }
}
