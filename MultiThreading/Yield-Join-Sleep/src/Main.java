public class Main {
    public static void main(String[] args) {
//        Thread t = new Thread(new YieldRunnable());
//        t.start();
//        for(int i = 0;i < 10;++i){
//            System.out.println("Main Thread");
//        }

//        System.out.println(System.getProperty("log.path"));

        String a = "abc";
        StringBuilder sb = new StringBuilder(a);
        System.out.println(sb.reverse().toString());

    }
}

class YieldRunnable implements Runnable {
    @Override
    public void run() {
        for(int i = 0;i < 10;++i){
            System.out.println("Child Thread");
            Thread.yield();
//            If we comment the above line, both the thread will execute simultaneously
//            and we can't expect which thread will complete first.
//            If this line is present, then childThread will call yield method, because of that
//            Main thread will get chance, more no. of times,
//            and the chance of completing main thread is more.
        }
    }
}