import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            if (line.equals("end")) return;
            String[] games = line.split("");

            boolean isXWin = check(games, "X");
            int playerX = countPlayers(games, "X");
            boolean isOWin = check(games, "O");
            int playerY = countPlayers(games, "O");

            if (isXWin && !isOWin & playerX == playerY + 1)
                System.out.println("valid");
            else if (!isXWin && isOWin && playerX == playerY)
                System.out.println("valid");
            else if (!isXWin && !isOWin && playerX == 5 && playerY == 4)
                System.out.println("valid");
            else
                System.out.println("invalid");
        }
    }

    private static boolean check(String[] games, String player) {
        for (int i = 0; i < 7; i += 3) {
            String start = games[i];
            if (start.equals(player) && games[i + 1].equals(start) && games[i + 2].equals(start))
                return true;
        }
        for (int i = 0; i < 3; i++) {
            String start = games[i];
            if (start.equals(player) && games[i + 3].equals(start) && games[i + 6].equals(start))
                return true;
        }

        String start = games[0];
        if (start.equals(player) && games[4].equals(start) && games[8].equals(start))
            return true;
        start = games[2];
        if (start.equals(player) && games[4].equals(start) && games[6].equals(start))
            return true;
        return false;
    }

    private static int countPlayers(String[] games, String player) {
        int ans = 0;
        for (int i = 0; i < 9; i++) {
            if (games[i].equals(player)) ans++;
        }
        return ans;
    }

}