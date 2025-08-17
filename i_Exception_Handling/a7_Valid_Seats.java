package i_Exception_Handling;
import java.util.*;

public class a7_Valid_Seats {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] seats = new int[100];
        int[] booked = new int[100];
        int count = 0;
        System.out.print("Enter the number of seats to be booked:\n");
        int n = sc.nextInt();
        try {
            for (int i = 0; i < n; i++) {
                System.out.print("Enter the seat number " + (i + 1) + "\n");
                int seat = sc.nextInt();

                if (seat < 1 || seat > 100) {
                    throw new ArrayIndexOutOfBoundsException(String.valueOf(seat - 1));
                }
                seats[seat - 1] = 1;
                booked[count++] = seat;
            }
            System.out.println("The seats booked are:");
            for (int i = 0; i < count; i++) {
                System.out.println(booked[i]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("java.lang.ArrayIndexOutOfBoundsException: " + e.getMessage());
        }
    }
}