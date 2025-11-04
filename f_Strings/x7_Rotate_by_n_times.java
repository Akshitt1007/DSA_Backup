package f_Strings;

public class x7_Rotate_by_n_times {
    public static void main(String[] args) {
        System.out.println(rotateRight("abcdef", 2)); // Output: efabcd
    }

    public static String rotateRight(String str, int n) {
        int len = str.length();

        // Normalize n (in case it's greater than the string length)
        n = n % len;

        // No rotation needed
        if (n == 0) return str;

        // Slice and stitch
        String end = str.substring(len - n);
        String start = str.substring(0, len - n);

        return end + start;
    }
}
