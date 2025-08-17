package h_OOPS.Interfacee.Extended_interface;

// The 'main' class implements interface C.
// Since C extends both B and A, 'main' must implement all methods from C, B, and A.
public class main implements C {

    // Implements the 'greet' method from interface B (and thus C)
    @Override
    public void greet() {
        System.out.println("Hello everyone");
    }

    // Implements the 'fun' method from interface A (and thus C)
    @Override
    public void fun() {
        System.out.println("I am having fun");
    }

    // Implements the 'bye' method from interface C directly
    @Override
    public void bye() {
        System.out.println("See you later");
    }

    // Since C extends B and A, it inherits all their abstract methods.
    // Therefore, any class implementing C must provide implementations for all methods in C, B, and A.

    public static void main(String[] args) {
        main obj = new main();

        obj.greet(); // Calls the implementation of greet()
        obj.fun();   // Calls the implementation of fun()
        obj.bye();   // Calls the implementation of bye()
    }
}