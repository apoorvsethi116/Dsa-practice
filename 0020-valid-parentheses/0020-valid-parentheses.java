import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        int i = 0;
        while (i < s.length()) {
            char curr = s.charAt(i);

            if (curr == '(' || curr == '{' || curr == '[') {
                st.push(curr);
                i++;
            } else {
                if (st.isEmpty()) {
                    return false;
                }

                char top = st.peek();
                if ((curr == ')' && top == '(') ||
                    (curr == '}' && top == '{') ||
                    (curr == ']' && top == '[')) {
                    st.pop();
                    i++;
                } else {
                    return false;
                }
            }
        }

        return st.isEmpty();
    }
}