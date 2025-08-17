package h_OOPS;

/*
    1. The static keyword in Java is used to declare class-level members — these include variables, methods, blocks, or nested classes —
       that belong to the class itself rather than to any particular object.

    2. A static member acts like a global property within the class — it is shared across all instances (objects) of the class and can
       be accessed by any of them.

    3. When a static variable is modified, the change is reflected across all objects of the class because they all point to the
       same memory location.

    4. Static members are loaded into memory once when the class is first loaded by the JVM — making them memory-efficient and
       perfect for constants, counters, and utility functions.

    5. When a member is declared "static", it can be accessed without any object of that class being created.
 */

public class a5_Static_Example {
    public static void main(String[] args) {

        // Why is main() static?
        // Because it's the first method that runs when the program starts.
        // No objects have been created yet—Java needs an entry point!
        // If main() wasn't static, you'd need to create an object of the class to call it,
        // but to create that object, you'd need to run main() first.
        // That would be a chicken-and-egg situation 🐔🥚.
        // So, main() is static so it can run without needing any object.
        // It belongs to the class, not to any instance.

        human Rahul = new human( 22, 189, true);
        /*
        1. This line creates a new human object named Rahul.

        2. The constructor is called, and inside that constructor:
              this.age = 22;
              this.height = 189;
              this.married = true;

        3. And most importantly: human.population += 1; --> The total population ticks up by one!
         */

        human Arpit = new human( 20, 173, true);
        // Same with "Arpit"

        System.out.println( Rahul.population );
        System.out.println( Arpit.population );
        // We're accessing a static variable using an object reference (Rahul, Arpit).
        // While this works, it's not good practice.
        // Static members belong to the class, not the objects.
        // Always prefer accessing them using the class name:

        human Akshit = new human( 20, 169, false);

        System.out.println( human.population );
    }

}

class human{

    int age;
    int height;
    boolean married;

    static int population;
    /*
    Among all humans, we each have our own physical characteristics:
    - age
    - height
    - marital status (married or not)

    However, some traits are shared by *all* humans — for example:
    - population (total number of humans)

    Such common traits that belong to the class as a whole (not just one person)
    should be marked as static, so they are shared across all instances.
*/


    human( int age, int height, boolean married ){
        this.age = age;
        this.height = height;
        this.married = married;

        human.population += 1;
    /*
        We're using "human.population" instead of "this.population" — and here's why:

        While "this" refers to the current object (the individual human),
        the variable "population" is marked as static — meaning it belongs to the class itself,
        not to any one object.

        Technically, "this.population" would still work (Java allows it),
        but it's misleading and bad practice because it makes it look like
        population is a property of the specific object, when in fact it's a shared
        class-wide variable.

        So, we use "human.population" to clearly show that this belongs to the entire class.
        It keeps the intention crystal clear and your code clean as a whistle.
    */
    }
}
