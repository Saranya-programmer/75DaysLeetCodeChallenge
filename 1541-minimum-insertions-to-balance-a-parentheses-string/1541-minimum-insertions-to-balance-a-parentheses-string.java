class Solution {
    public int minInsertions(String s) {
        int need = 0;
        int cnt = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (need % 2 == 1) {
                    cnt++;
                    need--;
                }
                need += 2;
            } else {
                need--;

                if (need < 0) {
                    cnt++;
                    need = 1;
                }
            }
        }

        return cnt + need;
    }
}