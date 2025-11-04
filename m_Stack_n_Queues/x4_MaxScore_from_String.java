package m_Stack_n_Queues;

// 1717. Maximum Score From Removing Substrings
// https://leetcode.com/problems/maximum-score-from-removing-substrings/?envType=daily-question&envId=2025-07-23

import java.util.Stack;

public class x4_MaxScore_from_String {
    public static void main(String[] args) {

        System.out.println( maximumGain_using_Stack( "cdbcbbaaabab", 4, 5) );
        System.out.println( maximumGain_using_Stack( "aabbaaxybbaabb", 5, 4) );
    }

    public static int maximumGain_using_Stack(String s, int x, int y) {

        Stack<Character> stack = new Stack<>();
        int total = 0;

        if ( x > y ){
            // for "AB"
            for( int i = 0 ; i < s.length() ; i++ ){

                if ( !stack.isEmpty() && s.charAt(i) == 'b' && stack.peek() == 'a' ){
                    total = x + total;
                    stack.pop();
                }
                else{
                    stack.push( s.charAt(i) );
                }
            }

            // string to calculate remaining "BA"
            StringBuilder str = new StringBuilder();

            while (!stack.isEmpty()) {
                str.append(stack.pop());
            }
            str.reverse();

            // for "BA"
            for( int i = 0 ; i < str.length() ; i++ ){

                if( !stack.isEmpty() && str.charAt(i) == 'a' && stack.peek() == 'b' ){
                    total = y + total;
                    stack.pop();
                }
                else{
                    stack.push(str.charAt(i));
                }
            }
        }
        else{
            // for "BA"
            for( int i = 0 ; i < s.length() ; i++ ){

                if ( !stack.isEmpty() && s.charAt(i) == 'a' && stack.peek() == 'b' ){
                    total = y + total;
                    stack.pop();
                }
                else{
                    stack.push( s.charAt(i) );
                }
            }

            // string to calculate remaing "AB"
            StringBuilder str = new StringBuilder();

            while (!stack.isEmpty()) {
                str.append(stack.pop());
            }
            str.reverse();

            // for "AB"
            for( int i = 0 ; i < str.length() ; i++ ){

                if( !stack.isEmpty() && str.charAt(i) == 'b' && stack.peek() == 'a' ){
                    total = x + total;
                    stack.pop();
                }
                else{
                    stack.push(str.charAt(i));
                }
            }
        }



        return total;
    }

    public static int maximumGain(String s, int x, int y ){

         int total = 0;
         if ( x < y ){
             for( int i=0 ; i<s.length(); i++ ){
                 if ( s.contains("ba") ){
                     total += y;
                     int index = s.indexOf( "ba" );
                     s = s.substring(0, index) + s.substring(index+2);
                 }
                 else if  ( s.contains("ab") ){
                     total += x;
                     int index = s.indexOf( "ab" );
                     s = s.substring(0, index) + s.substring(index+2);
                 }
             }
         }
         else{
             for( int i=0 ; i<s.length(); i++ ){
                 if ( s.contains("ab") ){
                     total += x;
                     int index = s.indexOf( "ab" );
                     s = s.substring(0, index) + s.substring(index+2);
                 }
                 else if  ( s.contains("ba") ){
                     total += y;
                     int index = s.indexOf( "ba" );
                     s = s.substring(0, index) + s.substring(index+2);
                 }
             }
         }
         return total;
    }
}
