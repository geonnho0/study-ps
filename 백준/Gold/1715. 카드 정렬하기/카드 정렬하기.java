import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) queue.add(scanner.nextInt());
        int count = 0;
        while (queue.size() != 1) {
            int temp1 = queue.poll();
            int temp2 = queue.poll();
            count += temp1 + temp2;
            queue.add(temp1 + temp2);
        }
        System.out.println(count);
    }

}