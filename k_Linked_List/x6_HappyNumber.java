package k_Linked_List;

public class x6_HappyNumber {
//    https://leetcode.com/problems/happy-number/
    public static boolean checkHappyNumber( int num ){

        int fast = num;
        int slow = num;

        do {
            slow = squareReturn(slow);                   // Moving 1 num ahead
            fast = squareReturn( squareReturn(fast) );   // Moving 2 number ahead
        }
        while ( slow != fast );

        if ( slow == 1 ){
            return true;
        }
        return false;
    }

    public static int squareReturn( int n ){
        int sum = 0;
        while ( n > 0 ){
            int ld = n%10;
            sum += ld*ld;
            n=n/10;
        }

        return sum;
    }
    public static void main(String[] args) {

        int number = 19;
        System.out.println( checkHappyNumber(19) );

        int number2 = 2;
        System.out.println( checkHappyNumber(2) );
    }
}
