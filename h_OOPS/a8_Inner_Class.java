package h_OOPS;

public class a8_Inner_Class {

/*
     Static meaning depend on where it has been used:

        Variable    -> Shared across all objects of the class
        Method      -> Can be called without object; can't use instance vars
        Block	    -> Executes when class is loaded; initializes static data
        Inner Class	-> Independent of outer class instances
 */

    static class Test {
        String name;

        Test(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {

        // We can directly create Test objects without needing an a8_Inner_Class object
        Test A = new Test("Akshit");
        Test B = new Test("Abhinav");

        System.out.println(A.name);
        System.out.println(B.name);
    }
}
/*
    -> a8_Inner_Class is a regular, non-static outer class. So when we declare an inner-class(Test) without static, it becomes tied to an instance of the outer class.
        And since the main() method is static — it exists before any object of the outer class is created — it cannot directly access any non-static inner class.

    -> So, to access a non-static inner class:

        a8_Inner_Class outer = new a8_Inner_Class();         // outer object
        a8_Inner_Class.Test obj = outer.new Test("Akshit");  // inner object through outer

    But when you write static class Test, here's what changes:

        • Now Test is no longer tied to an object of a8_Inner_Class.
        • It can be used directly from static context like main().
        • It's treated almost like a top-level class, just logically grouped inside a8_Inner_Class.
 */