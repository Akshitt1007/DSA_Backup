package c_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class c2_Input_and_Output {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

//        // Method 1:
//        int [] arr = new int [5];
//        arr[0] = 1;
//        arr[1] = 2;
//        arr[2] = 3;
//        arr[3] = 4;
//        arr[4] = 5;
//
//        System.out.println("Your array is: ");
//        for (int i=0 ; i<arr.length ; i++){
//            System.out.print(arr[i] + " ");
//        }
//        System.out.println();
//
//
//        // Method 2:
//        int [] arr2 = new int [5];
//
//        for( int i = 0 ; i < arr2.length ; i++ ){
//            System.out.print( "Enter the " + (i+1) + " element: " );
//            arr2[i] = input.nextInt();
//        }
//        System.out.println();
//        System.out.println( "Your 2nd array is: " );
//        for ( int i = 0 ; i < arr.length ; i++ ){
//            System.out.print( arr2[i] + " " );
//        }
//
//
//        // Method 3:
//        int [] arr3 = {1,2,3,4,5,};
//        System.out.println(Arrays.toString(arr3));  // another way to print whole array
//
//
//
        // For String

        // Method 1:
//        String[] str = {"akshit" , "abhinav" , "aryan"};
//        System.out.println();
//
//        for(int i = 0 ; i < str.length ; i++){
//            System.out.print( str[i] + " ");
//        }
//        System.out.println();
//
//
//        //Method 2:
//        String [] str2 = new String[3];
//
//        for(int i = 0 ; i < str2.length ; i++ ){
//            str2[i] = input.nextLine();
//        }
//        for(int i = 0 ; i < str2.length ; i++){
//            System.out.print( str2[i] + " ");
//        }
//        System.out.println();
//
//
//        // Method 3:
//        String [] str3 = {"Akshit" , "Abhinav"};
//
//        str3[0] = "Aryan";
//
//        System.out.println(Arrays.toString(str3));


        // passing in function;
        int[] change = {1,2,3,4,5};
        System.out.println(Arrays.toString(change));
        change(change);
        System.out.println(Arrays.toString(change));

    }
    static void change(int [] arr){

        arr[0] = 69;
    }
}
