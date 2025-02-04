import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws IOException {
        MyThread t = new MyThread();
        t.start();
//        t.start();uncomment this to get the IllegalThreadStateException
        System.out.println("Main method");
    }
}