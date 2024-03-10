import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        Arrays.sort(book_time, (o1, o2) -> o1[0].compareTo(o2[0]));
        List<Time> rooms = new ArrayList<>();
        for (String[] bTime : book_time) {
            int[] times = getTimes(bTime);
            
            int number = 0;
            boolean available = false;
            for (number = 0; number < rooms.size(); number++) {
                Time room = rooms.get(number);
                if (room.available(times[0])) {
                    available = true;
                    break;
                }
            }
            
            if (available) {
                rooms.remove(number);
                rooms.add(number, new Time(times));
            }
            else {
                rooms.add(new Time(times));
                answer++;
            }
        }
        return answer;
    }
    
    int[] getTimes(String[] time) {
        String start = time[0];
        int h = Integer.parseInt(start.split(":")[0]);
        int m = Integer.parseInt(start.split(":")[1]);
        int startTime = h * 60 + m;
        String end = time[1];
        h = Integer.parseInt(end.split(":")[0]);
        m = Integer.parseInt(end.split(":")[1]);
        int endTime = h * 60 + m;
        return new int[]{startTime, endTime};
    }
}

class Time {
    int start, end;
    
    public Time(int[] times) {
        this.start = times[0];
        this.end = times[1];
    }
    
    boolean available(int currTime) {
        return end + 10 <= currTime;
    }
}