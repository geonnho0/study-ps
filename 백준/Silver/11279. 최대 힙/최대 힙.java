import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(bufferedReader.readLine());
            if (x == 0) {
                if (queue.isEmpty()) {
                    stringBuilder.append("0\n");
                } else {
                    int max = queue.poll();
                    stringBuilder.append(max).append("\n");
                }
            } else {
                queue.offer(x);
            }
        }
        System.out.println(stringBuilder);
    }
}
