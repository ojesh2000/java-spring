public class Main {
    //in main method, there is only one Main Thread
    //i.e every java program has only one main thread
    //internally multiple daemon threads are present which will be discussed later
    public static void main(String[] args) {
        //Main thread creates child thread
        MyThread t = new MyThread();//Thread instantiation. This line executed by main thread

        //Main thread starts child thread
        t.start();
        //start is Thread class's method. It internally calls our run method
        //what happens when we directly call run method to start a thread ?
        //What is the difference between t.start() & t.run()
        //try replacing
//        t.run();

        //at this point 2 threads are present


        //Code executed by main thread
        for(int i = 0;i < 10;++i){
            System.out.println("Main Thread");
        }
        //run this program multiple times
        //you will notice a random printing order that changes each time
        //This is because Main thread is printing "Main Thread" and Child Thread is printing "Child Thread"
        //Simultaneously.

    }
}