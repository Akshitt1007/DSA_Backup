package g_Recursion.b_Level_1_Qestions;

public class b1_Print {
    public static void main(String[] args) {

//        print(5);
//
//        int starting = 1;
//        print_reverse(starting ,5);
//
//        print_reverseII( 5 );
//
//        final_print( 5 );

        final_printII( 5 );
    }

    // Q print from nth to 1
    // 5 4 3 2 1
    static void print( int num ){

        if( num < 1 ){
            return;
        }

        System.out.print( num + " " );

        print( num - 1 );
    }

    // Q print from 1 to nth
    // 1 2 3 4 5
    static void print_reverse( int start , int num ){

        if ( start == num ){
            System.out.println( start );
            return;
        }

        System.out.print( start + " " );

        print_reverse( start+1 , num );
    }

    //  Here without any extra variable
    //  This will be printing the values after the stack would start to get empty
    static void print_reverseII( int num ){

        if ( num == 1 ){
            System.out.print( num + " ");
            return;
        }

        print_reverseII( num - 1 );

        System.out.print( num + " ");
    }

    // 5 4 3 2 1 0 1 2 3 4 5
    static void final_print ( int num ){

        if ( num == 0 ){
            System.out.print( num + " " );
            return;
        }

        System.out.print( num + " " );
        final_print( num - 1 );
        System.out.print( num + " " );

    }

    // 1 2 3 4 5 5 4 3 2 1
    static void final_printII ( int num ){

        if ( num == 0 ){
            return ;
        }

        final_printII( num - 1 );
        System.out.print( num + " " );
    }
}
