package g_Recursion.d_Patterns;

public class d1_Triangle {
    public static void main(String[] args) {

//        triangle( 4 );
        triangle_recursion( 4 );
    }

    static void triangle ( int n ){

        for ( int i = 0 ; i <= n ; i++ ){

            for ( int j = i ; j <= n ; j ++ ){

                System.out.print( "* ");

            }
            System.out.println();
        }
    }

    static void triangle_recursion ( int n ){
        helper( n , 0);
    }
    static void helper( int row , int col ){

        if ( row == 0 ){
            return;
        }

        if ( row == col ){
            System.out.println();
            helper( row-1 , 0 );        // Go to next row
            return;                             // why this ?
        }

        System.out.print("* ");

        helper( row , col+1 );   // Print column
    }
}
/*
        Call: helper(2, 0):

        → prints "* "
        → helper(2, 1)
            → prints "* "
            → helper(2, 2)
                → (row == col) so:
                    → prints newline
                    → helper(1, 0)
                        → prints "* "
                        → helper(1, 1)
                            → (row == col)
                                → prints newline
                                → helper(0, 0)  ← base case hit, returns

        Now when helper(0, 0) returns, the program just goes back up the recursive call stack, but does not re-enter any loops or code.
        It unwinds and finishes.

        So:
        1) The row value only changes when we explicitly pass a new value into the recursive call like helper(row - 1, 0)

        2) Once row == 0, the base case is hit, and the function simply returns up the call stack

        3) No part of the program changes row from 0 to 1 — the row increasing never happens. What you might be seeing is a higher level recursive call
           with row = 1 that was already in progress before the base case was hit.

 */
/*
    🔁 Summary:
    1) row == 0 causes a return → recursion ends.
    2) No further printing happens after that.
    3) You're not changing row from 0 to 1 — you're just returning to a previous state of the call stack where row was already 1.
 */