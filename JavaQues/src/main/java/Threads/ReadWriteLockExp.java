package Threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExp {

    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private int count = 0;
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    public void Increment(){
        writeLock.lock();
        try {
            count++;
            Thread.sleep(10);
        }catch(Exception e){
            Thread.currentThread().interrupt();
        }finally {
            writeLock.unlock();
        }
    }

    public int getCount(){
        readLock.lock();
        try {
            return count;
        }finally {
            readLock.unlock();
        }
    }

    public static void main(String[] args) {
        ReadWriteLockExp lock = new ReadWriteLockExp();
        Runnable readTask = new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<10;i++){
                    System.out.println(Thread.currentThread().getName()+" read: "+ lock.getCount());
                }
            }
        };
        Runnable writeTask = new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<10;i++){
                    lock.Increment();
                    System.out.println(Thread.currentThread().getName()+"Incremented ");
                }
            }
        };
        Thread t1 = new Thread(readTask, "Read1 thread");
        Thread t3 = new Thread(writeTask, "write  thread");
        Thread t2 = new Thread(readTask, "Read2 thread");
        t1.start();
        t2.start();
        t3.start();
    }
}
