package m_Stack_n_Queues.a_Stack;

class  Dynamic_Custom_Stack extends Custom_Stack {

    public Dynamic_Custom_Stack() {
        super();
        // This will call the constructor in Custom_Stack which would be taking no size (ie DEFAULT_SIZE)
    }

    public Dynamic_Custom_Stack( int size ){
        super(size);
        // This will call the constructor in Custom_Stack which would be taking given size
    }
/*
    ========================== Dynamic Stack ==========================

    In a dynamic stack, all operations like pop, peek, and display
    remain the same as in a static (fixed-size) stack.

    However, the push operation is different:
    - In a normal stack, pushing into a full stack results in an overflow error.
    - But in a dynamic stack, there's no need to worry about fixed capacity.

    When the internal array becomes full:
    - A new array (twice the size of the original) is created.
    - All existing elements are copied to this new array.
    - The push operation then proceeds as usual.

    This allows the stack to grow dynamically at runtime — similar to how
    ArrayList or Vector work internally in Java.
 */

    @Override
    public void push(int num) {
        if (i == data.length - 1) {
            // Stack is full → time to grow
            System.out.println( "More Space Added");
            int[] temp = new int[data.length * 2];

            // Copy existing elements to the new array
            for (int j = 0; j < data.length; j++) {
                temp[j] = data[j];
            }

            // Assign new array as the main stack storage
            data = temp;
        }

        // At this point, we know the array has space
        // Proceed with regular push
        super.push(num);
    }
}

public class a3_Dynamic_Stack {
    public static void main(String[] args) {

        Dynamic_Custom_Stack stack = new Dynamic_Custom_Stack(3);

        stack.push(1);
        stack.push(2);
        stack.push(3);

        stack.displayStack();

        stack.push(4);
        stack.push(5);
//        stack.push(6);

        stack.displayStack();

    }
}
