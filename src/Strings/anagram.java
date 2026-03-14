package Strings;
import java.util.*;

public class anagram {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();

        // Convert Strings to lowercase
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        // First check - if the lengths are the same
        if (str1.length() == str2.length()) {

            // convert strings into char array
            char[] str1charArray = str1.toCharArray();
            char[] str2charArray = str2.toCharArray();

            // sort the char arrays
            Arrays.sort(str1charArray);
            Arrays.sort(str2charArray);

            // check if arrays are equal
            boolean result = Arrays.equals(str1charArray, str2charArray);

            if (result) {
                System.out.println(str1 + " and " + str2 + " are anagrams of each other.");
            } else {
                System.out.println(str1 + " and " + str2 + " are not anagrams of each other.");
            }

        } else {
            System.out.println(str1 + " and " + str2 + " are not anagrams of each other.");
        }
    }
}