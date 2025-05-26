package Threads;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private int balance = 1000;

    private Lock lock = new ReentrantLock();

    public void withdraw(int amount){
        System.out.println(Thread.currentThread().getName()+" attempting to withdraw: "+amount);
        try {
            if (lock.tryLock(2000, TimeUnit.MILLISECONDS)) {
                if (balance >= amount) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " proceding with withdraw: " + amount);
                        Thread.sleep(3000);
                        balance -= amount;
                        System.out.println(Thread.currentThread().getName() + " Withdrawal Completed... Balance: "+balance);
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    } finally {
                        lock.unlock();
                    }
                } else {
                    System.out.println(Thread.currentThread().getName() + " Insufficien Balance.");
                }
            }else {
                System.out.println(Thread.currentThread().getName() + " could not acquire the lock.");
            }
        }catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }
    public static void main(String[] args) {
    BankAccount sbi = new BankAccount();
    Runnable task = new Runnable() {
        @Override
        public void run() {
            sbi.withdraw(500);
        }
    };
    Thread t1 = new Thread(task, "thread-1");
    Thread t2 = new Thread(task, "thread-2");
    Thread t3= new Thread(task, "thread-3");
    t1.start();
//        try {
////            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        t2.start();
        t3.start();
    }
}
