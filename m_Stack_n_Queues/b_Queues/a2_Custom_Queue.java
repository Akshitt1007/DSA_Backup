package m_Stack_n_Queues.b_Queues;

class Custom_Queue{
    protected int[]data;
    protected static final int DEFAULT_SIZE=10;
    protected int end = 0;

    public Custom_Queue(){
        this( DEFAULT_SIZE );
    }
    public Custom_Queue( int size ){
        this.data = new int[size];
    }

    // 1. To check whether the queue is empty or not
    public boolean isEmpty(){
        if( end == 0 ){
            return true;
        }
        else{
            return false;
        }
//        return end == 0;
    }

    // 2. To check whether the queue is full or not
    public boolean isFull(){
        if( end == data.length ){
            return true;
        }
        else{
            return false;
        }
//        return end == data.length;
    }

    // 3. Adds the items at the end of queue
    public void push( int num ){
        if( isFull() ){
            System.out.println( "Queue is full ");
            return;
        }
        data[end++] = num;
    }

    // 4. Removes the first item from the queue
    public int pop(){
        if ( isEmpty() ) {
            System.out.println("Queue is empty");
            return -1;
        }
        int removed = data[0];

        // Shifting the element left side
        for( int i=1; i < end; i++ ){
            data[i-1] = data[i];
        }
        end--;
        /*
            This will be having complexity of O(n)
            which is okay but not good
            to overcome this we will use - circular Queue
         */

        return removed;
    }

    // 5. To return the first item of the queue
    public int peek(){
        if( isEmpty() ){
            System.out.println( "Queue is empty");
            return -1;
        }

        return data[0];
    }

    // 6. T0 display all the element of the queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.print("Queue: ");
        for (int i = 0; i < end; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }
}

public class a2_Custom_Queue {
    public static void main(String[] args) {

        Custom_Queue queue = new Custom_Queue(5);

        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);

        System.out.println( queue.isFull() );

        queue.push(5);
        System.out.println( queue.isFull() );

        queue.display();

        System.out.println( queue.peek() );

        System.out.println( queue.pop() );

        queue.display();

        queue.pop();
        queue.pop();
        queue.pop();
        queue.pop();

        System.out.println( queue.isEmpty() );
    }
}
