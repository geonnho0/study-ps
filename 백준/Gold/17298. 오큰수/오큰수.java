import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuffer buffer = new StringBuffer();
        Stack<Integer> stack = new Stack<>();
        int N = scanner.nextInt();
        int[] A = new int[N];

        for (int i = 0; i < N; i++)
            A[i] = scanner.nextInt();
        stack.push(0);

        int[] NGE = new int[N];
        for (int i = 1; i < N; i++) {
            int top = stack.peek();
            if (A[top] >= A[i]) stack.push(i);
            else {
                while (A[top] < A[i] && !stack.empty()) {
                    NGE[top] = A[i];
                    stack.pop();
                    if (!stack.empty()) top = stack.peek();
                }
                stack.push(i);
            }
        }

        while (!stack.empty()) {
            int top = stack.peek();
            NGE[top] = -1;
            stack.pop();
        }

        for (int i = 0; i < N; i++)
            buffer.append(NGE[i] + " ");

        System.out.println(buffer);
    }
}