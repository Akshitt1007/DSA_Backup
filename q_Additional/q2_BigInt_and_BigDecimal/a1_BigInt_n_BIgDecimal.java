package q_Additional.q2_BigInt_and_BigDecimal;

/*
    Why need BigInt and BigDecimal?

        - There are primitive datatypes like:
            int, long, float, double
        - Which hold values up to a specific size or limit

        - like:
            int max = 2,147,483,647
            long max = 9,223,372,036,854,775,807
            double = has precision issues with decimals (like rounding errors)

        - So when need to work with large value or to have precise decimal these primitive datatypes arn't enough

        so to solve this problem we have big int and big decimal

    💪 BigInteger:

        - BigInteger handles very large integers (bigger than long) — numbers of any size, limited only by memory.
             BigInteger num1 = new BigInteger("9999999999999999999999999999");
             BigInteger num2 = new BigInteger("123456789123456789");
        Range = -2^Integer.max.value <-> 2^Integer.max.value

    💰 BigDecimal
        - BigDecimal is for very precise decimal arithmetic — especially when working with money, scientific data, or anything that needs exact precision.

        - System.out.println(0.1 + 0.2);
        - This will give = 0.30000000000000004
        - This is because of the binary floating point error

        - BigDecimal a = new BigDecimal("0.1");
          BigDecimal b = new BigDecimal("0.2");
        - Gives perfect decimal answer = 0.3.

        - Since These are object and not datatype
        - we can't use normal operations -> + - % /
        - we use -> add(), subtract(), multiply(), divide(), mod()


 */
public class a1_BigInt_n_BIgDecimal {
    public static void main(String[] args) {

    }
}
