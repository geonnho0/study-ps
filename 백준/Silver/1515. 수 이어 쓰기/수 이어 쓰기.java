import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = br.readLine().split("");
        int length = numbers.length;
        int ans = 1;
        int index = 0;
        for (int i = 0; i < length; i++) {
            String curr = numbers[i];
            while (true) {
                String number = String.valueOf(ans);
                int len = number.length();
                for (; index < len; index++) {
                    if (number.charAt(index) == curr.charAt(0))
                        break;
                }
                if (index == len) {
                    ans++;
                    index = 0;
                }
                else {
                    index++;
                    break;
                }
            }
        }

        System.out.println(ans);
    }

}