package BackTracking;

public class Keypad {
    static String[] arr = {
            "",
            "" , "abc" , "def" , "ghi" , "jkl",
            "mno" , "pqrs" , "tuv" , "wxyz"
    };
    public static void pairs(String num , int i , String res){
        if(i == num.length()){
            System.out.println(res);
            return;
        }
        char ch = num.charAt(i);//2
        String str = arr[ch - '0'];//abc

        for(int j = 0 ; j < str.length(); j++){
            pairs(num , i+1 , res + str.charAt(j));
        }
    }
    public static void main(String[] args) {
        String num = "23";
        pairs(num , 0 , "");
    }
}
