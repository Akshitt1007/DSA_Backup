package a_Basics;

import java.util.Scanner;

public class a4_Sum_2_numbers{
    public static void main(String[] args){

        Scanner cin = new Scanner(System.in);
        // here instead of making the object name "input" I have taken it as "cin"

        System.out.print("Enter the first number: ");
        int num1 = cin.nextInt();
        System.out.print("Enter the second number: ");
        int num2 = cin.nextInt();

        System.out.println("The sum of " +  num1 + " and " + num2 + " is : " + (num1 + num2) );

    }
}