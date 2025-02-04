public class Main {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getPriority());
//        Thread.currentThread().setPriority(15);//gives runtime exception
        Thread.currentThread().setPriority(8);
        MyThread t = new MyThread();
        //for t parent class is Thread, but parent Thread is main Thread
        System.out.println(t.getPriority());//prints 7 as by default, child inherits parent's priority
    }
}

class MyThread extends Thread{
    @Override
    public void run(){
        System.out.println("Child Thread");
    }

}