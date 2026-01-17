package Threads;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Pens {
    private final Lock lock = new ReentrantLock();

    public boolean writeWithPenAndPaper(Papers paper) {
        try {
            if (lock.tryLock(1, TimeUnit.SECONDS)) {
                try {
                    System.out.println(Thread.currentThread().getName()
                            + " acquired PEN, trying for PAPER");
                    return paper.finishWriting();
                } finally {
                    lock.unlock();
                    System.out.println(Thread.currentThread().getName()
                            + " released PEN");
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return false;
    }

    public boolean finishWriting() {
        try {
            if (lock.tryLock(1, TimeUnit.SECONDS)) {
                try {
                    System.out.println(Thread.currentThread().getName()
                            + " finished using PEN");
                    return true;
                } finally {
                    lock.unlock();
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return false;
    }
}

class Papers{
    private final Lock lock = new ReentrantLock();

    public boolean writeWithPenAndPaper(Pens pen) {
        try {
            if (lock.tryLock(1, TimeUnit.SECONDS)) {
                try {
                    System.out.println(Thread.currentThread().getName()
                            + " acquired PEN, trying for PAPER");
                    return pen.finishWriting();
                } finally {
                    lock.unlock();
                    System.out.println(Thread.currentThread().getName()
                            + " released PEN");
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return false;
    }

    public boolean finishWriting() {
        try {
            if (lock.tryLock(1, TimeUnit.SECONDS)) {
                try {
                    System.out.println(Thread.currentThread().getName()
                            + " finished using PEN");
                    return true;
                } finally {
                    lock.unlock();
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return false;
    }
}
class Task1 implements Runnable {
    private final Pens pen;
    private final Papers paper;

    Task1(Pens pen, Papers paper) {
        this.pen = pen;
        this.paper = paper;
    }

    @Override
    public void run() {
        pen.writeWithPenAndPaper(paper);
    }
}

class Task2 implements Runnable {
    private final Pens pen;
    private final Papers paper;

    Task2(Pens pen, Papers paper) {
        this.pen = pen;
        this.paper = paper;
    }

    @Override
    public void run() {
        paper.writeWithPenAndPaper(pen);
    }
}

public class DeadLockWithReentrant {
    public static void main(String[] args) {
        Pens pen = new Pens();
        Papers paper = new Papers();

        Thread t1 = new Thread(new Task1(pen, paper), "Pen-Thread");
        Thread t2 = new Thread(new Task2(pen, paper), "Paper-Thread");

        t1.start();
        t2.start();
    }
}

