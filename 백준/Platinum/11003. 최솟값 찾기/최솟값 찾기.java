import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int L = Integer.parseInt(stringTokenizer.nextToken());
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        Deque<Node> deque = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            int newElement = Integer.parseInt(stringTokenizer.nextToken());

            while (!deque.isEmpty() && deque.getLast().value > newElement)
                deque.removeLast();

            deque.addLast(new Node(i, newElement));

            if (deque.getFirst().index <= i - L)
                deque.removeFirst();

            bufferedWriter.write(deque.getFirst().value + " ");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    static class Node {
        public final int index;
        public final int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}