package m_Stack_n_Queues.b_Queues;

class CircularQueue{

    protected int[] data;
    protected static final int DEFAULT_SIZE = 10;
    protected int start = 0;
    protected int end = 0;
    private int size = 0;

    public CircularQueue(){
        this( DEFAULT_SIZE );
    }

    public CircularQueue( int size ){
        this.data = new int[size];
    }

    // 1. To check if the Queue is empty or not
    public boolean isEmpty(){
        return size == 0;
    }

    // 2. To check if the Queue is full or not
    public boolean isFull(){
        return size == data.length;
    }

    // 3. To check if the Queue is full or not
    public int peek(){
        if( isEmpty() ){
            System.out.println( "Queue is empty");
            return -1;
        }
        return data[start];
    }

    // 4. Insert at the top of queue
    public void push( int item ){
        if( isFull() ){
            System.out.println( "Queue is full");
            return;
        }
        data[end++] = item;
        end = end % data.length;
        size++;
    }

    // 5. Insert at the top of queue
    public int remove( ){
        if( isEmpty() ){
            System.out.println( "Queue is empty");
            return -1;
        }
        int removed = data[start];

        start++;
        start = start % data.length;
        size--;

        return removed;
    }

    // 6. Display the entire queue
    public void display(){
        if( isEmpty() ){
            System.out.println( "Queue is empty");
            return;
        }

        int ptr = start;
        do{
            System.out.print( data[ptr] + " ");
            ptr++;
            ptr = ptr % data.length;
        }
        while ( ptr != end );

        System.out.println();
    }
}
public class a3_Circular_Queue {
    public static void main(String[] args) {

        CircularQueue queue = new CircularQueue(5);
        queue.push(3);
        queue.push(6);
        queue.push(5);
        queue.push(19);
        queue.push(1);

        queue.display();

        System.out.println(queue.remove());
        queue.push(133);
        queue.display();

        System.out.println(queue.remove());
        queue.push(99);
        queue.display();
    }
}
