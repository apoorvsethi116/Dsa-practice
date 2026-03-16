package Bitwise_operators;

public class upperCaseToLOwer {
    public static void main(String[] args){
        char ch = 'A';

        char lower = (char)(ch | ' ');// 32 IS ASCII of space

        System.out.println(lower);
    }
}
//to underswtand use of bit else where
//https://graphics.stanford.edu/~seander/bithacks.html