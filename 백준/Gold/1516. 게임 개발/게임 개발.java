import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer>[] arrayLists = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) arrayLists[i] = new ArrayList<>();
        int[] costs = new int[n + 1];
        int[] D = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int cost = scanner.nextInt();
            costs[i] = cost;
            int building = scanner.nextInt();
            while (building != -1) {
                arrayLists[building].add(i);
                D[i]++;
                building = scanner.nextInt();
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++)
            if (D[i] == 0)
                queue.offer(i);

        int[] ans = new int[n + 1];
        for (int i = 1; i <= n; i++) ans[i] = costs[i];
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int next: arrayLists[curr]) {
                ans[next] = Math.max(ans[next], ans[curr] + costs[next]);
                D[next]--;
                if (D[next] == 0) queue.offer(next);
            }
        }

        for (int i = 1; i <= n; i++)
            System.out.println(ans[i]);
    }

}