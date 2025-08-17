package h_OOPS.Polymorphism;

public class c1_Compile_time_Polymorphism {
    public static void main(String[] args) {

        object x = new object();

        x.sum( 1, 2 );

        x.sum( 1, 2, 3 );

        // both of the above will work
        // but the decision which method to call is made during compilation.

        /*
            Quick characteristics:
                1. Based on method signature (name + parameters).
                2. Return type can differ, but overload resolution is not based on return type.
                3. Happens within the same class or inherited class.
         */

//        x.sum( 1, 2, 3 ,4 );
        // This will give error because there is no method in class which take 4 arguments
    }
}

class object{

    public int sum ( int a, int b){
        return a+b;
    }

    public int sum ( int a, int b, int c ){
        return a+b+c;
    }
}
