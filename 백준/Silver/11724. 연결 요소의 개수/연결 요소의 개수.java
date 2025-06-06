import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);
        parents = new int[N + 1];
        for (int i = 1; i <= N; i++)
            parents[i] = i;
        while (M-- > 0) {
            line = br.readLine().split(" ");
            int u = Integer.parseInt(line[0]);
            int v = Integer.parseInt(line[1]);
            union(u, v);
        }

        Set<Integer> set = new HashSet<>();
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            find(i);
            if (set.contains(parents[i]))
                continue;
            set.add(parents[i]);
            answer++;
        }
        System.out.println(answer);
    }

    static int find(int x) {
        if (parents[x] == x)
            return x;
        return parents[x] = find(parents[x]);
    }

    static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY)
            return;
        parents[rootY] = rootX;
    }

}