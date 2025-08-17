package h_OOPS.Interfacee;

public class Main {
    public static void main(String[] args) {

        Car honda = new Car();

        honda.start();
        honda.acc();
        honda.brake();
        honda.stop();
        honda.version(6);
        honda.version();
        System.out.println(honda.price); // Accessing 'price' field from Car class

        System.out.println();
        Engine v6 = new Car();

        v6.acc();
        v6.start();
        v6.version(6);
        v6.stop();

        // System.out.println(v6.price);
        // ERROR: Cannot access 'price' because 'Engine' reference type does not have 'price' field.
        // Fields and methods accessible depend on the reference type, not the object type.

        System.out.println();
        Media_player JBL = new Car();
        JBL.start();
        JBL.stop();
        // Even though 'JBL' is declared as a Media_player reference, the underlying object is of type Car.
        // When JBL.stop() is called, it executes the stop() method from the Car class, which might actually be stopping the Engine!
        // This is confusing because the Media_player interface user expects "stop" to mean "stop the music/player",
        // but due to Car's implementation, it may stop the engine instead.
        // This ambiguity arises because Car implements both Engine and Media_player, and their "stop" methods are not semantically related.
        //
        // To avoid such confusion, it's better to implement unrelated interfaces in separate classes
        // unless the real-world object truly embodies all those behaviors in a meaningful, non-conflicting way.
    }
}
