import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++)
            queue.offer(i);

        while (queue.size() != 1) {
            queue.poll();
            int front = queue.peek();
            queue.poll();
            queue.offer(front);
        }

        System.out.println(queue.peek());
    }
}