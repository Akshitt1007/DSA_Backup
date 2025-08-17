package h_OOPS;

public class a3_Constructor_Overloading {
    public static void main(String[] args) {

        body_details Akshit = new body_details();
        // Since no values are passed here, the default constructor (0-argument) is called.
        // It initializes the object with default values defined inside the class blueprint.

        System.out.println( Akshit.age );
        System.out.println( Akshit.height );
        System.out.println( Akshit.weight );
        System.out.println();

        body_details Abhinav = new body_details( 24, 180, 80 );
        // Since values are provided during object creation, the parameterized constructor is called.
        // The object is initialized with the values passed in.

        System.out.println( Abhinav.age );
        System.out.println( Abhinav.height );
        System.out.println( Abhinav.weight );
        System.out.println();

        body_details random = new body_details( Abhinav );
        // random has exactly the same data as Abhinav, but it's a separate object

        System.out.println( random.age );
        System.out.println( random.height );
        System.out.println( random.weight );
    }
}

class body_details{

    // Function overloading (also called method overloading) is when multiple methods in the same class have the same name but different parameter lists.

    int age;
    int height;
    int weight;

    // This function have 0 arguments
    body_details(){
        this.age = 20;
        this.height = 169;
        this.weight = 64;
    }

    // This function have 3 arguments
    body_details( int age, int height, int weight ){
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    // This function will copy other object values
    body_details( body_details other ){

        // 'other' is another object of the same class that we want to copy

        this.age = other.age;
        // Assign the age of the current object to be the same as the 'other' object's age

        this.height = other.height;
        // Assign the height of the current object to match the 'other' object

        this.weight = other.weight;
        // Copy the weight from the 'other' object to this new one

    }
}
