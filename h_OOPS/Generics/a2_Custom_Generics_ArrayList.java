package h_OOPS.Generics;

//  - **JAVA WILDCARDS**
//  - here T should be a Number or a subclass of a Number
//class Generic_ArrayList<T extends Number>

//  - T can only be a subtype of Number — meaning it must be Number itself or one of its subclasses (Integer, Double, Float, Long, Short, Byte, BigDecimal, etc.).
//  -  You cannot use String, Object, or any type not inheriting from Number.

class Generic_ArrayList<T> {

//    private static T[] data;
//    - Generics cannot be static
//    - Because Java generics are erased at runtime, and static fields belong to the class, not the instance — those two things don’t mix

    /*
        What are Generics?

            Generics in Java allow us to create classes, methods, and collections that work with a specific type without losing type safety.
            They ensure that we catch type errors at compile time rather than runtime.

        Example:
            List<String> list = new ArrayList<>();
            list.add("Akshit");                                         // OK
            list.add(42);                                               // Compile-time error

        Without generics (pre-Java 5):
            List list = new ArrayList();
            list.add("Akshit");
            list.add(42);                                               // Allowed — dangerous
            String s = (String) list.get(1);                            // Runtime ClassCastException

        Why We Need Generics:

            - Catch type errors early (compile time)
            - Remove the need for unsafe casts
            - Improve code readability and documentation
            - Allow flexible, reusable code without losing type safety
     */
    /*
        Type Erasure:

            Type erasure is the process where Java removes generic type information during compilation.
            Generics exist only at compile time for type checking; at runtime, they are replaced with their upper bound (usually Object).

        Step-by-step:

        1. Compile-time type check:
            The compiler verifies that generic type constraints are met.
            Example:
                List<Integer> list = new ArrayList<>();
                list.add(10);                                            // OK
                list.add("Hello");                                       // Compile error

        2. Erasure phase:
            After checks pass, type parameters are removed.
            Example:
                List<Integer> list = new ArrayList<>();
            becomes in bytecode:
                List list = new ArrayList();

        3. The compiler inserts casts automatically when retrieving elements.

        Proof:
            List<String> a = new ArrayList<>();
            List<Integer> b = new ArrayList<>();
            System.out.println(a.getClass() == b.getClass());           // true
     */
    /*
                                    "generics incur no runtime overhead"

                        After compilation, generic code runs just as fast as if you had written it without generics,
                        because the JVM isn’t actually doing anything special for generics at runtime.

        Because of type erasure:
            - Generics are only used at compile time to check types and insert casts.
            - At runtime, the compiled code is just normal, non-generic code — the JVM doesn’t store extra type information or
              create separate copies for each type parameter.
            - So no extra memory, no extra CPU work is spent on managing generics during execution.

     */

//    private T[] data;
    private Object[] data;
    private int default_size = 10;
    private int size = 0;

//    Generic_ArrayList( ){
//        this.data = new T[ default_size ];
//    }
//    Generic_ArrayList( int size ){
//        this.data = new T[ size ];
//    }
    /*
        this.data = new T[default_size];  -> causes a compile-time error because of **type erasure**.

        Why?
        - Generics in Java only exist at *compile time* for type checking.
        - After type erasure, the compiler replaces T with its upper bound
          (often Object if not specified).
        - At runtime, the actual type of T is unknown to the JVM.
        - Array creation in Java requires a *real, concrete type* at runtime
          (e.g., new Integer[10], new String[10]), not an erased placeholder.

        So when the compiler tries to generate bytecode for `new T[...]`, it has
        no concrete type information for T — and therefore refuses to compile.
     */

    Generic_ArrayList( ){
        this.data = new Object[ default_size ];
    }
    Generic_ArrayList( int size ){
        this.data = new Object[ size ];
    }
    /*
        Why we can do

        this.data = new Object[default_size];
            - Because Object is a real, concrete class that exists at runtime.
            - When we make an array of Object, Java knows exactly what type to create in memory.

        How this works with generics in your Generic_ArrayList<T>
            - Internally, we store everything as Object[].
            - When adding elements, the compiler checks that only T types are passed.
            - When retrieving, we cast from Object to T automatically (type-safe at compile time).
     */
    /*
        Generics & Type Erasure – Key Points

        1. Compile-time checks
            - Generics provide type safety at compile time.
            - Compiler ensures only the correct type can be added.

        2. Type Erasure
            - After compilation, T is replaced with Object (or the bounded type).
            - Generic_ArrayList<T> becomes something like:

                        class Generic_ArrayList {
                            private Object[] data;
                        }

        3. Runtime behavior
            - At runtime, generics information is gone.
            - JVM only stores objects in an Object[].
            - Type correctness is assumed because compile-time checks already passed.
     */

//     To add new Element at the end
    public void add( T num ){

        if ( isFull() ){
            resize();
        }
        data[size++] = num;
    }

    // To remove the element from end
    public T remove(){
        T removed = (T)(data[--size]);
        return removed;
    }

    // To get the value of specific index
    public T get(int index){
        return (T)(data[index]);
    }

    // To get the total length of ArrayList
    public  int size(){
        return size;
    }

    // Set the desired index with given value
    public void set( int index, T value){
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

public class a2_Custom_Generics_ArrayList {
    public static void main(String[] args) {
         Generic_ArrayList<String> stringList = new Generic_ArrayList<>();

         stringList.add("Akshit");
         stringList.add("Aryan");
         stringList.add("Adwit");

         Generic_ArrayList<Integer> intList = new Generic_ArrayList<>();

        intList.add(1);
        intList.add(2);
        intList.add(3);

        intList.display();
        stringList.display();
    }
}
