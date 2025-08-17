package m_Stack_n_Queues;

import java.util.Stack;

//150. Evaluate Reverse Polish Notation
//https://leetcode.com/problems/evaluate-reverse-polish-notation/description/

public class x9_Evaluate_Reverse_Polish_Notation {
    public static void main(String[] args) {

        String[] tokenI = { "2","1","+","3","*" };
        String[] tokenII = { "4","13","5","/","+" };

        System.out.println( evalRPN( tokenI ) );
        System.out.println( evalRPN( tokenII ) );
    }


    public static int evalRPN(String[] tokens) {

        Stack<String> stack = new Stack<>();

        for ( int i = 0; i < tokens.length; i++ ){
            String token = tokens[i];

            if ( !token.equals("+") && !token.equals("-") && !token.equals("*") && !token.equals("/") ){
                stack.push(token);
            }
            else {

                int b = Integer.parseInt( stack.pop() );
                int a = Integer.parseInt( stack.pop() );

                int result = 0;

                if ( token.equals("+") ){
                    result = a + b;
                }
                else if (token.equals("-") ){
                    result = a - b;
                }
                else if (token.equals("*") ){
                    result = a * b;
                }
                else if (token.equals("/") ){
                    result = a / b;
                }

                stack.push( result + "" );
            }
        }
        return Integer.parseInt(stack.pop());
    }

}