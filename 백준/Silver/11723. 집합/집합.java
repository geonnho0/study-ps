import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        while (M-- > 0) {
            String[] commands = br.readLine().split(" ");
            if (commands[0].equals("add")) set.add(Integer.parseInt(commands[1]));
            else if (commands[0].equals("remove")) set.remove(Integer.parseInt(commands[1]));
            else if (commands[0].equals("check")) {
                boolean check = set.contains(Integer.parseInt(commands[1]));
                sb.append(check ? 1 : 0).append("\n");
            }
            else if (commands[0].equals("toggle")) {
                int num = Integer.parseInt(commands[1]);
                if (set.contains(num)) set.remove(num);
                else set.add(num);
            }
            else if (commands[0].equals("all")) {
                set.clear();
                for (int i = 1; i <= 20; i++) set.add(i);
            }
            else set.clear();
        }
        System.out.println(sb);
    }
}