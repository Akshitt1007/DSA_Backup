package h_OOPS.Interfacee.Extended_interface;

// In Java, interfaces can extend more than one interface using the 'extends' keyword.
// This is known as "multiple inheritance" for interfaces.
// Interface C extends both interfaces A and B.
// This means C inherits all abstract methods from both A and B.
// Any class implementing C must implement all methods declared in A, B, and C.
public interface C extends A, B {

    // C declares its own method 'bye' in addition to all methods inherited from A and B.
    void bye();
}