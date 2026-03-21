package Recursion;

public class lengthOfString {
    public static int lengthOfString(String str , int i ){
        if(i == str.length()){
            return 0;
        }
        return 1 + lengthOfString(str , i+1);

    }

    public static void main(String[] args) {
        String str = "sethi";
        System.out.println(lengthOfString(str , 0));
    }
}
