class Solution {

    public int buildInt(char[] ch){
        try{
           return  Integer.parseInt(new String(ch));
        }catch(Exception e){
            return 0;
        }
    }

    public void reverse1(char[] ch , int i , int j){
        while(i<j){
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;


            i++;
            j--;
        }
    }
    
    public int reverse(int x) {

        char[] ch = Integer.toString(x).toCharArray();
        if(ch[0] == '-'){
            reverse1(ch , 1 , ch.length-1);
        }else{
             reverse1(ch , 0 , ch.length-1);

        }

       

        int ans = buildInt(ch);
        return ans;

    }
}