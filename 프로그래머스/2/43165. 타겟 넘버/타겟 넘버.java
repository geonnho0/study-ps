class Solution {
    private int target;
    private int answer;
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        this.target = target;
        dfs(numbers, 0, 0);
        return answer;
    }
    
    private void dfs(int[] numbers, int sum, int index) {
        if (index == numbers.length) {
            if (sum == target) answer++;
            return;
        }
        
        dfs(numbers, sum + numbers[index], index + 1);
        dfs(numbers, sum - numbers[index], index + 1);
    }
}