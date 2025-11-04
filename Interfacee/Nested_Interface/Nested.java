package h_OOPS.Interfacee.Nested_Interface;

// What is a Nested Interface?
//  -> A nested interface is an interface declared within another class or interface.
//  -> It is also called an inner interface.

//  Top-level interface: Only public or default (package-private).
//  Nested interface: Can be public, protected, private, or default (package-private).

class A {

    // Nested interface declared inside class A
    interface NestedInterface {
        void display();
    }
}

// Class B implements the nested interface using A.NestedInterface syntax
class B implements A.NestedInterface {

    @Override
    public void display() {
        // Implementation of the abstract method from the nested interface
        System.out.println("Hello from nested interface!");
    }
}

class Nested{
    public static void main(String[] args) {

        // Creating an object of class B, which implements A.NestedInterface
        B obj = new B();
        obj.display(); // Calls the display() method, Output: Hello from nested interface!
    }
}