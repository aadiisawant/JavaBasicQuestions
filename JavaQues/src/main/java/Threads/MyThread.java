package Threads;

public class MyThread extends Thread{

    @Override
    public void run(){
        System.out.println("Thread is Running.");
        try {
            Thread.sleep(6000);
            System.out.println("Done...");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String args[]) throws InterruptedException{
        MyThread t1= new MyThread();
        t1.setName("thread one");
        System.out.println(Thread.currentThread().getName()+" "+Thread.currentThread().getState());
        System.out.println(t1.getName()+" "+t1.getState());
        t1.start();
        System.out.println(t1.getName()+" "+t1.getState());
        Thread.sleep(3000);
        t1.join();
        System.out.println(Thread.currentThread().getName()+" "+Thread.currentThread().getState());

    }
}