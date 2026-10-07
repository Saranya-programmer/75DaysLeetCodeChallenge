class Solution {
    public List<String> removeInvalidParentheses(String s) {
        Set<String> set = new HashSet<>();

        int leftRemove = 0;
        int rightRemove = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                leftRemove++;
            } else if (c == ')') {
                if (leftRemove > 0) {
                    leftRemove--;
                } else {
                    rightRemove++;
                }
            }
        }

        backtrack(s, 0, leftRemove, rightRemove, 0,
                  new StringBuilder(), set);

        return new ArrayList<>(set);
    }

    private void backtrack(String s, int index,
                            int leftRemove, int rightRemove,
                            int balance, StringBuilder sb,
                            Set<String> set) {

        if (index == s.length()) {
            if (leftRemove == 0 &&
                rightRemove == 0 &&
                balance == 0) {
                set.add(sb.toString());
            }
            return;
        }

        char c = s.charAt(index);

        // Remove '('
        if (c == '(' && leftRemove > 0) {
            backtrack(s, index + 1,
                    leftRemove - 1, rightRemove,
                    balance, sb, set);
        }

        // Remove ')'
        if (c == ')' && rightRemove > 0) {
            backtrack(s, index + 1,
                    leftRemove, rightRemove - 1,
                    balance, sb, set);
        }

        // Keep character
        if (c != '(' && c != ')') {
            sb.append(c);
            backtrack(s, index + 1,
                    leftRemove, rightRemove,
                    balance, sb, set);
            sb.deleteCharAt(sb.length() - 1);
        }
        else if (c == '(') {
            sb.append(c);
            backtrack(s, index + 1,
                    leftRemove, rightRemove,
                    balance + 1, sb, set);
            sb.deleteCharAt(sb.length() - 1);
        }
        else if (c == ')' && balance > 0) {
            sb.append(c);
            backtrack(s, index + 1,
                    leftRemove, rightRemove,
                    balance - 1, sb, set);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}