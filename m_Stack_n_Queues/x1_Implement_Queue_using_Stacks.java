package m_Stack_n_Queues;

// https://leetcode.com/problems/implement-queue-using-stacks/description/
// Number: 232

import java.util.Stack;

class MyQueue {
    private Stack<Integer> first;
    private Stack<Integer> second;

    public MyQueue() {
        first = new Stack<>();
        second = new Stack<>();
    }

    public void push(int x) {
        first.push(x);
    }

    public int pop() throws Exception {

        while( !first.empty() ){
            second.push( first.pop() );
        }

        int removed = second.pop();

        while( !second.empty() ){
            first.push( second.pop() );
        }

        return removed;
    }

    public int peek() throws Exception {
        while( !first.empty() ){
            second.push( first.pop() );
        }

        int peeked = second.peek();

        while( !second.empty() ){
            first.push( second.pop() );
        }

        return peeked;
    }

    public boolean empty() {
        return first.isEmpty();
        // isEmpty() -> is already a method for stack
    }
}

public class x1_Implement_Queue_using_Stacks {
    public static void main(String[] args) throws Exception {
        MyQueue queue = new MyQueue();

        // Pushing elements
        queue.push(10);
        queue.push(20);
        queue.push(30);

        // Should print 10 (FIFO behavior)
        System.out.println("Peek: " + queue.peek());

        // Should remove 10
        System.out.println("Pop: " + queue.pop());

        // Should print 20 now (next in queue)
        System.out.println("Peek: " + queue.peek());

        // Empty check
        System.out.println("Is empty? " + queue.empty());

        // Remove remaining
        System.out.println("Pop: " + queue.pop());
        System.out.println("Pop: " + queue.pop());

        // Now queue should be empty
        System.out.println("Is empty? " + queue.empty());
    }
}
