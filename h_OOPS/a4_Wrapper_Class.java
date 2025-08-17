package h_OOPS;

public class a4_Wrapper_Class {

    static void swap( int a , int b ){
        int temp = b;
        b = a;
        a = temp;
        System.out.println( "Method:" + a + " " + b );
    }

    static void swapII(Integer a, Integer b){
        Integer temp = b;
        b = a;
        a = temp;
        System.out.println( "Method:" + a + " " + b );
    }

    public static void main(String[] args) {

        // Primitive types like int are stored in the stack and passed by value,
        // meaning a copy of the actual value is sent to the method.
        int a = 10;
        int b = 20;
        // This will not swap the original a and b, only the local copies inside swap()
        swap( a, b );
        System.out.println( "Main: " + a + " " + b );


        // Integer is an object (wrapper class) stored in heap memory.
        // But when passed, Java still passes the reference by value — a copy of the reference.
        Integer num1 = 30;
        Integer num2 = 40;
            // Why?
            // Because the Integer object have "final" keyword with it which prevent it from modifying it
            // this make the object info final and not changeable
        swapII ( num1, num2 );
        System.out.println( "Main: " + num1 + " " + num2 );


        // This thing can only be assigned once. After that, no changing, no reassigning
        final int x = 10;
        // x = 20;                          // ❌ ERROR! Once assigned, can't change.
        // final primitive = must be initialized, and can't be changed after

        System.out.println();
        A object = new A();

        System.out.println(object.a);       // prints 10
        object.a = 20;                      // allowed because 'a' is not final
        System.out.println(object.a);       // prints 20

        System.out.println(object.b);       // prints 69
        // object.b = 0;                    // ❌ Not allowed. 'b' is final, can't be reassigned
        // System.out.println(object.b);    // only if not trying to reassign





        System.out.println();
        final B obj = new B("Akshit Choudhary ");                    // Reference is now locked

        System.out.println( obj.name );         // prints xyz
        obj.name = "Akshit ";                   // allowed, name is not final
        System.out.println( obj.name );         // prints akshit

        // ❌ Not allowed: once a reference is final, it can't point to a new object
        // obj = new B( " Abhinav Choudhary");
    }
}

class A {

    int a = 10;
    final int b = 69;
}

// Since the class is final we cannot extend it further classes
final class B{

    String name = "xyz";
    String name2;
    int y = 20;

    B( String name ){
        this.name2 = name;
    }
}
