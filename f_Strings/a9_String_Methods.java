package f_Strings;

import java.util.Arrays;
import java.util.Locale;

public class a9_String_Methods {
    public static void main(String[] args) {

        String name = "Akshit Choudhary";

        System.out.println(Arrays.toString( name.toCharArray() ) );

        System.out.println( name.toLowerCase() );

        System.out.println( name.toUpperCase() );

        System.out.println( name.charAt(0) );
        System.out.println( name.indexOf("C") );

        System.out.println( name.length() );

        String name_2 = "         akshit";
        System.out.println( name_2.trim() );

        String name_3 = "I am Akshit Choudhary ";
        System.out.println( Arrays.toString( name_3.split( " " ) ) );
    }
}
