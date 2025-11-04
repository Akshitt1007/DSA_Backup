package h_OOPS.Inheritance;
/*
               Parent (Human)
            /                \
        Child1 (Student)   Child2 (Teacher)

        Parent:
        - String name
        - int age

        Child1:
        - int rollNumber

        Child2:
        - String subject

    Imagine we have two classes, Child1 and Child2. Both have their own unique properties, but they also share common properties like age.
    Instead of repeating age in both child classes, we define it once in the parent class.
    This way, whenever we need to access Child1.age or Child2.age, it will be inherited directly from the parent class.
 */
public class b1_Inheritance {
    public static void main(String[] args) {

        Parent box = new Parent();
        System.out.println( box.breadth + " " + box.height + " " + box.length );

        Parent box1 = new Parent( 2 );
        System.out.println( box1.breadth + " " + box1.height + " " + box1.length );

        Parent box2 = new Parent( 1, 2, 3 );
        System.out.println( box2.breadth + " " + box2.height + " " + box2.length );

        Parent box3 = new Parent( box1 );
        System.out.println( box3.breadth + " " + box3.height + " " + box3.length );

        System.out.println( "Child class: ");

        Child box4 = new Child();
        System.out.println( box4.weight + " " + box4.length );

        Child box5 = new Child( 2, 65 );
        System.out.println( box5.weight + " " + box5.length );

        // To pass the values for variable in the Parent class
        Child box6 = new Child( 5, 6, 7, 78 );
        System.out.println( box6.breadth + " " + box6.height + " " + box6.length + " " + box6.weight );

        // 💥💥 Reference Type vs Object Type.

        // 💥 Parent reference to a Child object
        Parent Rectangle = new Child( 10, 11, 12, 13 );

        // Here we can access the value of the variable that are in the Parent class
        System.out.println( Rectangle.breadth );
        /*
        1. But we can't access the value of variable that are in Child class
        2. Because it is the type of reference variable according to which we can access the object and not the type of object we made
        3. Since the Rectangle is of "Parent" type we will only access the variable that are in the "Parent" class only
        4. It does not depend on the type of object made
         */
//        System.out.println( Rectangle.weight);

        // 💥  Child reference to Parent object:
//         Child Akshit = new Parent(2, 2, 2 );
        /*
            1. there are many variable in both the Parent and Child class
            2. We are given access to variable that are in the ref. type. ie Child
            3. hence, we should be able to access the weight variable
            4. This also means, that the ones we are trying to access should be initialised first
            5. But here when the "Parent" object will be created it have no constructor for weight to get initialed
            6. So the weight would not get initialised
            7. That's why error
         */

//        System.out.println( Akshit.weight );
        // Compilation Error:
        // Because Parent does not have the extra parts that Child expects (like weight). So if the compiler let you do this,
        // and you tried to access weight, you’d be accessing memory that doesn’t even exist

        /*
            Okay, I get that I can't access Child-specific stuff, but why can't I at least access the Parent variables since they're common in both ?

            1. we can do it
            2. but the java compiler makes this illegal
            3. it does not care what they have in common
            4. we Never Reached That Point — Compilation Fails Immediately
            5. we not being denied access to the parent variables.
            6. we being denied the entire assignment because it's illegal from the start.
         */
    }
}

class Parent{

    int height;
    int length;
    int breadth;

    Parent(){
        this.height = -1;
        this.length = -1;
        this.breadth = -1;
    }

    Parent( int height,int length, int breadth ){
        this.height = height;
        this.length = length;
        this.breadth = breadth;
    }

    Parent( int size ){
        this.height = size;
        this.length = size;
        this.breadth = size;
    }

    Parent( Parent old ){
        this.height = old.height;
        this.length = old.length;
        this.breadth = old.breadth;
    }
}

class Child extends Parent{

    int weight ;

    Child(){
        this.weight = -1;
    }

    Child( int height, int length, int breadth, int weight ){

        super( height, length, breadth );
        // This super keyword will call the constructor that would be taking the 3 argument and storing the values
        // Used to initialize the value present in the Parent Class
        System.out.println("This constructors runs when we send the variable for parent class ");

        this.weight = weight;
    }

    Child( int size , int weight ){
        super( size );
        // This will call that constructor in Parent class which would be taking only 1 argument
        this.weight = weight;
    }
}
