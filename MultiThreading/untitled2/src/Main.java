public class Main {
    public static void main(String[] args) throws InterruptedException {
//        Thread childThread = new Thread(new MyRunner());
//
//        childThread.start();
//
//        childThread.join(1000);
//        // Main thread will wait until the execution of Child Thread for 10 seconds
//
//        for(int i = 0;i < 10;++i){
//            System.out.println("Main Thread");
//        }



        //Waiting of child thread until main is completed
        OtherRunner otherRunner = new OtherRunner();
        OtherRunner.setMainThread(Thread.currentThread());
        Thread childThread = new Thread(otherRunner);
        childThread.start();

        for(int i = 0;i < 10;++i){
            System.out.println("Main Thread");
        }

        /**
         * In the above example, child thread calls join method on main thread.
         * Hence,child thread has to wait until main thread completes
         */

    }
}


/**
 * If main thread joins for childThread
 * and childThread joins for mainThread
 * A deadlock occurs
 * the application will run but will never produce an output
 * If a Thread calls join method on the same Thread itself, then programme will be stuck forever
 * (This is something like a deadlock)
 */


class OtherRunner implements Runnable{
    private static Thread mainThread;
    //created a static variable for this,
    //so that all instances of OtherRunner only wait for the Main Thread
    //i.e the mainThread variable is assigned only once


    public static void setMainThread(Thread mainThread1){
        mainThread = mainThread1;
    }

    @Override
    public void run() {
        try {
            mainThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for(int i = 0;i < 10;++i){
            System.out.println("Child Thread");
        }

    }
}

class MyRunner implements Runnable{
    @Override
    public void run() {
        for(int i = 0;i < 10;++i){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Child Thread");
        }
    }
}