//This total process is called defining a thread
public class MyThread extends Thread{

    @Override
    public void run(){
        System.out.println("No args run method");
    }


    public void run(int x){
        System.out.println("int based run method");
    }
}
