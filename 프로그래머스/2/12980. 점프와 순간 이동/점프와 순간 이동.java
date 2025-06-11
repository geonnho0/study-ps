public class Solution {
    public int solution(int n) {
        int ans = 1;

        while (n != 1) {
            int left = n % 2;
            ans += left;
            n /= 2;
        }

        return ans;
    }
}
