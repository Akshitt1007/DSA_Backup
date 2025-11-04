package f_Strings.Questions;

import java.util.Scanner;

public class Q1_Palindrome {
    public static void main(String[] args) {

        System.out.println( check_palindrome("akshit") );
        System.out.println( check_palindrome("mnm"));
        System.out.println( check_palindrome("racecar"));
        System.out.println( check_palindrome(" "));
        System.out.println( check_palindrome("Aka"));

    }

    static boolean check_palindrome( String word ){

        word = word.toLowerCase();

        if ( word == null || word.length() == 0 ){
            return true;
        }

        int length = word.length()-1;
        StringBuilder check = new StringBuilder();

        while ( length >= 0 ){
            check.append( word.charAt(length) );
            length --;
        }

        // Compare the original string with the reversed string
        return word.equals(check.toString());

        // String to a StringBuilder—they are different types. You should convert StringBuilder to String using .toString().
    }

    static boolean check_palindrome_efficient(String word) {

        // Reverse the string using StringBuilder
        String reversed = new StringBuilder(word).reverse().toString();

        // Compare the original string with the reversed one
        return word.equals(reversed);
    }
}
