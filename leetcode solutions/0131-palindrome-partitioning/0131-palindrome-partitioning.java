class Solution {

    public boolean isPalindrome(String s){
        int i = 0;
        int j = s.length() - 1;

        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public void build(String s, int idx,
                      ArrayList<ArrayList<String>> ans,
                      ArrayList<String> carry){

        if(idx == s.length()){
            ans.add(new ArrayList<>(carry));
            return;
        }

        for(int i = idx; i < s.length(); i++){

            String temp = s.substring(idx, i + 1);

            if(isPalindrome(temp)){
                carry.add(temp);

                build(s, i + 1, ans, carry);

                carry.remove(carry.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {

        ArrayList<ArrayList<String>> ans = new ArrayList<>();

        build(s, 0, ans, new ArrayList<>());

        return new ArrayList<>(ans);
    }
}