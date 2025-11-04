package f_Strings;


//  https://leetcode.com/problems/hash-divided-string/
//  3271. Hash Divided String

public class x12_Hash_Divided_String {
    public static void main(String[] args) {

        System.out.println( stringHash("abcd", 2));
        System.out.println( stringHash("mxz", 3));
        System.out.println( stringHash("ant", 1));
    }

    public static String stringHash(String s, int k) {

        StringBuilder x = new StringBuilder();

        char[] str = s.toCharArray();

        int size = k;

        int i = 0;
        while( i != str.length ){

            int sum = 0;
            for( int j = i ; j < k ; j++, i++ ){
                sum += str[j] - 'a';
            }
            k=k+size;

            sum = sum % 26;
            x.append((char) ('a' + sum));

        }
        return x.toString();
    }
}
