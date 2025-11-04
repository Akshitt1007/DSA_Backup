package f_Strings;

public class a5_PrettyPrinting {
    public static void main(String[] args) {

        float pi = (float) Math.PI;

        System.out.println( pi );

        System.out.printf( " Formatted number %.2f " , pi );
            /*
                %f is the placeholder
                    it will have the value that we will be provided after the " "

                    here %.2f means that we want to print the float up to only 2 decimal places


                    here are the rest of placeholder different datatypes:

                    Specifier	Type	            Example Output
                       %d	   Integer	        System.out.printf("%d", 25); → 25
                       %f	   Float/Double	        %.2f → 3.14
                       %s	   String	           My name is %s
                       %c	   Character	            'A'
                       %b	   Boolean	           true or false
                       %n      New Line
             */
        System.out.println();
        System.out.printf( " Formatted number %.4f " , pi );
        System.out.println();
        System.out.printf( " %.3f " , pi );
        System.out.println();

        System.out.printf( " My name is %s %n and i live in %s" , "Akshit Choudhary" , "Chandigarh" );

        System.out.println();

        // Prints the current time in HH:MM:SS format
        System.out.printf(" The time in %s is %tT", "Chandigarh", new java.util.Date());    }
}
