package b_Functions;

import java.util.Arrays;

public class b8_Function_Overloading {

    public static void main(String[] args){

        //overload();
        //overload();
        // If we don't pass any variable the compiler won't be able to differentiate which function to run
        //This is because overloaded methods are differentiated based on their method signature (method name + parameters),
        // and if there are no parameters, the method signatures become identical.
        // and will give error

        overload(69);
        overload(96 , 429);
        overload("Akshit Choudhary");

        demo(1,2,3);
        demo("Akshit","Abhinav","Aryan");

    }

    static void overload(int a){
        System.out.println(a);
    }
    static void overload(int a , int b){
        System.out.println(a + " " + b);
    }
    // Different number of parameters

    static void overload(String name){
        System.out.println(name);
    }
    // Different parameters

    static void overload(String name , int a){
    }
    static void overload(int a, String name){
    }
    // Different order

    static void demo(int ...v) {
        System.out.println(Arrays.toString(v));
    }
    static void demo(String ...v) {
        System.out.println(Arrays.toString(v));
    }
    // Different Variable Argument

    /*
    Function Overloading ?

    Function overloading in Java occurs when we create more than one function
    with the same name in the same class, but they differ in their:
    1. Number of parameters
    2. Type of parameters
    3. Order of parameters

    Function overloading allows us to define multiple methods that perform similar tasks
    but with different input arguments. It helps in improving code readability and reusability.

    Key Points:
    - The function name must be the same.
    - The parameter list (method signature) must differ.
    - Return type alone cannot differentiate overloaded functions.
*/
}
