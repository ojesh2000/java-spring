//This total process is called defining a thread
public class MyThread extends Thread{

    @Override
    public void run(){
        //The code inside run method is called a job
        for(int i = 0;i < 10;++i){
            System.out.println("Child thread");
        }
    }
}
