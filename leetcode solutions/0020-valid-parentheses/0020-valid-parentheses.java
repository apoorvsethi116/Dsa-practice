class Solution {
    public static char[] open = {
        '['  , '{'  , '('
};
    public static char[] close = {
        ']', '}'  , ')'
    };
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i = 0;  i < s.length(); i++){
            if(s.charAt(i) == open[0] 
            ||s.charAt(i) == open[1]
            ||s.charAt(i) == open[2]){
                st.push(s.charAt(i));
            
            }else if(st.isEmpty()){
                return false;
            }else if(s.charAt(i) == close[0]
            ||s.charAt(i) == close[1]
            ||s.charAt(i) == close[2]){
                if(st.peek() == '[' && s.charAt(i) == close[0]
                ||st.peek() == '{' && s.charAt(i) == close[1]
                ||st.peek() == '(' && s.charAt(i) == close[2]){
                    st.pop();
                }else{
                    return false;
                }
            }
        }
        if(!st.isEmpty()){
            return false;
        }
        return true;
    }
}