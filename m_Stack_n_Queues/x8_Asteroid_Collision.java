package m_Stack_n_Queues;

import java.util.Stack;

// 735. Asteroid Collision
// https://leetcode.com/problems/asteroid-collision/description/
public class x8_Asteroid_Collision {
    public static void main(String[] args) {

    }

    public static int[] asteroidCollision(int[] asteroids) {
        if( asteroids.length == 0 ){
            return new int[0];
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {
            int current = asteroids[i];
            boolean destroyed = false;

            while (!stack.isEmpty() && current < 0 && stack.peek() > 0) {
                int top = stack.peek();

                if (top > -current) {
                    destroyed = true;
                    break;
                }
                else if (top < -current) {
                    stack.pop();
                }
                else {
                    stack.pop();
                    destroyed = true;
                    break;
                }
            }

            if (destroyed == false ) {
                stack.push(current);
            }
        }

        int[] result = new int[stack.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = stack.get(i);
        }

        return result;
    }
}
