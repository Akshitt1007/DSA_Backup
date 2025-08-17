package h_OOPS.Generics;
import java.util.ArrayList;


/*
        Using raw ArrayList (❌ Not recommended)
        ArrayList list = new ArrayList();

    The above declaration creates a raw ArrayList,
    which means the list can accept any type of data:
        list.add("Hello");
        list.add(123);
        list.add(true);

    - While this may compile, it’s dangerous — because there's no type safety.
    - If we're expecting integers but someone sneaks in a string,
    - we only find out when the program crashes at runtime. ☠

    To solve this, Java introduced --> Generics <--

    With Generics:
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Character> list = new ArrayList<Character>();

    - Here this will ensure the user will enter only Integer datatype
    - and if the user puts any other than the mentioned datatype
    - it will give error during the compile time only instead of run time

 */
class Custom{
    private static int[] data;
/*
    Suppose we need a class that works with `String`, or `Character`, or even `Double` types.
    Without generics, we'd have to copy-paste the same class code and just change the type each time.

    For example:
        - One class for int[]
        - Another for String[]
        - Another for char[] ... and so on

    This leads to:
    - Code duplication
    - Maintenance nightmare
    - Lack of scalability
 */
    private static int default_size = 10;
    private static int size = 0;

    Custom( ){
        this.data = new int[ default_size ];
    }
    Custom( int size ){
        this.data = new int[ size ];
    }

    // To add new Element at the end
    public static void add( int num ){

        if ( isFull() ){
            resize();
        }
        data[size++] = num;
    }

    // To remove the element from end
    public static int remove(){
        int removed = data[--size];
        return removed;
    }

    // To get the value of specific index
    public static int get(int index){
        return data[index];
    }

    // To get the total length of ArrayList
    public static int size(){
        return size;
    }

    // Set the desired index with given value
    public static void set( int index, int value){
        data[index] = value;
    }

    // To display the entire List
    public static void display(){

        for( int i=0 ; i<size ; i++ ){
            System.out.print( data[i] + " ");
        }
        System.out.println();
    }

    // Method to double the size of List whenever it's gets full
    private static void resize(){
        int[] temp = new int[data.length * 2 ];

        for( int i=0 ; i<data.length ; i++ ){
            temp[i] = data[i];
        }
        data = temp;
    }

    // Tell whether the array is full or not
    private static boolean isFull(){

        if ( size == data.length ){
            return true;
        }
        else{
            return false;
        }
    }
}

public class a1_Custom_ArrayList {
    public static void main(String[] args) {

//        Custom list = new Custom();
//
//        list.add( 1 );
//        list.add( 2 );
//        list.add( 3 );
//        list.display();

        Custom list2 = new Custom(5);

        list2.add( 1 );
        list2.add( 2 );
        list2.add( 3 );
        list2.add( 4 );
        list2.add( 5 );
        list2.display();

        System.out.println( list2.remove() );
        list2.display();
    }
}
