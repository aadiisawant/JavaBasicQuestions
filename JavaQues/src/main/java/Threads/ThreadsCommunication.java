package Threads;

class SharedResource{
    public int data;
    public boolean hasData;

    public synchronized void produce(int value){
        while(hasData){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        data = value;
        hasData = true;
        System.out.println("produced : "+value);
        notify();
    }

    public synchronized void consume(){
        while(!hasData){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        hasData =false;
        System.out.println("consumed : "+data);
        notify();
//        return data;
    }
}

class Producer implements Runnable{

    private SharedResource sharedResource;
    Producer(SharedResource sharedResource){
        this.sharedResource = sharedResource;
    }
    @Override
    public void run() {
        for(int i=0;i<10;i++){
            sharedResource.produce(i);
        }
    }
}

class Consumer implements Runnable{

    private SharedResource sharedResource;
    Consumer(SharedResource sharedResource){
        this.sharedResource = sharedResource;
    }
    @Override
    public void run() {
        for(int i=0;i<10;i++){
            sharedResource.consume();
        }
    }
}
public class ThreadsCommunication {

    public static void main(String[] args) {

        SharedResource sharedResource = new SharedResource();
        Runnable produce = () ->{
            for(int i=0;i<10;i++){
                sharedResource.produce(i);
            }
        };
        Runnable consume = () ->{
            for(int i=0;i<10;i++){
                sharedResource.consume();
            }
        };
//        Thread t1 = new Thread(new Producer(sharedResource), "t1");
        Thread t1 = new Thread(produce, "t1"); //lambda expression
        Thread t2 = new Thread(consume, "t2");
//        Thread t2 = new Thread(new Consumer(sharedResource), "t2");
        t1.start();
        t2.start();
    }
}