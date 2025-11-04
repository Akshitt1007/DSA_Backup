package g_Recursion.b_Level_1_Qestions;

public class b3_Sum_of_n_numbers {
    public static void main(String[] args) {

        int answer = sum( 5 );

        System.out.println("Sum of n numbers are: " + answer );
    }

    static int sum ( int num ){

        if ( num == 1 ){
            return 1;
        }

        return sum(num-1 ) + num;
    }
}
