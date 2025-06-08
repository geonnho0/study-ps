import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);
        int[][] cities = new int[N][N];
        for (int i = 0; i < N; i++) {
            line = br.readLine().split(" ");
            for (int j = 0; j < N; j++)
                cities[i][j] = Integer.parseInt(line[j]);
        }
        System.out.println(solution(N, M, cities));
    }


    private static int answer = Integer.MAX_VALUE;
    private static List<int[]> houses;
    private static List<int[]> allChickenShops;

    private static int solution(int N, int M, int[][] cities) {
        houses = new ArrayList<>();
        allChickenShops = new ArrayList<>();
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++) {
                if (cities[i][j] == 1)
                    houses.add(new int[]{i, j});
                else if (cities[i][j] == 2)
                    allChickenShops.add(new int[]{i, j});
            }

        findChickenShops(-1, new ArrayList<>(), M);

        return answer;
    }

    private static void findChickenShops(int selectIndex, List<int[]> selectedChickenShops, int M) {
        if (selectedChickenShops.size() > M) return;
        answer = Math.min(answer, calculateChickenLength(selectedChickenShops));

        for (int i = selectIndex + 1; i < allChickenShops.size(); i++) {
            selectedChickenShops.add(allChickenShops.get(i));
            findChickenShops(i, selectedChickenShops, M);
            selectedChickenShops.remove(selectedChickenShops.size() - 1);
        }
    }

    private static int calculateChickenLength(List<int[]> chickenShops) {
        if (chickenShops.isEmpty()) return Integer.MAX_VALUE;

        int totalDistance = 0;
        for (int[] house : houses) {
            int minDistance = Integer.MAX_VALUE;
            for (int[] shop : chickenShops) {
                minDistance = Math.min(minDistance, distance(house, shop));
            }
            totalDistance += minDistance;
        }
        return totalDistance;
    }

    private static int distance(int[] a, int[] b) {
        return  Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}