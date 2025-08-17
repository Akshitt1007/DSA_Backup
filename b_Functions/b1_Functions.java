package b_Functions;

import java.util.Scanner;
public class b1_Functions {
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

//        System.out.println("Enter the first number: ");
//        int num1 = input.nextInt();
//        System.out.println("Enter the second number: ");
//        int num2 = input.nextInt();
//        System.out.println("Sum is: " + ( num1  + num2 ) );
//
//        System.out.println("Enter the first number: ");
//        int num1 = input.nextInt();
//        System.out.println("Enter the second number: ");
//        int num2 = input.nextInt();
//        System.out.println("Sum is: " + ( num1  + num2 ) );
//
//        System.out.println("Enter the first number: ");
//        int num1 = input.nextInt();
//        System.out.println("Enter the second number: ");
//        int num2 = input.nextInt();
//        System.out.println("Sum is: " + ( num1  + num2 ) );

        // If we have to perform a program multiple times in a code it would make the code very bulky, and length
        // and if we want to change anything or any error occurs then we have changed it in every code we have written making it messier
        // That's why we have Function(methods)
        // By this we will write our specific code in a function and call it in the main function whenever needed
        // making it easier to write and less bulky and if we want to change anything we could change it the main code, and it will apply everywhere we have called it


        /*
            SYNTAX:

            return-type name ( arguments ) {
                body;
                return statement;
            }

         */

        // Void return type:
        add(input);
        add(input);
        add(input);
        // Here 'input' is the name of the object that will be taking the values from the user
        // by this the function named 'add' will also be pointing to the same object we made in main function

        // instead to write the code to sum 2 number we have created a function named add,
        // and we are calling it in the main functions

        // Int return type:
        int biggest = max( input );
        // it will store the value that is given back the max functions
        System.out.println("Biggest number is: " + max( input ) );

        // String return type:
        System.out.println("Enter your name: ");
        String your_name = name1(input);
        System.out.println("Your name is: " + your_name );


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

    }

    static void  add(Scanner input){
        // here the return type is VOID
        // because we are not returning any value to the main function as all the things is happening in the add function


        //  Scanner input = new Scanner(System.in);
        //  We will not write this Scanner in the function as it creates a new Scanner object every time the method is called.
        //  Instead, create the Scanner object once in the main method and pass it to the add() function.

        System.out.println("Enter the first number: ");
        int num1 = input.nextInt();
        System.out.println("Enter the second number: ");
        int num2 = input.nextInt();
        System.out.println("Sum is: " + ( num1  + num2 ) );
    }

    static int max(Scanner input){
        // return type here is int
        // because here are returning some value back to the main function
        // here 'int' is because of the datatype we are passing by and is different according to ours needs

        System.out.println("Enter the first number: ");
        int num1 = input.nextInt();
        System.out.println("Enter the second number: ");
        int num2 = input.nextInt();

        int max = Math.max(num1, num2);

        return max;
        // return the int datatype back to the main function
        // whenever the return is written it will end the code and not code will be executable after it
    }

    static String name1(Scanner input){

        return input.next();
    }
}
