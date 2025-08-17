package b_Functions;

import java.util.Scanner;

public class b9_PrimeNumber {

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number to check: ");
        int num = input.nextInt();

        boolean check = prime_number(num);
        if(!check){
            System.out.println("Not a prime number");
        }
        else{
            System.out.println("Prime number");
        }
    }

    static boolean prime_number(int num){
        if(num <=1 ){
            return false;
        }

        for( int i = 2 ; i<num ; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}