class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String a = "";
        String b = "";

        for(String s : word1){
            a += s;
        }

        for(String y : word2){
            b += y;
        }


        return a.equals(b);
    }
}