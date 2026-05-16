package BackTracking;
//if length of string is n
//then subset of strings is at max 2^n
public class AllSubset {
    public static void allSubset(String str , String ans , int i){
        //base case
        if(i == str.length()){
            if(ans.isEmpty()){
                System.out.println("null");
            }else {
                System.out.println(ans);
            }
            return;
        }
        //recursion
        //yes
        allSubset(str , ans + str.charAt(i) , i+1 );

        //no
        allSubset(str , ans , i+1);
    }
    public static void main(String[] args) {
        String str = "abc";
        allSubset(str , "", 0);
    }
}
