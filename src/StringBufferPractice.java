public class StringBufferPractice {
    public static void main(String[] args) {
        // Create a StringBuffer object
        StringBuffer sb = new StringBuffer("Hello");

        // Append text to the buffer
        sb.append(" World");
        System.out.println("After append: " + sb);

        // Insert text at a specific position
        sb.insert(6, "Beautiful ");
        System.out.println("After insert: " + sb);

        // Delete a portion of the buffer
        sb.delete(6, 16);
        System.out.println("After delete: " + sb);

        // Replace part of the buffer with new text
        sb.replace(6, 11, "Java");
        System.out.println("After replace: " + sb);

        // Reverse the buffer
        sb.reverse();
        System.out.println("After reverse: " + sb);

        // Convert StringBuffer to String
        String finalString = sb.toString();
        System.out.println("Final String: " + finalString);
    }
}

// Synchronized (Thread-Safe)
// In this example, StringBuffer ensures that the append operations from both threads are executed safely, one after the other, without corrupting the data.
class SynchronizedExample {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("Hello");

        // Thread 1
        Thread t1 = new Thread(() -> {
            sb.append(" World");
            System.out.println("Thread 1: " + sb);
        });

        // Thread 2
        Thread t2 = new Thread(() -> {
            sb.append(" Java");
            System.out.println("Thread 2: " + sb);
        });

        t1.start();
        t2.start();
    }
}

// Not Synchronized (Not Thread-Safe)
// In this example, since StringBuilder is not synchronized, simultaneous modifications by both threads could lead to data corruption or unexpected results.
class NotSynchronizedExample {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Hello");

        // Thread 1
        Thread t1 = new Thread(() -> {
            sb.append(" World");
            System.out.println("Thread 1: " + sb);
        });

        // Thread 2
        Thread t2 = new Thread(() -> {
            sb.append(" Java");
            System.out.println("Thread 2: " + sb);
        });

        t1.start();
        t2.start();
    }
}
