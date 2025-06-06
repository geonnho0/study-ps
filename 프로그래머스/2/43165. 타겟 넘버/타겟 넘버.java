class Solution {
    int answer = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(numbers[0], 0, numbers, target);
        dfs(0 - numbers[0], 0, numbers, target);
        return answer;
    }
    
    void dfs(int value, int currIndex, int[] numbers, int target) {
        if (currIndex == numbers.length - 1) {
            if (value == target)
                answer++;
        }
        int nextIndex = currIndex + 1;
        if (!validate(value, nextIndex, numbers, target))
            return;
        
        dfs(value + numbers[nextIndex], nextIndex, numbers, target);
        dfs(value - numbers[nextIndex], nextIndex, numbers, target);
    }
    
    
    boolean validate(int value, int nextIndex, int[] numbers, int target) {
        if (nextIndex >= numbers.length)
            return false;
        
        int sum = 0;
        for (; nextIndex < numbers.length; nextIndex++)
            sum += numbers[nextIndex];
        
        if (value + sum < target)
            return false;
        if (value - sum > target)
            return false;
        return true;
    }
}