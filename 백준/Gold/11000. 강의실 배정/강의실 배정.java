import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] time = new int[N][2];
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            time[i][0] = Integer.parseInt(line[0]);
            time[i][1] = Integer.parseInt(line[1]);
        }
        Arrays.sort(time, ((o1, o2) -> {
            if (o1[0] == o2[0])
                return o1[1] - o2[1];
            return o1[0] - o2[0];
        }));
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            queue.offer(time[i][1]);
            if (queue.peek() <= time[i][0])
                queue.poll();
        }
        System.out.print(queue.size());
    }

}