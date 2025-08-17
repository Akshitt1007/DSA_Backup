package f_Strings;

public class a8_StringBuilder {
    public static void main(String[] args) {

        // In previous folder,
//                we have seen that we are creating many object just to have a series of alphabet
//                which is very inefficient
//                in order to have an efficient program we can have a DATATYPE:
//                    where "ab" + 'c' = "abc" where c can be added to "ab" object instead of creating a new object
//                    the new character would be getting added to the previous string only
//                    in this way there would be only one object created
//                    save of memory
//
//            This datatype is called : StringBuilder

        /*
            Why is StringBuilder more efficient?

                1. String Immutability Issue:

                    a) Strings in Java are immutable, meaning they cannot be modified once created.
                    b) Each time you concatenate (+), a new object is created, and the old one is discarded.

                2. StringBuilder Efficiency:

                    a) StringBuilder is mutable, allowing you to modify the same object without creating new ones.
                    b) This reduces memory usage and improves performance for tasks requiring frequent modifications.
         */

        StringBuilder String_Builder = new StringBuilder();
        // This is separate class just like string

        for ( int i = 0 ; i < 26 ; i ++ ){

            char ch =  (char)( 'a' + i  );

            String_Builder.append( ch ).append(" ");
        }

        System.out.println( String_Builder );
        System.out.println( String_Builder.toString() );    // This is unnecessary because StringBuilder calls itself so no need to write again

        /*
            Explanation:
            - We are using the StringBuilder class, which is mutable.
            - Each time we append a character, we modify the same object.
            - This prevents the creation of new objects, saving memory.
            - When we print the object, it internally calls the toString() method.
        */

        String_Builder.reverse();   // Different commands for String_builder
        System.out.println( String_Builder );
    }
}
