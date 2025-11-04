package h_OOPS.Generics;
import java.util.List;

public class a3_Generic_List<T extends Number > {

    private  Object[] data;
    private int default_size = 10;
    private int size = 0;

    a3_Generic_List( ){
        this.data = new Object[ default_size ];
    }
    a3_Generic_List( int size ){
        this.data = new Object[ size ];
    }

    public void getList( List<Number> list ){
        // Here we can only pass Number type
        // not even the Subclass of Number type
    }
    public void getListII( List<? extends Number> list ){
        // Here we can  pass Number type
        // also the Subclass of Number type
    }

    // To add new Element at the end
    public void add( int num ){

        if ( isFull() ){
            resize();
        }
        data[size++] = num;
    }

    // To remove the element from end
    public T remove(){
        T removed = (T)(data[--size]);
        return (T)(removed);
    }

    // To get the value of specific index
    public T get(int index){
        return (T)(data[index]);
    }

    // To get the total length of ArrayList
    public int size(){
        return size;
    }

    // Set the desired index with given value
    public void set( int index, int value){
        data[index] = value;
    }

    // To display the entire List
    public void display(){

        for( int i=0 ; i<size ; i++ ){
            System.out.print( data[i] + " ");
        }
        System.out.println();
    }

    // Method to double the size of List whenever it's gets full
    private void resize(){
        Object[] temp = new Object[data.length * 2 ];

        for( int i=0 ; i<data.length ; i++ ){
            temp[i] = data[i];
        }
        data = temp;
    }

    // Tell whether the array is full or not
    private boolean isFull(){

        if ( size == data.length ){
            return true;
        }
        else{
            return false;
        }
    }
}

