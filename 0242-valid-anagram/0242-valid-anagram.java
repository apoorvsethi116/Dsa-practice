class Solution {
    public boolean isAnagram(String s, String t) {
        char[] c = new char[26];
        for(int i = 0; i<s.length(); i++){
            c[s.charAt(i) - 'a']++;
        }
         for(int i = 0; i<t.length(); i++){
            c[t.charAt(i) - 'a']--;
        }
         for(int i = 0; i<c.length; i++){
           if(c[i] != 0){
            return false;
           }
        }

        return true;
    }
}