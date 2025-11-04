package h_OOPS.Inheritance;

/*
    Super keyword:
        super is a keyword in Java used to refer to the immediate parent class of the current object.

    3 use cases of super keyword:

        1️⃣ Calling the Parent Class Constructor
            When we want to access the value that is present in Parent class from child class

        2️⃣ Accessing Parent Class Variables
            When there are 2 same variable name in both the Parent class and child class
            and in child class if we want to access the variable of the same name of the parent class
            we cant do "this" as this will give the value of the variable of child class
            we will do "super.x" to get that value of variable from the Parent class

        3️⃣ Calling Parent Class Methods
 */

class Box{
    int length;
    int breadth;

    int same_name = 100;

    Box(){
        this.length = -1;
        this.breadth = -1;
    }

    Box( int length, int breadth ){
        this.length = length;
        this.breadth = breadth;
    }
}

class Box_weight extends Box{

    int weight;

    int same_name = 0;

    Box_weight(){
        this.weight = -1;
    }

    Box_weight( int length, int breadth, int weight){

        super( length, breadth );

        this.weight = weight;
    }

    public void getvalue(){
        System.out.println( "The value of 'same_name' in the Box_weight is: " + this.same_name );
        System.out.println( "The value of 'same_name' in the Box is: " + super.same_name );
    }
}

public class b2_Super_Keyword {
    public static void main(String[] args) {

        Box_weight box = new Box_weight( 2, 3, 40 );
        System.out.println( box.length + " " + box.breadth + " " + box.weight );

        box.getvalue();
    }
}
