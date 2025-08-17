package L_BitsManipulation;

import java.util.Scanner;

public class x1_Power_of_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = in.nextInt();

        // 2
        if (isPowerOfTwo(num)) {
            System.out.println(num + " is a power of 2.");
        } else {
            System.out.println(num + " is NOT a power of 2.");
        }

        // Any number:
        System.out.print("Enter the number: ");
        int number = in.nextInt();

        System.out.print("Enter the base: ");
        int base = in.nextInt();

        if (isPowerOf(number, base)) {
            System.out.println(number + " is a power of " + base);
        } else {
            System.out.println(number + " is NOT a power of " + base);
        }
    }

    public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static boolean isPowerOf(int num, int base) {
        if (num <= 0 || base <= 1) return false;  // base must be ≥ 2

        while (num % base == 0) {
            num = num / base;
        }
        return num == 1;
    }

}
