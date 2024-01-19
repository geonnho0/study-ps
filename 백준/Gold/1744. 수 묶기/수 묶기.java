import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        PriorityQueue<Integer> plus = new PriorityQueue<>();
        PriorityQueue<Integer> minus = new PriorityQueue<>();
        int zeroCount = 0;
        for (int i = 0; i < N; i++) {
            int num = scanner.nextInt();
            if (num == 0) zeroCount++;
            else if (num > 0) plus.add(-num);
            else minus.add(num);
        }

        int res = 0;
        while (minus.size() >= 2) {
            int temp1 = minus.poll();
            int temp2 = minus.poll();
            res += temp1 * temp2;
        }
        while (plus.size() >= 2) {
            int temp1 = plus.poll();
            int temp2 = plus.poll();
            if (temp1 * temp2 > -(temp1 + temp2)) res += temp1 * temp2;
            else res -= temp1 + temp2;
        }

        if (zeroCount == 0) {
            if (!minus.isEmpty()) res += minus.peek();
            if (!plus.isEmpty()) res -= plus.peek();
        } else {
            if (!plus.isEmpty()) res -= plus.peek();
        }

        System.out.println(res);
    }

}