package g_Recursion.b_Level_1_Qestions;

public class b4_Sum_Product_of_digits {
    public static void main(String[] args) {

        int answer = Sum_of_digits ( 12345 );
        System.out.println("Sum of all the digits are: " + answer );

        int answer2 = Product_of_digits( 12345 );
        System.out.println("Product of all the digits are: " + answer2);

        System.out.println("Sum of all the digits are: " + Sum_of_digits(999) );
        System.out.println("Product of all the digits are: " + Product_of_digits(876543) );
    }

    static int Sum_of_digits( int num ){

        if ( num == 0 ){
            return 0;
        }

//        int ld = num%10;
//        return Sum_of_digits( num/10 ) + ld;

        return Sum_of_digits( num/10 ) + ( num%10 );
    }

    static int Product_of_digits( int num ){

        if ( (num%10) == num ){
            return num;
        }

        return Product_of_digits( num/10 ) * ( num%10 );
    }
}
