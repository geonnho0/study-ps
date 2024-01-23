import java.util.*;

public class Main {

    static ArrayList<Edge> edges;
    static int[] parent;
    static int V, E;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        V = scanner.nextInt();
        E = scanner.nextInt();
        parent = new int[V + 1];
        edges = new ArrayList<>();
        for (int i = 0; i <= V; i++) parent[i] = i;

        for (int i = 0; i < E; i++) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            int C = scanner.nextInt();
            edges.add(new Edge(A, B, C));
        }

        Collections.sort(edges);

        ArrayList<Edge> ans = new ArrayList<>();
        while (ans.size() != V - 1) {
            for (Edge edge: edges) {
                if (find(parent[edge.start]) == find(parent[edge.end])) continue;
                union(edge.start, edge.end);
                ans.add(edge);
            }
        }
        int res = 0;
        for (Edge edge: ans) res += edge.weight;
        System.out.println(res);
    }

    private static int find(int node) {
        if (node == parent[node]) return node;
        return parent[node] = find(parent[node]);
    }

    private static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot != bRoot) parent[bRoot] = aRoot;
    }

}

class Edge implements Comparable<Edge> {
    int start;
    int end;
    int weight;

    public Edge(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }
}