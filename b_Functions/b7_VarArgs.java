package b_Functions;

import java.util.Arrays;

/*
    In Java, we use Variable Arguments (varargs) when we don't know how many arguments
    we are going to pass to a function.

    Varargs allow us to pass a variable number of parameters into a function,
    and all the values provided are automatically stored in an array.

    Syntax:
    - For integers: int ...name
    - For Strings: String ...name

    Inside the function, the variable arguments behave like a normal array,
    allowing you to iterate over them or perform array operations.
 */

public class b7_VarArgs {
    public static void main(String[] args) {

        fun(1,2,3,4,5);
        multiple(2, 3, "Akshit", "Abhinav", "choudhary");

    }


    // Here the 2 and 3 will be in int a and int b and all the String passed would be in the varargs String V
    static void multiple(int a, int b, String ...v) {
        System.out.println(a + " " + b + Arrays.toString(v));
    }

    /*

    static void multiple( int a, String ...v, int b) {
    }

        Why does String... need to be at the end ?

        1) Variable arguments (varargs) must always be the last parameter in the method declaration.
        2) This ensures the compiler can differentiate between fixed arguments and the variable arguments.
        3) If String... v were placed before int b (e.g., multiple(int a, String... v, int b)), Java wouldn't know
           when the String... v ends and int b begins, causing ambiguity.
     */

    static void fun(int ...v) {
        System.out.println(Arrays.toString(v));
    }
}