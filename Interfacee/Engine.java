package h_OOPS.Interfacee;

public interface Engine {

    static final int price = 1000;
    /*
        Why Are Variables in an Interface static in Java?

        1. Interface Variables Are Always public static final
            -> Any variable declared inside a Java interface is implicitly:
            -> public (can be accessed everywhere)
            -> static (belongs to the interface itself, not to instances)
            -> final (is a constant, value cannot be changed)

        2. Why static?
            -> Since interfaces cannot be instantiated (you can’t create an object of an interface), there’s no object to hold instance variables.
            -> Making variables static means they belong to the interface itself, not to any object.
            -> This way, you access them using the interface name:
            -> InterfaceName.VARIABLE_NAME
     */

    void start();           // This is an abstract method by default in interfaces
    void stop();
    void acc();
    void version(int num);

//    interface Engine {
//        Engine(){
//            System.out.println("Constructor in interface");
//        }
//    }

    // Interfaces cannot have constructors because you cannot create objects of interfaces.
    // Any attempt to define a constructor in an interface will result in a compile-time error.
}
