class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] freq = new int[26];

        for(int i = 0; i<s.length(); i++){
            char s1 = s.charAt(i);
            char t1 = t.charAt(i);

            freq[s1-'a']++;
            freq[t1-'a']--;
        }

        for(int a : freq){
            if(a!=0){
                return false;
            }
        }


        return true;
    }
}