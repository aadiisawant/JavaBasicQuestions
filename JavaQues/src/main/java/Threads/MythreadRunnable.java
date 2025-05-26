package Threads;

public class MythreadRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("Thread using Runnable Interface");
    }

    public static void main(String args[])throws InterruptedException{
        MythreadRunnable mythreadRunnable= new MythreadRunnable();
        Thread t1 = new Thread(mythreadRunnable);
        System.out.println(t1.getState());
        t1.start();
        Thread.sleep(3000);
        System.out.println(t1.getState());
    }
}
