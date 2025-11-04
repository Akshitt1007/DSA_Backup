package h_OOPS;

public class a1_Introduction {
    public static void main(String[] args) {

        // Store name of 5 students
        String[] name = new String[5];

        // Store roll_number of 5 student
        int[] roll_number = new int[5];

        // Store marks of 5 student
        float[] marks = new float[5];

        /*
        Now if we are creating marks, roll_number, name different
        If I want the name, roll number, and marks of a single student, I need to access all three arrays using the same index.
        That’s... error-prone, hard to maintain.

        Instead of having 3 arrays, create a Student class that holds:
        1) roll_number
        2) name
        3) marks

        Then create an array of Student objects. Clean, beautiful,
        */

        Student[] students = new Student[5];  // Declared array to hold 5 Student objects (references only for now)
        // But objects aren't created yet! All elements in 'students' are null initially.
        // We still need to assign each element a new Student object


        // -> How to create object:

        Student akshit ;    // Declared, not initialised  so its just is in the stack and not pointing to anything in the heap
        // 1. here 'Student' is like how we write String or any other object name.
        // 2. 'akshit' is the name of the reference variable

        akshit = new Student();     // This will create an object in the heap memory at the run time, And returns the address (reference) of that memory location.
        /*
                  Stack                              Heap
                 --------                     -----------------------
                | akshit | ----------------> | Student object        |
                |        |                   | age = 0               |
                |        |                   | grade = '\u0000'      |
                |        |                   | marks = 0.0           |
                |        |                   | name = null           |
                 --------                     -----------------------
        */
//        System.out.println( akshit );
        System.out.println( akshit.roll_number );
        System.out.println( akshit.name );
        System.out.println( akshit.marks );

        akshit.roll_number = 1769;
        akshit.name = "Akshit Choudhary";
        akshit.marks = 80;

        System.out.println( akshit.roll_number );
        System.out.println( akshit.name );
        System.out.println( akshit.marks );
        System.out.println( akshit.default_number);
            // For every instance variable, Java checks
            // Did the class define a default value? → Use it.
            // Otherwise, apply Java’s default primitive value.

    }
}

class Student{
        /*
            Class  -> A logical blueprint or template. It defines what an object should have (fields) and should do (methods).
            Object -> A real instance of a class. Memory is allocated only when you create an object using new.
         */

    int roll_number ;
    String name ;
    float marks ;
    int default_number = 10;

    // these are instance variable.
    // variable that are inside the object
}


