package m_Stack_n_Queues;

import java.util.Stack;

// 20. Valid Parentheses
// https://leetcode.com/problems/valid-parentheses/submissions/
public class x5_Valid_Parenthesis {
    public static void main(String[] args) {

//        System.out.println( check_BruteForce( "()[]{}" ) );
//        System.out.println( check_BruteForce( "([)]" ) );
//        System.out.println( check_BruteForce( "[]{}" ) );
//        System.out.println( check_BruteForce( "(([])") );
//        System.out.println( check_BruteForce( "(){}}{") );
//
        System.out.println( check_Optimized( "()[]{}" ) );
        System.out.println( check_Optimized( "([)]" ) );
        System.out.println( check_Optimized( "[]{}" ) );
        System.out.println( check_Optimized( "(([])") );
        System.out.println( check_Optimized( "(){}}{") );
    }

    public static boolean check_Optimized( String s ){
        Stack<Character> stack = new Stack<>();

        /*
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
        char ch = chars[i];
         */
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (ch == ')') {
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                }
                if (ch == '}') {
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                }
                if (ch == ']') {
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    public static boolean check_BruteForce( String s ){

        if (s == null || s.length() == 0) {
            return false;
        }

        Stack<Character> stk = new Stack<>();

        for( int i=0 ; i<s.length(); i++ ) {
            char curr = s.charAt(i);

            if (!stk.isEmpty()) {
                char top = stk.peek();

                if ((curr == ')' && top == '(') || (curr == ']' && top == '[') || (curr == '}' && top == '{')) {
                    stk.pop();
                } else {
                    stk.push(curr);
                }
            }
            else{
                stk.push( curr );
            }
        }

//        if( stk.isEmpty() ){
//            return true;
//        }
//        else{
//            return false;
//        }
        return stk.isEmpty();
    }
}
