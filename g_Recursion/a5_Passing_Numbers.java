package g_Recursion;

public class a5_Passing_Numbers {
    public static void main(String[] args) {

        fun ( 5 );
    }

    static void fun ( int num ){

        if ( num == 0 ){
            return ;
        }

        System.out.println( num );

        // fun ( num-- );

        /*
            Post-Decrement (num--)

                i)  Order of operations: First use the current value, then decrement
                ii) If used in recursion like fun(num--), it would cause a stack overflow

                This happens because:
                    1) The current value 5 is passed to the recursive call
                    2) num is decremented to 4 after the call
                    3) Each recursive call receives the same value (5)
                    4) The base case is never reached
                    5) The call stack keeps growing until it overflows

            Pre-Decrement (--num)

                i)  Order of operations: First decrement, then use the new value
                ii) When used like fun(--num):

                    1) num is decremented from 5 to 4
                    2) The value 4 is passed to the recursive call
                    3) Each call receives a value one less than the previous call
                    4) Eventually reaches the base case (num == 0)
                    5)Recursion terminates properly
         */

        fun ( --num );
    }
}
