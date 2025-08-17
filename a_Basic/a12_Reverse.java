package a_Basics;

import java.util.Scanner;

/*
        %10 will give us the last digit
        /10 will remove the last digit
            123/10 = 12.3 since it's an int so it cant have float value therefore we get 12
 */

public class a12_Reverse {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number: ");
        int num = input.nextInt();

        int reverse = 0;

        while(num != 0){
            int ld = num % 10;
            reverse = ld + reverse*10;
            num = num / 10 ;
        }
        System.out.println("Reversed number is: " + reverse);
    }
}
