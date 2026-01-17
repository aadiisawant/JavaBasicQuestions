package Threads.ExecutorsP;

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
        Thread [] threads = new Thread[9];
        for(int i=1;i<10;i++){
            int finalI = i;
            threads[i-1] = new Thread(
                    ()->{
                        long fact = factorial(finalI);
                        System.out.println(fact+" ,"+Thread.currentThread().getName());
                    }
            );
            threads[i-1].start();
        }
        for(Thread thread: threads){
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("total time: "+(System.currentTimeMillis()-startTime));
    }
}
