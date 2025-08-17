package m_Stack_n_Queues;


// 921. Minimum Add to Make Parentheses Valid
// https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/description/

import java.util.Stack;

public class x6_Minimum_Add_to_Make_Parentheses_Valid {
    public static void main(String[] args) {

        System.out.println( minAddToMakeValid( "())" ));
        System.out.println( minAddToMakeValid( "(((" ));

        System.out.println( minAddToMakeValid_Optimized( "())" ));
        System.out.println( minAddToMakeValid_Optimized( "(((" ));

    }

    public static int minAddToMakeValid_Optimized( String s ){
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if( !stack.isEmpty() && ch == ')' && stack.peek() == '(' ){
                stack.pop();
            }
            else{
                stack.push( ch );
            }
        }

        return stack.size();
    }

    public static int minAddToMakeValid(String s) {

        Stack<Character> stk = new Stack<>();

        for( int i=0 ; i<s.length(); i++ ) {
            char curr = s.charAt(i);

            if (!stk.isEmpty()) {
                char top = stk.peek();

                if ((curr == ')' && top == '(') ) {
                    stk.pop();
                }
                else {
                    stk.push(curr);
                }
            }
            else{
                stk.push( curr );
            }
        }

        int n = stk.size();

        if( n == 0){
            return 0;
        }
        else{
            return n;
        }
    }
}
