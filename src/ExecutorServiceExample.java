import java.util.concurrent.*;

public class ExecutorServiceExample {

    public static void main(String[] args) {
        // Create an ExecutorService with a fixed thread pool of 2 threads
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // Create a Runnable task
        Runnable task1 = () -> {
            System.out.println("Executing Task1 inside : " + Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        // Create another Runnable task
        Runnable task2 = () -> {
            System.out.println("Executing Task2 inside : " + Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        // Submit tasks to the executor service
        executorService.submit(task1);
        executorService.submit(task2);

        // Initiate a graceful shutdown
        executorService.shutdown();

        try {
            // Wait for all tasks to complete before exiting
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }

        System.out.println("ExecutorService has been shut down.");
    }
}
