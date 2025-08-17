package m_Stack_n_Queues.a_Stack;

class Custom_Stack{
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    protected int i = -1;
    // i = -1 means empty stack;

    // 1. If no size given we will assume the size ourselves, that is 10 here.
    public Custom_Stack( ){
        this(DEFAULT_SIZE);
        // This will call the constructor which will be taking a single int datatype

//        this.data = new int[ DEFAULT_SIZE ];
    }

    // 2. If size given, then  array of that size will be created
    public Custom_Stack( int size ){
        this.data = new int[ size ];
    }

    // 3. To Check whether the Stack is full or not
    public boolean isFull() {
        return i == data.length - 1;
    }

    // 4. To Check whether the Stack is empty or not
    public boolean isEmpty() {
        return i == -1;
    }
//    public void isEmpty(){
//        if( i == -1 ){
//            System.out.println( "Stack is empty");
//        }
//        else {
//            System.out.println( "Stack is not empty.");
//        }
//    }

    // 5. to add element at the last
    public void push(int num) {
        if (i == data.length - 1) {
            System.out.println("Stack is full");
            return;
        }
        data[++i] = num;
    }

    // 6. to return and remove the element from the last
    public int pop() {
        if (i == -1) {
            System.out.println("Stack is empty");
            return -1;
        }
        int removed = data[i];
        data[i] = 0;
        i--;
        return removed;
    }

    // 7. to return the element from the last
    public int peek() {
        if (i == -1) {
            System.out.println("Stack is empty");
            return -1;
        }
        return data[i];
    }

    // 8. to display the element of the stack
    public void displayStack() {
        if (i == -1) {
            System.out.println("Stack is empty");
            return;
        }

        for (int j = 0; j <= i; j++) {
            System.out.print(data[j] + " ");
        }
        System.out.println();
    }
}

public class a2_Custom_Stack {
    public static void main(String[] args) {

        Custom_Stack stack = new Custom_Stack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        stack.displayStack();

        System.out.println("Top element is: " + stack.peek());

        System.out.println( "Element removed is: " + stack.pop() );
        System.out.println( "Element removed is: " + stack.pop() );
        System.out.println( "Element removed is: " + stack.pop() );
        System.out.println( "Element removed is: " + stack.pop() );
        System.out.println( "Element removed is: " + stack.pop() );

        stack.displayStack();

    }
}
