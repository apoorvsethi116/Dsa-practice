package Recursion;

public class DigitToWord {
    static  String[] words = {
            "zero",
            "one" , "two" , "three" , "four" , "five" , "six" , "seven",
            "eight"  , "nine" , "ten"
    };
    public static void printWords (int n ){
        if(n == 0){
            return;
        }
        int lastDigit = n % 10;
        printWords(n/10);
        System.out.print(words[lastDigit] + " ");


    }
    public static void main(String[] args) {
        //no ending with zero
        int n = 2019;
        printWords(n);
    }
}
