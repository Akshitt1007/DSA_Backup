package f_Strings;

public class a3_Output {
    public static void main(String[] args) {

        System.out.println( 56 );

        /*
            here, we will study System.out in object-oriented programing.

            and
                println is a method that is created in a PrintSteam Class
                which is used to give output on the terminal .
         */

        System.out.println( 56 );
        System.out.println( "akshit" );
        System.out.println( new int[]{1,2,3} );

        /*
            internally if we do ctrl+click on println we see:

                1) on integer type the method is having parameter as integer

                2) on string type the method is having parameters as a string

                3) on array type the method is having parameters as array

            all these are happening due to method overloading
         */
    }
}
