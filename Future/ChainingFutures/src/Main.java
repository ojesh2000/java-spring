import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
//        CompletableFuture<Integer> x = CompletableFuture.supplyAsync(() -> {return 42;});
//
//        CompletableFuture<Integer> y = x.thenApply(r -> r * 2);
//
//        CompletableFuture<String> z = y.thenApply((result) -> {return "Result is: " + result;});
//
//        z.thenAccept((t) -> {System.out.println(t);});//takes in a Consumer that accepts a single argument and returns no result
//        //it is used to log or perform a void operation on the result of future

        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> 10);
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> 20);

        CompletableFuture<Integer> combinedFuture = future1.thenCombine(
                future2,
                (result1, result2) -> result1 + result2 // Combines the two results
        );

        combinedFuture.thenAccept(result -> System.out.println("Combined Result: " + result));
        combinedFuture.join();
    }
}