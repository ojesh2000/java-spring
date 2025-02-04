import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {//runAsync returns a
            //CompletableFuture<Void>
            System.out.println("Running asynchronously");
        });

        // Using supplyAsync (returns a result)
        //supplyAsync returns a CompletableFuture<T>
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            return 42;
        });

        // Wait for completion (to see the output)
        future1.join();//join method blocks the calling thread until the future completes
        System.out.println("Result: " + future2.join());
    }
}