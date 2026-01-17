package Threads;

class Pen{
    public synchronized void WriteWithPenAndPaper(Paper paper){
        System.out.println(Thread.currentThread().getName()+" is using pen and waiting for paper...");
        paper.finishWriting();
    }
    public synchronized void finishWriting(){
        System.out.println(Thread.currentThread().getName()+" finished using pen");
    }
}

class Paper{

    public synchronized void WriteWithPaperAndPen(Pen pen){
        System.out.println(Thread.currentThread().getName()+" is using paper and waiting for pen...");
        pen.finishWriting();
    }
    public synchronized void finishWriting(){
        System.out.println(Thread.currentThread().getName()+" finished using Paper");
    }
}

class TaskOne implements Runnable{

    private Pen pen;
    private Paper paper;

    public TaskOne(Pen pen, Paper paper){
        this.paper=paper;
        this.pen = pen;
    }
    @Override
    public void run() {
        pen.WriteWithPenAndPaper(paper);
    }
}
class TaskTwo implements Runnable{

    private Pen pen;
    private Paper paper;

    public TaskTwo(Pen pen, Paper paper){
        this.paper=paper;
        this.pen = pen;
    }
    @Override
    public void run() {
        synchronized (pen) {
            paper.WriteWithPaperAndPen(pen);
        }
    }
}
public class DeadLockCheck {

    public static void main(String[] args) {
        Paper paper = new Paper();
        Pen pen = new Pen();

        Thread t1 = new Thread(new TaskOne(pen, paper), "Pen-Thread");
        Thread t2 = new Thread(new TaskTwo(pen, paper), "Paper-Thread");
        t2.start();
        t1.start();

//        try {
//            t1.join();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

    }


}
