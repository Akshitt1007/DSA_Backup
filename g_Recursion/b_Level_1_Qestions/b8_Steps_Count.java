package g_Recursion.b_Level_1_Qestions;

// Leetcode 1342 : https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/description/

public class b8_Steps_Count {
    public static void main(String[] args) {

        int count = count( 14 );
        System.out.println("Total count: " + count );

    }

    static int count( int num ){

        return helper ( num , 0 );
    }

    static int helper( int num , int count ){

        if ( num == 0 ){
            return count;
        }

        if ( num % 2 == 0){
            return helper( num/2 , count+1);
        }

        return helper( num-1 , count+1);

    }
}
