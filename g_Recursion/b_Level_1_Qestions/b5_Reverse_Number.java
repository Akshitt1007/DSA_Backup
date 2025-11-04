package g_Recursion.b_Level_1_Qestions;

public class b5_Reverse_Number {
    public static void main(String[] args) {

        reverseI ( 1234 );
        int answer = reverseII( 5678 );

        System.out.println("The reverse of given number is: " + sum);
        System.out.println("The reverse of given number is: " + answer);
    }

    static int sum = 0;

    // In this we will create a global variable and will be storing the value of last digit in this
    // here we will only use recursion to remove the last digit from the number given
    static void reverseI ( int num ){

        if ( num == 0 ){
            return ;
        }

        int ld = num%10;
        sum = ( sum*10 ) + ld;

        reverseI( num/10 ) ;
    }



    // Sometimes we might need some another arguments in the functions
    // in that case we make another function
    static int reverseII ( int num ){

       int digits = (int)(Math.log10(num))+1;
       // This expression is used to find the total number of digits in even integer

        return helper(num , digits);
    }

    static int helper( int num , int digits){

        if ( ( num%10 ) == num ){
            return num;
        }

        int ld = num % 10;
        return (int) (ld * Math.pow(10,digits-1) + helper(num/10, digits-1 ));

        // we are doing digit-1 because we want to move our last num at the first
        // so by digit-1 it would be multiplied by 1000 else it would get multiply by 10000 and get moved to 5th position
    }
}
