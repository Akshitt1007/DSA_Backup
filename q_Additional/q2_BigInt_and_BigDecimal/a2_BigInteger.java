package q_Additional.q2_BigInt_and_BigDecimal;


import java.math.BigInteger;

public class a2_BigInteger {
    public static void main(String[] args) {

        // Correct way to implement a Big integer
        BigInteger num = new BigInteger("123456789123456789");

        // BigInteger num2 = BigInteger.valueOf(123456789123456789888887654567898765434567890987654345678987654L);
        // This line is incorrect and will cause a compile-time error: "integer number too large"

        // Explanation:
        // - The method BigInteger.valueOf(x) accepts a value of type 'long'.
        // - Since 'long' can only store values up to 9,223,372,036,854,775,807,
        // - the literal provided here is far beyond that limit.

        // - In Java, before BigInteger.valueOf() is even called,
        // - the number literal itself must fit within the range of 'long'.
        // - Since it doesn’t, the compiler immediately throws an error.

        // Correct approach:
        // - For very large numbers (beyond 'long' range), always use a String:
        // - BigInteger num2 = new BigInteger("123456789123456789888887654567898765434567890987654345678987654");

        // Use BigInteger.valueOf(x) only for smaller values within the range of 'long'.
        BigInteger num2 = BigInteger.valueOf(123456787654L);


        // Constant
        BigInteger D = BigInteger.ZERO;
        /*
        What’s happening here?

        - We are NOT creating a new BigInteger object.
        - Instead, we’re referencing a pre-defined constant that already exists inside Java’s BigInteger class.
        - BigInteger.ZERO is a static constant that represents the BigInteger value 0.

        Why use it?

        Because creating new BigInteger objects for simple values like 0, 1, or 10 repeatedly is:
        1. Unnecessary
        2. Memory-inefficient
        3. Slower (it involves constructing or parsing each time)

        So, instead of writing:
            BigInteger D = new BigInteger("0");   // Creates a new object every time

        We use:
            BigInteger D = BigInteger.ZERO;       // Reuses an existing constant object

        This means:
            'D' does not create a new BigInteger instance — it simply points to the pre-created
            static constant 'ZERO' defined within the BigInteger class.
*/
        BigInteger one = BigInteger.ONE;  // start factorial with 1
        BigInteger two = BigInteger.TWO;
        BigInteger ten = BigInteger.TEN;
        BigInteger n = BigInteger.TEN.pow(5); // 10^5 = 100000


        // Operations:

        BigInteger sum = one.add(two);
        System.out.println( sum );

        System.out.println( one.subtract( two) );

        System.out.println( one.multiply( two) );

        System.out.println( one.divide( two) );


        // To get value
        int value = ten.intValue();                     // Converts BigInt into int
        BigInteger xyz = BigInteger.valueOf( 12355 );   // Converts int/float into the BigInt
        System.out.println( value );

        int sub = ( ten.subtract(two) ).intValue();
        System.out.println( sub );


        // Comparison
        // Since these are object so we will use "compareTo"
        // compareTo -> in OOPS folder
        if( one.compareTo(two) > 0 ){
            System.out.println( "one is greater" );
        }
        else {
            System.out.println( "two is greater" );
        }


    }
}
