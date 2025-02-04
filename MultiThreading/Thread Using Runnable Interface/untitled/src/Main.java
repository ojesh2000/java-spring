import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        //Runnable object is used to define the run method that should be executed
        MyRunnable runnable = new MyRunnable();//No start method is present in a Runnable
        Thread t = new Thread(runnable);
        t.start();
//        t.run();//MyRunnable run method will be executed. Main thread will be responsible for the execution of run method code
//        runnable.run();//MyRunnable run method will be executed. Main thread will be responsible for the execution of run method code

        for(int i = 0;i < 10;++i){
            System.out.println("Main Thread");
        }
    }
}