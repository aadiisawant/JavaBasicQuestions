package Threads;

public class ThreadPriority extends Thread{

    public ThreadPriority(String name){
        super(name);
    }
    @Override
    public void run(){
        System.out.println("Thread is Running.");
        for (int i=1;i<=5;i++){
            System.out.println(Thread.currentThread().getName()+" - Priority: "+Thread.currentThread().getPriority()+" -count: "+i);
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ThreadPriority t1 = new ThreadPriority("Min Priority");
        t1.setPriority(MIN_PRIORITY);
        ThreadPriority t2 = new ThreadPriority("Norm Priority");
        t2.setPriority(NORM_PRIORITY);
        ThreadPriority t3 = new ThreadPriority("Max Priority");
        t3.setPriority(MAX_PRIORITY);
        t1.start();
        t2.start();
        t3.start();
    }
}
