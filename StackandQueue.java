import java.util.Scanner;
import java.util.Stack;

public class QueueWithTwoStacks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt(); // Number of queries
        Stack<Integer> lifo = new Stack<>(); // Stack for enqueuing
        Stack<Integer> fifo = new Stack<>(); // Stack for dequeuing

        for (int i = 0; i < q; i++) {
            int queryType = scanner.nextInt(); // Read the query type
            if (queryType == 1) {
                int x = scanner.nextInt(); // Read the value to be enqueued
                lifo.push(x); // Enqueue the value into the LIFO stack
            } else if (queryType == 2) {
                if (fifo.isEmpty()) {
                    // If FIFO stack is empty, transfer elements from LIFO to FIFO
                    while (!lifo.isEmpty()) {
                        fifo.push(lifo.pop());
                    }
                }
                if (!fifo.isEmpty()) {
                    fifo.pop(); // Dequeue an element from the FIFO stack
                }
            } else if (queryType == 3) {
                if (fifo.isEmpty()) {
                    // If FIFO stack is empty, transfer elements from LIFO to FIFO
                    while (!lifo.isEmpty()) {
                        fifo.push(lifo.pop());
                    }
                }
                if (!fifo.isEmpty()) {
                    System.out.println(fifo.peek()); // Print the front element of the FIFO stack
                }
            }
        }

        scanner.close();
    }
}
