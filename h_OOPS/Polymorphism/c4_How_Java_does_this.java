/*
    How does Java determine which Method to run ?

    -> Compile time: Java checks the reference type. This means the compiler ensures that the method you are calling
                     actually exists in the reference type (the class or interface of your variable).
    -> Runtime: Java uses the real object's type (the class that was instantiated with new) to determine which overridden method implementation to execute.

    This mechanism is the core of runtime polymorphism (or dynamic method dispatch) in Java. It's what allows for flexible
    and extensible code, where subclasses can change or extend the behavior of their parent classes.

    In short:
        => The compiler cares about the reference type (for method existence).
        => The JVM cares about the actual object type (for method execution).
*/