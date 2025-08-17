package i_Exception_Handling;

import java.util.Scanner;

public class a5_Email {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter you Email: ");
        String email = input.next();

        try{
            if( !email.contains("@") || !email.contains(".") || email.indexOf('.') < email.indexOf('@')) {
                throw new Exception("Your email is wrong");
            }
            System.out.println("Valid Email");
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
/*
    id.indexOf('.')
        This finds the position (index) of the first dot (.) in the string id. If there’s no dot, it returns -1.

    id.indexOf('@')
        This finds the position of the first at-sign (@) in the string id. Again, if none exists, it returns -1.

    The comparison < asks:
        Is the position of the first dot less than the position of the first '@'?
        In other words, does the dot come before the '@' in the string?
 */
