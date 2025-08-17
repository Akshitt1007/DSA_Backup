package d_Searching.Linear_Search;

import java.util.Scanner;

public class a4_Minimum_Number {

    public static void main( String [] args ){
        Scanner s1 = new Scanner(System.in);

        int [] array = {1,2,234,452,-1413,95,1039,0};

        System.out.print("Given array: ");
        for(int i=0 ; i< array.length ; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();

        Minimum_Number(array);
    }

    static void Minimum_Number(int[] array){

        int max = 0;
        int min = Integer.MAX_VALUE;

        for(int i=0 ; i< array.length ; i++){
            if(max<array[i]){
                max = array[i];
            }
            if(min > array[i]){
                min = array[i];
            }
        }

        System.out.println("Greatest number is: " + max );
        System.out.println("Lowest number is: " + min );
    }
}
