package Threads;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
  private  int balance = 100;

//  private synchronized void withdraw(int amount){
//      if(amount<=balance){
//          System.out.println(Thread.currentThread().getName()+ ", Processing for withdraw.");
//          balance -= amount;
//          try {
//              Thread.sleep(3000);
//          } catch (InterruptedException e) {
//              throw new RuntimeException(e);
//          }
//          System.out.println(Thread.currentThread().getName()+" Remaining amount: "+balance);
//      }else {
//          System.out.println(Thread.currentThread().getName()+" has insufficient balance.");
//      }
//  }
    private final Lock lock = new ReentrantLock();
    private void withdraw(int amount){

        try {
            if(lock.tryLock(4000, TimeUnit.MILLISECONDS)) {
                if (amount <= balance) {
                    System.out.println(Thread.currentThread().getName() + ", Processing for withdraw.");
                    balance -= amount;
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    } finally {
                        lock.unlock();
                    }
                    System.out.println(Thread.currentThread().getName() + " Remaining amount: " + balance);
                } else {
                    System.out.println(Thread.currentThread().getName() + " has insufficient balance.");
                }
            }else{
                System.out.println(Thread.currentThread().getName()+" unable to acquire lock, try again after some time.");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {
        BankAccount sbi = new BankAccount();
        Runnable task = new Runnable() {
            @Override
            public void run() {
                sbi.withdraw(50);
            }
        };
        Thread t1 = new Thread(task, "Thread 1");

        Thread t2 = new Thread(task, "Thread 2");
        t1.start();
        t2.start();
    }
}
