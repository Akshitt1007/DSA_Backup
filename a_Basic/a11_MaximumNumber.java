package a_Basics;

import java.util.Scanner;

public class a11_MaximumNumber {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();

//        if( a>b && a>c ){
//            System.out.println( a + " is greater.");
//        }
//        else if( b>a && b>c ){
//            System.out.println( b + " is greater.");
//        }
//        else if( c>a && c>b ){
//            System.out.println( c + " is greater.");
//        }
//        else{
//            System.out.println("All are equal");
//        }


//        int max = a;
//
//        if( b > max ){
//            max = b;
//        }
//
//        if ( c > max ){
//            max = c;
//        }
//        System.out.println( max + " is greatest number.");


//        int maximum = Math.max(a,b);    // function to find the maximum number
        int maximum = Math.max(c , Math.max(a,b));  // to find th maximum between 3 number
        /*  first max fun. to find the max number between a,b
            and then 2nd max fun. to find the max number between c and (a,b) and storing it in maximum
         */
        System.out.println( maximum + " is the greatest number.");


        System.out.println("Enter the number: ");
        int num = in.nextInt();

        int max = 0;
        while(num != 0){
            int ld = num % 10 ;
            if(ld > max){
                max = ld;
            }
            num = num/10;
        }
        System.out.println("Greatest digits in " + num + " is " + max);

    }
}