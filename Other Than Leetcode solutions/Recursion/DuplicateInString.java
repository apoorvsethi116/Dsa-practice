package Recursion;

public class DuplicateInString {
    public static String removeDuplicate(String str , int i , StringBuilder sb , boolean arr[] ){
        if(i == str.length()){
            return sb.toString();
        }

        char currChar = str.charAt(i);

        if (arr[currChar - 'a']) {
            return removeDuplicate(str, i + 1, sb, arr);
        } else {
            arr[currChar - 'a'] = true;
            sb.append(currChar);
            return removeDuplicate(str, i + 1, sb, arr);
        }
    }
    public static void main(String[] args){
        String str = "seeettthii";
        String res = removeDuplicate(str , 0 , new StringBuilder() , new boolean[26] );
        System.out.println(res);
    }
}
