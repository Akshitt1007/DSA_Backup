package h_OOPS.Abstracts_Classes;

public abstract class Parent {

    int age;
    Parent(int age){
        this.age = age;
    }

    /*
        Why do we declare methods as abstract?

            1. Usually, common variables or methods that every child shares go into the parent class.
               We use the "super" keyword to pass arguments and use these common implementations.

            2. But when we have many subclasses, providing implementations in the parent for methods
               that every child *changes* would cause chaos and bloat.

            3. Since these methods must be present and will be overridden by every child class with different behavior,
               there's no point in declaring their bodies in the parent.

            4. Enter Abstract Classes + Polymorphism!

            5. Abstract classes don't need body so no need to write the body and because of polymorphism we would be able to override it the child class
               and make changes according to child class needs

            6. This makes overall code neat and clean and easy to understand
     */
    public abstract void Carrier();
    public abstract void Choice();

//    public abstract Parent();
    // 1. Constructor can't be abstract.
    // 2. Abstract methods are meant to be overridden.
    // 3. Constructors can’t be overridden. Ever.

    // 4. Constructor ≠ Method
    // 5. Constructors are used for i) creating object
    //                              ii) initialize the object’s state
    //                              iii) Belongs only to the class in which it is defined.
    //    If this became abstract, it means we are saying subclass to create object for that top class

    public void Introduction(){
        System.out.println("Hello My age is " + age );
    }
}

/*
    Why Don’t We Provide Method Bodies in Abstract Classes (for Abstract Methods)?\

        -> In Java, abstract methods are declared in an abstract class without a body.
        -> The purpose of an abstract method is to tell subclasses:
           "You must provide your own implementation for this method."
        -> If you provide a body, it’s no longer abstract! It becomes a regular method.

    Why is this useful?

        -> Abstract classes are meant to define a common template or contract for all subclasses.
        ->They allow you to specify that "every subclass must implement these behaviors," but how they do it is up to them.
        -> This enforces a structure and ensures certain methods are always present in subclasses.

    What if you want a body?

        -> If you want to provide a default implementation, just make it a regular (concrete) method in the abstract class:
        -> Subclasses can still override concrete methods if they want to change the behavior.
 */
