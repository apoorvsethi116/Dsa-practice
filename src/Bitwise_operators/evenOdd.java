package Bitwise_operators;
import java.util.Scanner;
public class evenOdd {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int bitMask = 1;
        if((a & bitMask) == 0){
            System.out.println(a +" is even");
        }else{
            System.out.println(a + " is odd");
        }
    }

}
