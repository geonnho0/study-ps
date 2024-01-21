import java.util.*;

public class Main {

    static int[] parent;
    static ArrayList<Integer>[] party;
    static int[] truthMember;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int count = scanner.nextInt();
        truthMember = new int[count];
        for (int i = 0; i < count; i++) truthMember[i] = scanner.nextInt();
        party = new ArrayList[m];
        for (int i = 0; i < m; i++) {
            party[i] = new ArrayList<>();
            int partySize = scanner.nextInt();
            for (int j = 0; j < partySize; j++)
                party[i].add(scanner.nextInt());   
        }

        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) parent[i] = i;
        
        for (int i = 0; i < m; i++) {
            int first = party[i].get(0);
            for (int member: party[i])
                union(first, member);
        }
        
        int res = 0;
        for (int i = 0; i < m; i++) {
            boolean possible = true;
            int curr = party[i].get(0);
            for (int j = 0; j < truthMember.length; j++) {
                if (find(curr) == find(truthMember[j])) {
                    possible = false;
                    break;
                }
            }
            if (possible) res++;
        }
        System.out.println(res);
    }

    private static int find(int member) {
        if (parent[member] == member) return member;
        parent[member] = find(parent[member]);
        return parent[member];
    }

    private static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        parent[bRoot] = aRoot;
    }

}