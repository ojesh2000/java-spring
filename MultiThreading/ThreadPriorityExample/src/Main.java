public class Main {
//    Even if the priority of t is greater than main thread we will not notice a sequential execution
//    Some operating systems don't provide support for thread Priorities. Thus, we don't see a sequential execution
    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.setPriority(10);// If we comment this line, both will have same priority and we can't expect order of execution
        t.start();
        for(int i = 0 ;i < 10;++i){
            System.out.println("Main Thread");
        }
    }
}

class MyThread extends Thread{
    @Override
    public void run(){
        for(int i = 0;i < 10;++i){
            System.out.println("Child Thread");
        }
    }

}