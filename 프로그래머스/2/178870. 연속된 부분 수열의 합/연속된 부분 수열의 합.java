class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int length = sequence.length;
        int sum = sequence[0], left = 0, right = 0;
        int maxIndexLen = 1000005;
        while (true) {
            if (sum == k) {
                if (maxIndexLen > right - left) {
                    answer[0] = left;
                    answer[1] = right;
                    maxIndexLen = right - left;
                }
                else if (maxIndexLen == right - left) {
                    if (answer[0] > left) {
                        answer[0] = left;
                        answer[1] = right;
                    }
                }
                sum -= sequence[left++];
            }
            else if (sum > k) {
                if (left < length) {
                    sum -= sequence[left++];
                    continue;
                }
                break;
            }
            else {
                if (right < length - 1) {
                    sum += sequence[++right];
                    continue;
                }
                break;
            }
        }
        return answer;
    }
}