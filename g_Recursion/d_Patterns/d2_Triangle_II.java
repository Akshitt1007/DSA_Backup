package g_Recursion.d_Patterns;

public class d2_Triangle_II {
    public static void main(String[] args) {

        triangle ( 4 );

    }

    static void triangle( int n ){
        helper ( n , 0 );
    }
    static void helper( int row , int col ){

        if ( row == 0 ){
            return;
        }

        if ( col < row ){
            helper( row , col+1 );
            System.out.print("* ");
        }
        else {
            helper( row-1 , 0 );
            System.out.println();
        }
    }
}
