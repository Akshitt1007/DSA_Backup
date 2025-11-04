package b_Functions;

import java.util.Scanner;
public class b2_Passing_Functions {
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        /*
            SYNTAX:

            return-type name ( arguments ) {
                body;
                return statement;
            }

         */

        System.out.println("Enter the first number: ");
        int num1 = input.nextInt();

        System.out.println("Enter the second number: ");
        int num2 = input.nextInt();


        int biggest = max( input , num1 , num2);
        System.out.println("Biggest number is: " + biggest );

        /*
        What are Arguments?

        Arguments are the actual values we pass to a function when calling it.
        If we want to send some values to the function instead of taking input inside the function,
        we use parameters to define what the function will accept.

         This can be done while calling the function from main, like:
        add(10, 9);

        Example:
        static int add(int num1, int num2) {
            // Here, num1 = 10 and num2 = 9 are parameters
            // The values 10 and 9 passed during the function call are the arguments
            return num1 + num2;
        }

        In this case:
        - Parameters: The variables defined in the function signature (e.g., num1 and num2).
        - Arguments: The actual values passed to the function (e.g., 10 and 9).
        */

        System.out.println("Who are you ?");
        String naam = input.next();
        String name = greeting(naam);
        System.out.println(name);
        // calling the function by giving the arguments

    }

    static int max(Scanner input, int num1 , int num2){


        int max = Math.max(num1, num2);

        return max;
    }

    static String greeting(String name){
        String message = "Hello " + name ;
        return message;
    }
}
/*

    1) We are taking a string value (e.g., user input or a predefined string) and storing it in a variable
       named 'naam' (a variable of type String).

    2) We are then calling a function named 'greeting'.

    3) The 'greeting' function requires an argument (a String).
       We are passing the value stored in 'naam' to the 'greeting' function when calling it.

    4) Inside the 'greeting' function, a new String variable named 'message' is created.
       This variable concatenates "Hello " with the value passed as an argument.

    5) The 'greeting' function then returns this concatenated message back to the main function.

    6) In the main function, the returned message is stored in a variable (e.g., 'name').

    7) Finally, we print the value stored in 'name', which contains the greeting message.

*/

