import java.util.*;

public class Main {

    static int[] parent;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int m = Integer.parseInt(scanner.nextLine());

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) parent[i] = i;
        for (int i = 0; i < n; i++) {
            String[] strings = scanner.nextLine().split(" ");
            for (int j = 0; j < strings.length; j++)
                if (strings[j].equals("1")) union(i + 1, j + 1);
        }

        boolean yes = true;
        int city = scanner.nextInt();
        int root = find(city);
        while (--m > 0) {
            city = scanner.nextInt();
            if (root != find(city)) yes = false;
        }

        if (yes) System.out.println("YES");
        else System.out.println("NO");
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