package h_OOPS.Interfacee;

// Demonstrates Java's interface implementation, including methods with same names/signatures and method overloading.
public class Car implements Engine, Brakes, Media_player {

    int price = 10000;
    /*
     * If multiple interfaces declare methods with the same name and signature,
     * the implementing class only needs to provide a single implementation.
     * This satisfies all interface contracts for that method signature and keeps code clean.

     * If methods have the same name but different parameters (overloading),
     * each unique signature must be implemented separately.
     */

    // Implementation of abstract methods from interfaces
    @Override
    public void brake() {
        System.out.println("I brake like a normal car");
    }

    @Override
    public void start() {
        System.out.println("Engine start like a normal car");
    }

    @Override
    public void stop() {
        System.out.println("Engine stop like a normal car");
    }

    @Override
    public void acc() {
        System.out.println("Engine accelerate like a normal car");
    }

    // Example of method overloading: two different 'version' methods.
    // Implements version(int num) from Engine interface
    @Override
    public void version(int num){
        System.out.println("This is version " + num);
    }

    // Implements version() from Media_player interface
    @Override
    public void version(){
        System.out.println("This have Strong brakes");
    }

    /*
     * Key Points:

       1. No Ambiguity:
          - If method signatures are identical across interfaces, only one implementation is needed.
          - The JVM treats the single implementation as satisfying all interface requirements.

       2. Method Overloading:
          - If interfaces declare methods with the same name but different parameters,
            the implementing class must provide separate implementations for each unique signature.

       3. Abstract Methods:
          - All abstract methods in interfaces must be implemented in the concrete class, unless the class is abstract.

       4. Default Methods (Java 8+):
          - If two interfaces have default methods with the same signature, the implementing class must override the method to resolve the conflict.

       5. Use of @Override:
          - Always use @Override annotation for clarity and to catch errors during compilation.

       Summary:
       - Multiple interfaces with overlapping method signatures pose no problem;
         implement once per unique signature.
       - Method overloading is handled as usual in Java.
       - This approach supports clean, modular, and reusable code.
       *
     */
}