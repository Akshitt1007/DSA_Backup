package f_Strings;

import java.util.HashSet;

//3. Longest Substring Without Repeating Characters
//https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

public class x9_Longest_Substring {
    public static void main(String[] args) {

    }

    public static int lengthOfLongestSubstring(String arr) {

        if( arr.length() == 1  ){
            return 1;
        }

        HashSet<Character> set = new HashSet<>();

        int count = 0;
        int max = 0;
        int x = 0;

        for( int i=0 ; i<arr.length() ; i++ ){

            while( set.contains( arr.charAt(i) ) ){
                set.remove( arr.charAt(x) );
                count--;
                x++;
            }

            set.add( arr.charAt(i) );
            count++;

            if( max < count ){
                max = count;
            }
        }

        return max;
    }
}
