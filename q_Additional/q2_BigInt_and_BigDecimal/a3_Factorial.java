package q_Additional.q2_BigInt_and_BigDecimal;

import java.math.BigInteger;
import java.util.Scanner;

public class a3_Factorial {
    public static void main(String[] args) {

        Scanner sc = new Scanner( System.in );
        int num = sc.nextInt();

        BigInteger ans = factorial( num );
        System.out.println( ans );
    }

    static BigInteger factorial(int num ){

        BigInteger fact = new BigInteger("1");

        for( int i=2 ; i<=num; i++ ){
            fact = fact.multiply( BigInteger.valueOf(i) );
        }

        return fact;
    }
}
