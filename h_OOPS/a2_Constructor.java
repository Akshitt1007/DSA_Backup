package h_OOPS;

public class a2_Constructor {
    public static void
    main(String[] args) {

        Student akshit;
        akshit = new Student();

        // In this case the java is automatically creating default constructor
        akshit.roll_number = 1769;
        akshit.name = "Akshit Choudhary";
        akshit.marks = 80;
        // Instead of doing above things we will be assigning the value in step

        Student_detail Akshit = new Student_detail();
        // This Student_detail is a function that binds this info with the instance variable in object...
        // for this we have to create a constructor.
        // Constructor: it is a special type of function that runs when you create an object and, it allocates some variables

        System.out.println( Akshit.roll_number );
        System.out.println( Akshit.name );
        System.out.println( Akshit.marks );

        Akshit.greeting();
        /*
            Here's what happens when Akshit.greeting() is called:

            1. The method call goes to the object referenced by 'Akshit'.
            2. Inside the 'greeting()' method, 'this.name' refers to Akshit.name.
            3. Since the constructor already set this.name = "Akshit Choudhary",
               the output becomes: "Hello everyone my name is Akshit Choudhary".
            4. So effectively, 'this' acts as a placeholder for the current object.
               At runtime, it becomes the actual object (in this case, Akshit).
        */

        System.out.println();
        Student_detail Rahul = new Student_detail();
        System.out.println( Rahul.roll_number );
        System.out.println( Rahul.name );
        System.out.println( Rahul.marks );
        /*
            Even though we created a new object named 'Rahul',
            the details printed are the same as Akshit.

            Why?
            Because the constructor of 'Student_detail' assigns hardcoded values to roll_number, name, and marks.

            So every time we create a new object using this constructor,
            it will always assign:
                roll_number = 1769
                name = "Akshit Choudhary"
                marks = 90

            That's why Rahul and Akshit end up being academic twins in memory.
        */

        // That's why we have another type of constructor
        System.out.println();
        Student_details_II Abhinav = new Student_details_II( 1768, "Abhinav Choudhary", 90 );
        /*
            Here's what happens during this object creation:

            1. The constructor 'Student_details_II(int roll_number, String name, float marks)' is called.
            2. The values (1768, "Abhinav Choudhary", 90) are passed as arguments.
            3. Inside the constructor, the 'this' keyword refers to the current object (Abhinav).
            4. So, 'this.roll_number = roll_number' assigns the value 1768 to Abhinav.roll_number.
               Similarly, name and marks are also assigned.
            5. Thus, the object's fields are initialized at the time of creation.
        */

        System.out.println( Abhinav.roll_number );
        System.out.println( Abhinav.name );
        System.out.println( Abhinav.marks );
    }
}

class Student_details_II{

    int roll_number;
    String name;
    float marks;

    Student_details_II( int roll_number, String name, float marks ){

        this.roll_number = roll_number;
        this.name = name;
        this.marks = marks;
    }
}

class Student_detail{

    int roll_number ;
    String name ;
    float marks ;

    // Method that uses 'this' to access current object's data
    void greeting(){
        System.out.println( "Hello everyone my name is " + this.name);
    }

    // Constructor to initialize values when object is created
    Student_detail() {

        // When Akshit.roll_number will call this "this" keyword will be equal to akshit
        // this.roll_number becomes => akshit.roll_number and gives the info
        this.roll_number = 1769;
        this.name = "Akshit Choudhary";
        this.marks = 90;

        // This same things is like on line 9, 10, 11
        // and when the required info is needed the "this" keyword will become the object name and would give us info
    }
}
