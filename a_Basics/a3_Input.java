package a_Basics;

import java.util.Scanner;

public class a3_Input {

    public static void main (String[] args){

        // The Scanner object is used to read user input from the keyboard (System.in)
        Scanner input = new Scanner(System.in); // in place of system.in we could also write any folder location whom
                                                // we want to take the input
                                                // here we are taking input from the keyboard so we are writing (System.in)

        System.out.println("Enter number : " + input.nextInt());

        input = new Scanner(System.in);

        System.out.println("Enter name : " + input.next());

        input = new Scanner(System.in);

        System.out.println("Enter college name " + input.nextLine());





        // Taking input from the user:

        System.out.print("Enter your name: ");
        // input = new Scanner(System.in);
        // we do not have to write it again and again because we have created the object name input in the starting
        // and by string name = input.next line we are storing the value of string given by the user in the object named 'input'
        // just simply the variable in which we want to store and then input.next()
        String name = input.nextLine();
        //  input.nextLine() reads the entire line of text the user enters and stores it in the variable name.
        //  nextLine() is used here because it reads everything typed by the user until they press Enter, including spaces.


        System.out.print("Enter your roll number: ");
        //  input = new Scanner(System.in);
        long rollNumber = input.nextLong();

        System.out.println( "Your name is: " + name );
        // now printing the value of string named 'name' that we stored earlier
        System.out.println( "Your roll number is: " + rollNumber );

    }

}
