package Bitwise_operators;
import java.util.Scanner;
public class bitOperations {
    public static void setIthBit(String[] args ){

    }
    public static int getIthBit(int a , int i){
        int bitmax = 1 << i;
        if((a & bitmax) == 0){
            return 0;
        }else{
            return 1;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        System.out.println(getIthBit(a , 2));
    }
}
