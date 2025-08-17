package b_Functions;

public class b3_Swapping {
    public static void main(String[] args){

        int a = 10;
        int b = 20 ;

//        System.out.println(a + " " + b);
//        int c = b;
//        b = a;
//        a = c ;
//        System.out.println(a + " " + b);

        System.out.println(a + " " + b);
        swap( a , b);
        System.out.println(a + " " + b);

        String name = "Akshit";
        change(name);
        System.out.println(name);

    }

    static void swap(int a , int b){
        int temp = b;
        b = a;
        a = temp ;
    }

    static void change(String naam){
        naam = "Abhinav";
    }
}
/*
    Step 1:

    A String object with the value "Akshit" is created and stored in the heap memory.
    The variable name in the main method holds a reference (address) to this "Akshit" object.

    Step 2:

    The change method is called with name as an argument.
    Inside the change method, the parameter naam is initialized with the same reference as name.
    At this point, both name (in main) and naam (in change) point to the same "Akshit" object in memory.

    Step 3:

    When naam = "Abhinav"; is executed:
    A new String object with the value "Abhinav" is created in the heap memory.
    the variable naam is now updated to point to this new "Abhinav" object.
    The original name in the main method still points to "Akshit". It is unaffected because strings in Java are immutable and the reference naam is a
    local copy.

    Step 4:

    When System.out.println(name); is executed:
    The value of name is printed, which is still "Akshit", because the assignment naam = "Abhinav"; in the change method only modified
    the local reference naam and not the original reference name.
 */
