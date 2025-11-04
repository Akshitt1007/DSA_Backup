package h_OOPS.Polymorphism;

public class c3_How_Override_works {
    public static void main(String[] args) {

        child x = new child();  // Normal scenario
        x.hello();
        System.out.println( x.num );
        System.out.println();

        Parent y = new child();    // Parent reference to a Child object
        y.hello();
        System.out.println( y.num );
        System.out.println();
//        y.bye();
        // Can't access this because it's not in the Parent class blue-print

        /*

            * Dynamic Memory Resolution : Dynamic Memory Resolution (in the context of polymorphism) refers to the process at runtime where
                                          the Java Virtual Machine determines which overridden method in the child class should be executed when
                                          called through a parent class reference.

            How overriding happens:

            Overriding is done when the reference variable is of super-class and
            which type of method is called depends on type of object created

                Parent y = new child();

                here, Parent is the reference type
                      and child is the type of object created

                      so when this is called
                      the method which is called depends on the object
                      ie child here.

                this is known as UPCASTING
              */
        /*
                ( Which one to Access )
                Reference type — Think of it as the lens through which the compiler sees the object.
                                 It decides which variables you can access and how the compiler checks your code.
                                 So, if your reference is Parent, you only see Parent’s variables (even if the object is a child).

                ( Which one to run )
                Object type — This is the real star of the show at runtime. When you call a method, Java looks at the actual object’s class
                              to decide which overridden method to run. That’s why the child’s version of hello() runs, even if the reference is a Parent.
         */
    }
}

class Parent{
    int num = 10;

    void hello(){
        System.out.println( "hello I am parent" );
    }
}

class child extends Parent{
    int num = 0;

    @Override
    void hello(){
        System.out.println( "hello I am child 1" );
    }

    void bye(){
        System.out.println( "Goodbye" );
    }
}
/*
🔥 In Java, when you have a parent class reference pointing to a child class object (like Parent y = new child();),
method calls are determined by the actual object’s type at runtime — meaning the child’s overridden method runs, not the parent’s.
This is called runtime polymorphism or dynamic method dispatch. However, variables don’t follow this rule; they are resolved at
compile-time based on the reference type, so y.num accesses the parent’s variable, not the child’s. If the child hadn’t overridden the method,
the parent’s method would run instead. Overriding is the magic that lets child objects customize behavior even when accessed through parent references,
while variable access remains tied to the reference’s type. This duality — dynamic methods, static variables — is key to understanding
*/

/*
    🎭 Think of it like acting:

    -> The reference type (Parent) is the script.
    -> The object type (Child) is the actor.
    -> The actor can say lines their own way (overridden method).
    -> But they can only speak the lines that are in the script (available to reference type).
 */

