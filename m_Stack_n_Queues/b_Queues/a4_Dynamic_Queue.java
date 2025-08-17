package m_Stack_n_Queues.b_Queues;


class Dynamic_Queue extends CircularQueue{

    public Dynamic_Queue(){
        this( DEFAULT_SIZE );
    }
    public Dynamic_Queue( int size ){
        super(size);
    }

    @Override
    public void push( int num ){

        // same as Dynamic Stack
        if( isFull() ){
            // Stack is full → time to grow
            System.out.println( "More Space Added");
            int[] temp = new int[ data.length * 2];

            // Copy existing elements to the new array
            for( int i=0 ; i<data.length ; i++ ) {
                temp[i] = data[ ( start + i) % data.length ];
            }

            start = 0;
            end = data.length;
            // Assign new array as the main stack storage
            data = temp;
        }

        // At this point, we know the array has space
        // Proceed with regular push
        super.push(num);
    }
}

public class a4_Dynamic_Queue {
    public static void main(String[] args) {

        Dynamic_Queue queue = new Dynamic_Queue(3);

        queue.push(10);
        queue.push(20);
        queue.push(30);

        // At this point, queue is full. Next push should trigger resize
        queue.push(40); // Should print "More Space Added"

        // You can add more to test
        queue.push(50);
        queue.push(60);

        // Optionally display to verify
        queue.display(); // Implement display() in Custom_Queue
    }
}
