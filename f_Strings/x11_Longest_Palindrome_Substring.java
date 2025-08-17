package f_Strings;

public class x11_Longest_Palindrome_Substring {
    public static void main(String[] args) {

        String a = "babad";
        String b = "bccd";

        System.out.println( longestPalindrome(a) );
        System.out.println( longestPalindrome(b) );
    }

    public static String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        String Longest = "";

        for( int i = 0 ; i < s.length() ; i++ ){

            for ( int j = i ; j < s.length() ; j++ ){

                String sub = s.substring( i, j+1 );

                if ( isPalindrome(sub) == true ){

                    if ( Longest.length() < sub.length() ){
                        Longest = sub ;
                    }
                }
            }
        }

        return Longest;
    }

    public static boolean isPalindrome ( String str ) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
