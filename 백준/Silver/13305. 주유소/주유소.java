import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] roads = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            roads[i] = sc.nextInt();
        }
        int[] oils = new int[n];
        for (int i = 0; i < n; i++) {
            oils[i] = sc.nextInt();
        }

        int first = 0;
        int second = 1;
        int total = 0;
        while (true) {
            if (oils[first] < oils[second]) {
                second++;
                continue;
            }
            if (second == n - 1) {
                int meter = 0;
                for (int i = first; i < second; i++) {
                    meter += roads[i];
                }
                total += meter * oils[first];
                break;
            }
            if (oils[first] >= oils[second]) {
                int meter = 0;
                for (int i = first; i < second; i++) {
                    meter += roads[i];
                }
                total += meter * oils[first];
                first = second;
                second++;
            }
        }

        System.out.println(total);
    }

}