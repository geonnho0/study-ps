class Solution {
    boolean solution(String s) {
        char[] arr = s.toCharArray();
        int[] count = new int[2];
        for (char a : arr) {
            if (a == 'p' || a == 'P')
                count[0]++;
            if (a == 'y' || a == 'Y')
                count[1]++;
        }

        return count[0] == count[1];
    }
}