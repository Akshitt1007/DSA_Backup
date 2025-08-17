package a_Basics;

public class a13_Sqrt_X {
    public static void main(String[] args) {
        int x = 4;
        int y = 81;
        int z = 2147395600;

        System.out.println( square_root(x) );
        System.out.println( square_root(y) );
        System.out.println( square_root(z) );

    }

    static int square_root ( int x ){

        // Special cases
        if (x == 0 || x == 1){
            return x;
        }

        int start = 1;
        int end = x;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            long square = (long) mid * mid; // Avoid integer overflow

            if (square == x) {
                return mid;

            } else if (square > x) {    // If sq of the mid is greater than the target than all the element right to it would also be greater so end = mid -1
                end = mid - 1;

            } else {                    // If sq of the mid is less than the target than all the element left to it would also be lesser so start = mid + 1
                start = mid + 1;
            }
        }

        return end;
    }
}
