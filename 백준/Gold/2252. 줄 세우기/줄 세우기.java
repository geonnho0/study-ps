import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] arrayLists = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) arrayLists[i] = new ArrayList<>();

        int[] D = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            arrayLists[a].add(b);
            D[b]++;
        }

        ArrayList<Integer> answer = new ArrayList<>();
        int index = 1;
        boolean[] contain = new boolean[n + 1];
        while (answer.size() != n) {
            if (D[index] == 0 && !contain[index]) {
                answer.add(index);
                contain[index] = true;
                for (int linked: arrayLists[index]) D[linked]--;
            }
            index++;
            if (index > n) index = 1;
        }

        for (int ans: answer) System.out.print(ans + " ");
    }

}