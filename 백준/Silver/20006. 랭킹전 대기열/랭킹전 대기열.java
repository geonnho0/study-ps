import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int players = Integer.parseInt(st.nextToken());
        int roomSize = Integer.parseInt(st.nextToken());

        int id = 0;
        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(new Room(id++));
        for (int i = 0; i < players; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int level = Integer.parseInt(st.nextToken());
            String nick = st.nextToken();
            Player player = new Player(level, nick);
            int count = rooms.size();
            for (int j = 0; ; j++) {
                if (j == count) {
                    Room room = new Room(id++);
                    room.addPlayer(player, roomSize);
                    rooms.add(room);
                    break;
                }
                if (rooms.get(j).addPlayer(player, roomSize)) break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Room r: rooms)
            r.printInfo(sb, roomSize);
        System.out.print(sb);
    }

}

class Player implements Comparable<Player> {
    int level;
    String nickname;

    public Player(int level, String nickname) {
        this.level = level;
        this.nickname = nickname;
    }

    @Override
    public int compareTo(Player p) {
        return nickname.compareTo(p.nickname);
    }
}

class Room {
    int id;
    ArrayList<Player> players;
    int[] range;

    public Room(int id) {
        this.id = id;
        players = new ArrayList<>();
        range = new int[2];
    }

    public boolean isFull(int max) {
        return players.size() == max;
    }

    public boolean addPlayer(Player player, int max) {
        if (players.size() == 0) {
            range[0] = (player.level - 10);
            range[1] = (player.level + 10);
            players.add(player);
            return true;
        }
        if (isFull(max)) return false;
        if (range[0] > player.level || range[1] < player.level) return false;
        players.add(player);
        return true;
    }

    public void printInfo(StringBuilder sb, int max) {
        if (isFull(max)) sb.append("Started!\n");
        else sb.append("Waiting!\n");
        Collections.sort(players);
        for (Player p: players)
            sb.append(p.level + " " + p.nickname + "\n");
    }
}
