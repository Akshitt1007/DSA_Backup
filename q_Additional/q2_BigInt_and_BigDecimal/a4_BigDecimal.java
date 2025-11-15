package q_Additional.q2_BigInt_and_BigDecimal;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class a4_BigDecimal {
    public static void main(String[] args) {

        System.out.println("=== BIGDECIMAL CREATION ===");
        // 1️⃣ Using String constructor (recommended)
        BigDecimal bd1 = new BigDecimal("123.456");

        // 2️⃣ Using int, long, double (⚠️ double not recommended due to precision loss)
        BigDecimal bd2 = BigDecimal.valueOf(456.789);  // safe factory method
        BigDecimal bd3 = new BigDecimal(123);          // from int
        BigDecimal bd4 = new BigDecimal("0.1");        // exact
        BigDecimal bd5 = new BigDecimal(0.1);          // ⚠️ not exact (binary floating-point issue)

        System.out.println("bd1 = " + bd1);
        System.out.println("bd2 = " + bd2);
        System.out.println("bd3 = " + bd3);
        System.out.println("bd4 = " + bd4);
        System.out.println("bd5 (from double) = " + bd5);

        System.out.println("\n=== ARITHMETIC OPERATIONS ===");
        BigDecimal a = new BigDecimal("10.50");
        BigDecimal b = new BigDecimal("3.25");

        System.out.println("a + b = " + a.add(b));         // addition
        System.out.println("a - b = " + a.subtract(b));    // subtraction
        System.out.println("a * b = " + a.multiply(b));    // multiplication

        // Division with rounding
        BigDecimal division = a.divide(b, 5, RoundingMode.HALF_UP);
        System.out.println("a / b (5 decimal places) = " + division);

        // Division without rounding (exact division)
        try {
            System.out.println("a / b exact = " + a.divide(b)); // throws ArithmeticException if non-terminating
        } catch (ArithmeticException e) {
            System.out.println("Exact division failed: " + e.getMessage());
        }

        System.out.println("\n=== COMPARISON OPERATIONS ===");
        BigDecimal x = new BigDecimal("10.00");
        BigDecimal y = new BigDecimal("10");

        System.out.println("x.equals(y)? " + x.equals(y));       // false (scale matters)
        System.out.println("x.compareTo(y) == 0? " + (x.compareTo(y) == 0)); // true (value same)

        System.out.println("x > y ? " + (x.compareTo(y) > 0));
        System.out.println("x < y ? " + (x.compareTo(y) < 0));

        System.out.println("\n=== SCALE & ROUNDING ===");
        BigDecimal num = new BigDecimal("12.3456789");
        System.out.println("Original: " + num);
        System.out.println("Scale: " + num.scale());

        // Set new scale (rounding)
        BigDecimal scaled = num.setScale(3, RoundingMode.HALF_UP);
        System.out.println("Rounded to 3 decimals (HALF_UP): " + scaled);

        // Remove trailing zeros
        System.out.println("Without trailing zeros: " + scaled.stripTrailingZeros());

        System.out.println("\n=== MOVE POINT OPERATIONS ===");
        System.out.println("movePointLeft(2): " + num.movePointLeft(2));   // divide by 100
        System.out.println("movePointRight(2): " + num.movePointRight(2)); // multiply by 100

        System.out.println("\n=== MAX / MIN ===");
        BigDecimal n1 = new BigDecimal("5.5");
        BigDecimal n2 = new BigDecimal("9.9");
        System.out.println("Max: " + n1.max(n2));
        System.out.println("Min: " + n1.min(n2));

        System.out.println("\n=== POWER & NEGATE ===");
        BigDecimal p = new BigDecimal("2.5");
        System.out.println("2.5 ^ 3 = " + p.pow(3)); // 2.5^3
        System.out.println("Negate(2.5): " + p.negate());

        System.out.println("\n=== REMAINDER ===");
        BigDecimal div1 = new BigDecimal("10");
        BigDecimal div2 = new BigDecimal("3");
        System.out.println("10 % 3 = " + div1.remainder(div2));

        System.out.println("\n=== CONVERSIONS ===");
        BigDecimal val = new BigDecimal("12345.6789");
        System.out.println("intValue: " + val.intValue());
        System.out.println("longValue: " + val.longValue());
        System.out.println("doubleValue: " + val.doubleValue());
        System.out.println("toPlainString: " + val.toPlainString());
        System.out.println("toEngineeringString: " + val.toEngineeringString());
        System.out.println("toBigInteger: " + val.toBigInteger());
    }
}
