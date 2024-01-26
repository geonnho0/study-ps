import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] statements = scanner.nextLine().split("-");

        int[] nums = new int[statements.length];
        for (int i = 0; i < statements.length; i++) {
            String[] numbers = statements[i].split("\\+");
            for (int j = 0; j < numbers.length; j++) {
                int num = Integer.parseInt(numbers[j]);
                nums[i] += num;
            }
        }

        int res = nums[0];
        for (int i = 1; i < nums.length; i++)
            res -= nums[i];

        System.out.println(res);
    }

}