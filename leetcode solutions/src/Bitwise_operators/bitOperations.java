package Bitwise_operators;
import java.util.Scanner;
public class bitOperations {
    public static int setIthBit(int a , int i ){
        int bitMask = 1<<i;
        return a | bitMask;
    }
    public static int clearIthBit(int a , int i ){
        int bitMask = ~(1<<i);
        return a & bitMask;
    }
    public static int updateIthBit(int a , int i , int newBit){
        if(newBit == 0){
            return clearIthBit(a , i);
        }else{
           return setIthBit(a , i);
        }

    }
    public static int clearLastIthBit(int a , int i ){
        int bitMask = (~0)<<i;
        return a & bitMask;
    }
    public static int clearRangeOfBit(int a , int i , int j ){
        int x = (~0) << (j + 1);
        int y = (1 << i) - 1;

        int bitMask = x | y;

        return a & bitMask;
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
