import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] heights = new int[9];
        for (int i = 0; i < 9; i++)
            heights[i] = scanner.nextInt();
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9 && i != j; j++) {
                ArrayList<Integer> ans = new ArrayList<>();
                for (int k = 0; k < 9; k++) {
                    if (k == i || k == j) continue;
                    ans.add(heights[k]);
                }
                int sum = 0;
                for (int height: ans)
                    sum += height;
                if (sum == 100) {
                    Collections.sort(ans);
                    for (int height: ans)
                        System.out.println(height);
                    return;
                }
            }
    }

}
