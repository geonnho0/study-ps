import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int K = Integer.parseInt(line[1]);
        line = br.readLine().split(" ");
        List<Integer> tabs = new ArrayList<>();

        long count = 0;
        for (int i = 0; i < K; i++) {
            Integer curr = Integer.parseInt(line[i]);
            if (tabs.contains(curr)) {
                continue;
            }
            if (tabs.size() < N) {
                tabs.add(curr);
                continue;
            }

            int[] lastUse = new int[N];
            for (int k = 0; k < N; k++) {
                String tab = String.valueOf(tabs.get(k));
                lastUse[k] = -1;
                for (int j = i + 1; j < K; j++) {
                    if (line[j].equals(tab)) {
                        lastUse[k] = j;
                        break;
                    }
                }
            }

            int max = -1, index = -1;
            for (int k = 0; k < N; k++) {
                if (lastUse[k] == -1) {
                    index = k;
                    break;
                }
                if (max < lastUse[k]) {
                    max = lastUse[k];
                    index = k;
                }
            }

            tabs.remove(tabs.get(index));
            tabs.add(curr);
            count++;
        }
        System.out.print(count);
    }

}