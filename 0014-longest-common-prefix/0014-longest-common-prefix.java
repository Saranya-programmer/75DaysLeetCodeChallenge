class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder ans = new StringBuilder();

        for (int j = 0; j < strs[0].length(); j++) {
            char ch = strs[0].charAt(j);

            for (int i = 1; i < strs.length; i++) {
                if (j >= strs[i].length() || strs[i].charAt(j) != ch) {
                    return ans.toString();
                }
            }

            ans.append(ch);
        }

        return ans.toString();
    }
}


