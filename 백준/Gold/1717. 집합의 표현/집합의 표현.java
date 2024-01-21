import java.util.*;

public class Main {

    static int[] parent;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) parent[i] = i;
        while (m-- > 0) {
            int op = scanner.nextInt();
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            if (op == 0) union(a, b);
            else {
                int aRoot = find(a);
                int bRoot = find(b);
                if (aRoot == bRoot) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }

    private static int find(int a) {
        if (parent[a] == a) return a;
        parent[a] = find(parent[a]);
        return parent[a];
    }

    private static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        parent[bRoot] = aRoot;
    }

}