package i_Exception_Handling;
import java.util.Scanner;

class Main {
    public static void main(String[] args)
    {
        Scanner input = new Scanner ( System.in );
        String name = input.next();
        String pwd = input.next();

        try{
            if ( pwd.length() < 6 ){
                throw new Exception( "Too short!" );
            }
            boolean hasDigit= false;
            for( int i=0 ; i<pwd.length() ; i++ ){
                if ( Character.isDigit(pwd.charAt(i)) ){            // Character.isDigit -> It’s a static method in Java’s Character class that checks if a given character is a digit
                    hasDigit=true;                                  // so with chat.at() -> we will access every char and check with above method
                    break;
                }
            }
            if ( !hasDigit) {
                throw new Exception("d");
            }
            System.out.println("Correct");
        }
        catch(Exception e ){
            System.out.println(e.getMessage());
        }
        input.close();


    }
}
