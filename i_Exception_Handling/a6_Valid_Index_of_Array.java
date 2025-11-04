package i_Exception_Handling;

import java.util.Scanner;

public class a6_Valid_Index_of_Array {
    public static void main(String[] args) {

        Scanner input = new Scanner( System.in );

        System.out.println("Enter the size: ");
        int size = input.nextInt();

        System.out.println("Enter the element: ");
        int[] arr = new int[size];
        for ( int i=0 ; i<size ; i++ ){
            arr[i] = input.nextInt();
        }

        int t = input.nextInt();

        while ( t > 0 ){
            System.out.println("Enter index to check: ");
            int index = input.nextInt();

            try{
                if( index < 0 || index >= size ){
                    throw new Exception("Out of Bounds");
                }
                System.out.println(arr[index]);

            }catch( Exception e ){
                System.out.println(e.getMessage());
            }
            t--;
        }
    }
}
