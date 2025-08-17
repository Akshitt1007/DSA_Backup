package a_Basics;

import java.util.Scanner;


public class a9_Alphabet_Case_Check {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter your Character: ");

        // In Java, there is no direct method to input a single character from the user using Scanner.
        char character = input.next().charAt(0);
        /*
        a) To handle this, we first take a String input using input.next().
                char firstCharacter = "Hello".charAt(0);
                charAt(0) -> H
        b) The trim() method is used to remove any leading or trailing whitespace (though it's not strictly necessary here, as next() already ignores whitespace).
        c) The charAt(0) method extracts the first character of the input string, which effectively gives us the character we need.
         */

//        char character = input.next().charAt(1);    // this will access the 2 char in string
        String Word = "Akshit";
        System.out.println("At index 0: " + Word.charAt(0));     // access the first character at index[0]
        System.out.println("At index 3: " + Word.charAt(3));


        if(character>='A' && character <='Z'){
            System.out.println("Your Character is Capital " + character);
        }
        else if(character>='a' && character <='z') {
            System.out.println("Your Character is Small " + character);
        }
        else{
            System.out.println("Invalid character");
        }
    }
}
/*
    When to use next.trim().char(0) ??


 */
