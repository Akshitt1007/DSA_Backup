package q_Additional.q1_StringBuffer;

import java.util.Arrays;

public class a6_extraMethod {
    public static void main(String[] args) {

        // Regex
        // It will remove all the spaces between the string
        // \\s -> removing spaces
        String a = " a           b       c d          e";
        System.out.println( a.replaceAll( "\\s", "" ));

        // Split
        // Here all the String will split up according to our preferences
        String b = "Akshit Abhinav Aryan ";

        String[] arr = b.split(" ");
        System.out.println(Arrays.toString( arr ));


        // Rounding Off

    }
}
