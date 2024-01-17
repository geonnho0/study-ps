import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        Node[] nodes = new Node[N];
        for (int i = 0; i < N; i++)
            nodes[i] = new Node(i, Integer.parseInt(reader.readLine()));
        Arrays.sort(nodes);
        int max = 0;
        for (int i = 0; i < N; i++) {
            int change = nodes[i].index - i;
            if (max < change) max = change;
        }

        System.out.println(max + 1);
    }

    static class Node implements Comparable<Node> {
        int index;
        int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }
}