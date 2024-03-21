import java.util.*;

class Solution {
    
    int[][] users;
    int[] emoticons;
    int[] discount;
    int uCount, eCount;
    int[] answer = {0, 0};
    
    public int[] solution(int[][] users, int[] emoticons) {
        init(users, emoticons);
        dfs(0);
        return answer;
    }
    
    void init(int[][] users, int[] emoticons) {
        this.users = users;
        this.emoticons = emoticons;
        uCount = users.length;
        eCount = emoticons.length;
        discount = new int[eCount];
    }
    
    void dfs(int index) {
        if (index == eCount) {
            int plusCount = 0, totalBuy = 0;
            for (int i = 0; i < uCount; i++) {
                int b = buy(i);
                if (plus(i, b))
                    plusCount++;
                else
                    totalBuy += b;
            }
            if (answer[0] < plusCount) {
                answer[0] = plusCount;
                answer[1] = totalBuy;
            }
            else if (answer[0] == plusCount) {
                answer[1] = Math.max(answer[1], totalBuy);
            }
            return;
        }
        
        for (int i = 10; i <= 40; i += 10) {
            discount[index] = i;
            dfs(index + 1);
        }
    }
    
    boolean plus(int user, int sum) {
        return sum >= users[user][1];
    }
    
    int buy(int user) {
        int sum = 0;
        for (int i = 0; i < eCount; i++)
            if (discount[i] >= users[user][0])
                sum += (emoticons[i] * (100 - discount[i])) / 100;
        return sum;
    }
}