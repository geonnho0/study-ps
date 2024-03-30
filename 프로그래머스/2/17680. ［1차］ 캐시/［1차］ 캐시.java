import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0)
            return cities.length * 5;
        int answer = 0;
        List<String> cache = new ArrayList<>();
        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toLowerCase();
            if (cache.remove(city)) {
                answer++;
                cache.add(city);
                continue;
            }
            if (cache.size() >= cacheSize) {
                cache.remove(0);
            }
            cache.add(city);
            answer += 5;
        }
        return answer;
    }
}