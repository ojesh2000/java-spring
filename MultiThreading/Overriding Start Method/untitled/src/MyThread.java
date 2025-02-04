//This total process is called defining a thread
public class MyThread extends Thread{

    @Override
    public void run(){
        System.out.println("run method");
    }

//    @Override
//    public void start(){
//        super.start();
//        System.out.println("start method");
//    }

    @Override
    public void start(){
        super.start();//since this calls start Method of Thread Class, run method is executed by the child threa
        // Both the main and child thread executes simultaneously.
        System.out.println("start method");
    }
}
