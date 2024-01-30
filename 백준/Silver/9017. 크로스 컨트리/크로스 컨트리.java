import java.util.*;

public class Main {

    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        int test = scanner.nextInt();
        while (test-- > 0) {
            int N = scanner.nextInt();
            Team[] teams = new Team[N + 1];
            for (int i = 0; i <= N; i++) teams[i] = new Team(i);
            teams[0] = new Team(0);

            ArrayList<Integer> ranking = new ArrayList<>();
            for (int i = 1; i <= N; i++) {
                int team = scanner.nextInt();
                ranking.add(team);
                teams[team].addMember();
            }

            for (int i = 0; i < ranking.size();) {
                Integer team = ranking.get(i);
                if (!teams[team].isNotValid()) {
                    i++;
                    continue;
                }
                ranking.remove(team);
            }


            int size = ranking.size();
            for (int i = 0; i < size; i++) {
                int team = ranking.get(i);
                teams[team].addranking(i + 1);
            }

            Arrays.sort(teams);
            System.out.println(teams[N].id);
        }
    }

}

class Team implements Comparable<Team> {

    int id;
    ArrayList<Integer> ranking;
    int member;

    public Team(int id) {
        this.id = id;
        ranking = new ArrayList<>();
        member = 0;
    }

    public void addranking(int rank) {
        ranking.add(rank);
    }

    public void addMember() {
        member++;
    }

    public boolean isNotValid() {
        return member < 6;
    }

    public int getTop4() {
        Collections.sort(ranking, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        int ans = 0;
        for (int i = 0; i < 4; i++) ans += ranking.get(i);
        return ans;
    }

    public int get5th() {
        return ranking.get(4);
    }

    @Override
    public int compareTo(Team o) {
        if (isNotValid()) {
            if (o.isNotValid()) return 0;
            return -1;
        }
        if (o.isNotValid()) return 1;
        int top4_1 = getTop4(), top4_2 = o.getTop4();
        if (top4_1 > top4_2) return -1;
        else if (top4_1 < top4_2) return 1;
        int th5_1 = get5th(), th5_2 = o.get5th();
        if (th5_1 > th5_2) return -1;
        else if (th5_1 < th5_2) return 1;
        return 0;
    }
}