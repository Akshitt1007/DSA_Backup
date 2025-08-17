package a_Basics;

import java.util.Scanner;
//
//public class a6_Conditions{
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//
//        System.out.println("Enter your salary: ");
//        int a = in.nextInt();
//
//        if(300000 > a && a >= 70000){
//            System.out.println("Middle class");
//        }
//        else if(a<70000){
//            System.out.println("Poor");
//        }
//        else{
//            System.out.println("Rich");
//        }
//    }
//}


public class a6_Conditions {
    public static void main(String[] args){
        Scanner hi = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int a = hi.nextInt();

        if(a >= 50000){
            System.out.println("You got a bonus of 5000: " + (a+5000) );
        }
        else if(a >= 10000){
            System.out.println("You got a bonus of 2000: " + (a+2000) );
        }
        else{
            System.out.println("No bonus " + a);
        }

/*
    In case of string we use .equal to campre to strings instead of == . Why?

    1. == Operator:

    In programming languages like Java (and others with similar string-handling semantics), the reason we use .equals()
    instead of == to compare strings lies in how they handle object references versus object content.

    The == operator checks if two references point to the same object in memory, not whether their values are the same.
 */
    String str1 = new String("hello");
    String str2 = new String("hello");

    if (str1 == str2) {
            System.out.println("Equal");
    } else {
            System.out.println("Not Equal");
        }
        // this ' == ' will check whether the both string are the same objects or not
        // here str 1 and str 2 are both different object with same data but if we want to check the data in it, we have to use .equal

    /*
        2. .equals() Method:

        The .equals() method is overridden in the String class (from Object) to compare the content of the strings rather than their references.
     */
        String str3 = new String("hello");
        String str4 = new String("hello");

        if (str1.equals(str4)) {
            System.out.println("Equal");
        } else {
            System.out.println("Not Equal");
        }
        // here instead of comparing the address of both the string we are comparing the value of it

        /*
            Reference vs Value:

            '==' checks reference equality (same object in memory).
            '.equals()' checks value equality (same content).
         */

    }
}
