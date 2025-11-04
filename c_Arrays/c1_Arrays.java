package c_Arrays;

public class c1_Arrays {
    public static void main(String[] args) {

        int roll_no1 = 10 ;
        int roll_no2 = 11 ;
        int roll_no3 = 12 ;


        /*
        Why need an Array?

        When dealing with large datasets (e.g., storing roll numbers for 50 or more students), manually declaring individual variables
        for each value is inefficient, error-prone, and difficult to maintain. Instead, an array allows us to group all the related data into a single variable.
        This makes the code more readable, manageable, and less repetitive.

        That's why we have Array. Arrays in Java are essential because they provide a way to store multiple values in a single variable
        Instead of declaring multiple variables for related data (e.g., multiple integers or strings), you can use an array to store them together,
        which simplifies your code and makes it easier to manage.

        int [] array_roll_no = { 10 , 11 , 12 ....... 50 }
            here ' array_roll_no ' is a single variable in which we can store any amount of same datatype together rather than initialization differently.
         */

        int [] roll_number = { 10, 11 , 12 } ;

        /*
        Syntax:

        datatype [] variable_name = new datatype [ size of array ]
        or
        datatype [] variable name = { } ; directly initialising with values

        1. **Declaration**: The first part is where you declare an array, which includes the data type of the array and the array's name. This just defines the reference but does not allocate memory for the elements.
                            Example:
                            int[] array; – This declares an array of integers named `array`.

        2. **Initialization**: This part creates the array object and assigns it memory (in the heap), either by specifying the size or by directly providing values.
                               Example:
                               array = new int[10]; – This creates an array of integers with 10 elements.

        ex : int [] array = new int [10]
                here;
                    int -> is the types of datatype we want to store the values in it

                    array -> is the name of given to this variable => reference variable pointing towards the object of array where we are storing data

                    new -> is used to allocate memory for the array on the heap, not the stack. In Java, arrays are objects,
                           and the object (array) itself is created in the heap.

                    [10] -> is this size of array of how much we want to store our data in it

                    so 'array' is a reference variable that is pointing to an array object of datatype 'int' elements
         */

        /*
            int[] name ; -> declaration of array. Here 'name' os getting declared in stack memory
            name = new [ 10 ] ; -> initialisation. Here actually the object is created of 'name' in the heap memory

            Here the memory location array elements may or may not be contiguous in heap memory .
            since this creation of object happens in run time and all this comes under the jvm
            so unlike in c/c++ in Java this depends on the jvm on how it would be storing it .

            1) In most JVMs, arrays are stored contiguously.
            2) The JLS allows for some flexibility in memory layout, so it's possible that in some specialized JVM implementations,
               arrays might not be contiguous.
            3) For everyday Java programming, you can rely on arrays being contiguous in memory unless you're dealing with very
               specific JVM configurations or optimizations.

         */
        /*
            Accessing the Array:

            int[] array = { 10 , 33 , 83 , 2 }
                            0    1    2    3

                            by array[0] => will give the value index at 0 ie 10
                            by array[3] => 2
         */

        int [] array = new int [10];
        System.out.println( array[0] + " " + array[1] );  // if we don't pass any value it will automatically assign it with 0 value rather than giving garbage value

        int [] int_array = {1, 2, 3, 4, 5};
        System.out.println( int_array[0] + " " + int_array[1] );

        String [] sstring = new String[10];
        System.out.println( sstring[0] + " " + sstring[1] ); // it would give 'null' value in case of String

        // It's a special literal indicating for no object

        String [] String_array = {"Akshit" , " Abhinav"};
        System.out.println( String_array[0] + " " + String_array[1] );

        /*

        String [] String_array = new String [5];

        1) Internally this string_array would a reference variable that would be pointing towards the object created for this string array of size 5 in heap memory
           since this string is also made up of char element

        2) In the string array each element in the array would also be a reference variable pointing towards more objects in heap

        3) Since we have to not initialised it with any string value therefore in the String_array it would not point to any object
           that's why it would contain 'null' because of not reference variable

        4) If String_array[0] = "Akshit"
           [ "Akshit" , null, null, null, null]
           and this String_array[0] = "Akshit" would also point to another object created to store the "Akshit" in it

         */
    }
}
