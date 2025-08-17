package g_Recursion.b_Level_1_Qestions;

public class b2_Factorial_of_n {
    public static void main(String[] args) {

        int factorial = factorial( 5 );
        System.out.println( "Factorial of given number is:" + factorial );
    }

    static int factorial( int num ){

        if ( num <= 1 ){
            return 1;
        }

        return factorial( num-1) * num ;

    }
}
