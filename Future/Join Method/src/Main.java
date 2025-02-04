import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        CompletableFuture<Integer> c = CompletableFuture.supplyAsync(() -> {
            try{
                Thread.sleep(2000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            return 42;
        });
        //we get the result of the future by calling the join method
        System.out.println("Hello " + c.join());


    }
}