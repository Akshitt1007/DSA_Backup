package h_OOPS.Interfacee.Default_and_Static;

// Introduced in Java 8, default methods allow interfaces to have concrete method implementations.
// Classes implementing the interface inherit the default method and can use it as-is or override it.

interface A {
    // This is a default method in interface A.
    // Implementing classes do NOT have to override this unless they want custom behavior.
    default void time() {
        System.out.println("Its morning");
    }

    // Abstract method, must be implemented by the class.
    void greet();
}

interface B extends A {
    // B extends A and provides its own default implementation of 'time', overriding A's version.
    default void time() {
        System.out.println("Its night");
    }

    // Abstract method, must be implemented by the class.
    void fun();
}

interface C {
    // C also provides a default 'time' method.
//    default void time() {
//        System.out.println("Its night");
//    }

    void bye();
}

public class a1_Default implements B, C {
    // Implements abstract methods from B (and thus from A).

    @Override
    public void fun() {
        System.out.println("I am having fun");
    }

    @Override
    public void greet() {
        System.out.println("Hello everyone");
    }

    @Override
    public void bye() {
        System.out.println("Bye everyone");
    }

    // ERROR EXPLANATION:
    // If both B and C provide a default method with the same signature (here, 'time'),
    // and the class implements BOTH, the compiler will throw an error due to ambiguity:
    // "class a1_Default inherits unrelated defaults for time() from types B and C"
    // To fix this, you MUST override 'time()' in your class and specify which one to call (if any).
    /*
    @Override
    public void time() {
        // Choose which default method to call, or provide your own implementation.
        // Example: Calling B's default method explicitly:
        B.super.time();
        // Or you could provide your own implementation here.
    }
     */

    public static void main(String[] args) {
        a1_Default obj = new a1_Default();

        obj.greet(); // Calls 'greet' implementation from this class
        obj.fun();   // Calls 'fun' implementation from this class
        obj.bye();
        obj.time();  // Calls the overridden 'time' method, which explicitly calls B's version
    }
}