import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int score = scanner.nextInt();
        int P = scanner.nextInt();

        ArrayList<Node> ranking = new ArrayList<>();
        for (int i = 0; i < N; i++) ranking.add(new Node(false, scanner.nextInt()));
        ranking.add(new Node(true, score));

        Collections.sort(ranking, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.value - o1.value;
            }
        });

        int rank = 0, before = 0;
        int bound = Math.min(P, ranking.size());
        Node curr = null;
        for (int index = 0; index < bound; index++) {
            if (index >= 1) before = curr.value;
            curr = ranking.get(index);
            if (before != curr.value) rank = index;
            if (curr.isUser) {
                System.out.println(rank + 1);
                return;
            }

        }
        System.out.println(-1);
    }

}

class Node {
    boolean isUser;
    int value;

    public Node(boolean isUser, int value) {
        this.isUser = isUser;
        this.value = value;
    }
}