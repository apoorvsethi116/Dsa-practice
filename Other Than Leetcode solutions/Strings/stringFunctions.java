package Strings;

public class stringFunctions {

    public static void main(String[] args){
        String[] fruits = {"apple" , "mango" , "banana"  , "watermelon"};
        //Finding the largest string in lexicographic order i.e. comparing alphabets in precedence
        String largest = fruits[0];
        for (int i = 0; i < fruits.length; i++) {
            if(largest.compareToIgnoreCase(fruits[i])<0){
                largest = fruits[i];
            }
            // .compareTo() : gives value 0 , -ve ,or +ve
            // 0 : same string
            // -ve : smaller string lexically
            // +ve : bigger string lexically
            // .compareToIgnoreCase() : ignores upper and lower case precedence rules
        }
        System.out.println(largest);
    }
}
