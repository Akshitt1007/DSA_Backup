package h_OOPS.Polymorphism;

/*
        Static keyword:
            -> The 'static' keyword in Java binds methods/variables to the class rather than to instances (objects).
            -> Because of this, static methods are shared among all instances and should ideally be called using the class name.

        Why this breaks Polymorphism?

            → Polymorphism is based on the actual object (runtime behavior),
              but static methods are resolved at compile time using the reference type, not the object type.
            → So, even if a subclass defines a static method with the same name, it's not overridden — it's hidden.
            → This is called *method hiding*, not *method overriding*.
        Therefore, static methods do **not participate in runtime polymorphism**.
 */
public class c6_Static_Keyword {
    public static void main(String[] args) {

        Myclass obj = new Myclass();
        Myclass.greet();

        Myclass x = new Demo();
        x.greet();          // Still calls Myclass.greet(), not Demo.greet()

        Myclass.greet();
    }
}

class Myclass{

    static void greet(){
        System.out.println( "Hello everyone I am in Myclass");
    }
}

class Demo extends Myclass{

    static void greet(){
        System.out.println( "Hello everyone I am in Demo class");
    }
}


