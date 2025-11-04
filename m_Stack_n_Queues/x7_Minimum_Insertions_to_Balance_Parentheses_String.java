package m_Stack_n_Queues;

// 1541. Minimum Insertions to Balance a Parentheses String
// https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/description/

import java.util.Stack;

public class x7_Minimum_Insertions_to_Balance_Parentheses_String {
    public static void main(String[] args) {


        System.out.println( minInsertions( "))())(") );
        System.out.println( minInsertions( "(()))") );
    }


    public static int minInsertions(String s) {

        Stack<Character> stack = new Stack<>();
        int insertions = 0;
        int i = 0;

        while (i < s.length()) {
            char ch = s.charAt(i);

            if (ch == '(') {
                stack.push('(');
                i++;
            }
            else {
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                    else {
                        insertions++;
                    }
                    i += 2;
                }
                else {
                    if (!stack.isEmpty()) {
                        stack.pop();
                        insertions++;
                    }
                    else {
                        insertions += 2;
                    }
                    i += 1;
                }
            }
        }

        insertions += stack.size() * 2;

        return insertions;
    }
}
