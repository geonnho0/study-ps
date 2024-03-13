import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);
        line = br.readLine().split(" ");
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            deque.addLast(i);
        }
        int ans = 0;
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(line[i]);
            List<Integer> list = new ArrayList<>();
            int two = 0;
            while (deque.getFirst() != num) {
                list.add(0, deque.pollFirst());
                two++;
            }
            for (int l : list) {
                deque.offerFirst(l);
            }
            list = new ArrayList<>();
            int three = 0;
            while (deque.getLast() != num) {
                list.add(0, deque.pollLast());
                three++;
            }
            three++;
            for (int l : list) {
                deque.offerLast(l);
            }
            if (two > three) {
                while (deque.getLast() != num) {
                    deque.offerFirst(deque.pollLast());
                }
                deque.pollLast();
                ans += three;
            }
            else {
                while (deque.getFirst() != num) {
                    deque.offerLast(deque.pollFirst());
                }
                deque.pollFirst();
                ans += two;
            }
        }
        System.out.print(ans);
    }

}