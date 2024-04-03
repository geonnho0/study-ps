class Solution {
    public int solution(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++)
            max = max < arr[i] ? arr[i] : max;
        while (true) {
            boolean flag = true;
            for (int num : arr) {
                if (max % num != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                break;
            max++;
        }
        return max;
    }
}