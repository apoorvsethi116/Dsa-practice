package Strings;
import java.util.*;


public class stringCompression {// aaabbc converted to a3b2c
    public static void main(String[] args) {
        String str = new Scanner(System.in).nextLine();
        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i <str.length(); i++){
            Integer count = 1;
            while(i<str.length()-1 && str.charAt(i) == str.charAt(i+1)){
                count ++;
                i++;
            }
            sb.append(str.charAt(i));
            if(count > 1){
                sb.append(count);
            }
        }

        System.out.println(sb);
    }
}
