package h_OOPS.Interfacee.Default_and_Static;

// A static method in an interface is similar to a static method in a class.
// It belongs to the interface itself, not to instances of classes implementing the interface.

interface X {
    // Static method in interface X
    static void greet() {
        System.out.println("Hello from static method in interface");
    }
}

interface Y {
    void fun();
}

// No need to implement X or Y to call static methods from an interface.
public class a2_static {
    public static void main(String[] args) {

        // You can call a static method in an interface using the interface name.
        X.greet(); // Output: Hello from static method in interface

        // You CANNOT call greet() on an object or via implementing class.
        // For example, the following is INVALID and will cause a compilation error:
        // a2_static obj = new a2_static();
        // obj.greet(); // ERROR: greet() has private access in 'X'

        // Also, implementing X in your class does NOT allow you to call X.greet() as an instance method.
        // Static methods in interfaces are NOT inherited by implementing classes.
    }
}