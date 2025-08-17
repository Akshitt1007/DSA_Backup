package a_Basics;

import java.util.Scanner;

public class a8_Loops {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number: ");
        int num = input.nextInt();      // taking input


        /*
        WHILE LOOP :

        initialization;
        while (condition) {
            code to be executed;
            increment/decrement;
        }

        it is used when we don't know how many times the loop would run
        */
        System.out.println("Using While Loop: ");

        int j = 1;
        while( j <= num ){
            System.out.println( j );
            j++;
        }


        /*
        FOR LOOP :

        for( initialization ; condition ; increment/ decrement ){
            code;
        }
        it is used when we know how many times the loop would run
         */

        System.out.println("Using For Loop: ");

        for(int i = 1 ; i <= num ; i++){
            System.out.println( i );
        }


        /*
        DO-WHILE LOOP :

        initialization;
        do{
            body;
            increment/decrement;
        }
        while( condition );

        it is used when we have to perform at least one output
         */

        System.out.println("Using Do-While Loop: ");

        int k = 6;
        do{
            System.out.println(k);
            k++;
        }
        while(k < 5);

        // here since k > 5 but it will always run 1 time

    }
}
