package i_Exception_Handling;

// Since every exception class inherits from "Exceptions" class
public class a2_Own_Exceptions extends Exception {

    // Message - that we want to display if error occur
    public a2_Own_Exceptions( String Message ){
         super( Message );
         // will send to the Exception class

//        When you call .getMessage() on this exception later, it gives you that exact message.
    }

    public static void main(String[] args) {

        try{
            String name = "Akshit Choudhary";

            if( name.equals("Akshit Choudhary") ){
                throw new a2_Own_Exceptions("This is my own created exception." );
            }

        }
        catch ( a2_Own_Exceptions e ){
            System.out.println( "Caught: " + e.getMessage() );
        }
    }
}
