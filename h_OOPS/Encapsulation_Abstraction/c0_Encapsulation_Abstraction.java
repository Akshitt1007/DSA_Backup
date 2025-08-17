/*
    Encapsulation:
    -> Encapsulation is the process of wrapping data (variables) and code (methods) into a single unit (a class),
       while restricting direct access to some of the object’s components.

    -> It works behind the scenes, dealing with internal implementation.

    -> The primary goal of encapsulation is to **protect your data** from unauthorized access or unintended changes.


    Abstraction:
    -> Abstraction is the process of hiding the complex internal implementation details and exposing only the
       essential features and behavior to the user.

    -> It focuses on external interaction — what the object does, not how it does it.

    -> The goal of abstraction is to **hide complexity** and simplify usage for the outside world.


    | Feature        | Encapsulation                | Abstraction                         |
    | -------------- | ---------------------------- | ----------------------------------- |
    | Hides          | Internal data                | Internal implementation             |
    | Access via     | Getters/Setters              | Abstract classes / Interfaces       |
    | Main purpose   | Data protection              | Simplification, usability           |
    | Achieved using | `private` fields + methods   | `abstract` classes / `interface`    |
    | Example        | Locking variables in a vault | TV remote — just buttons, no wires  |


    Real-World Example:
    -> Using the `println` method is a great example of **abstraction** — it offers a simple interface to display output
       without revealing how it works underneath.

    -> The internal mechanism of `println` — such as character encoding, buffering, and interacting with system output —
       is handled using **encapsulation**. These details are hidden inside classes like `PrintStream` and protected via
       private members and controlled access.


    1. System.out.println() = Abstraction in Action

        -> When we call:
              System.out.println("Hello");
           we don’t worry about:
            - Character-to-byte conversion
            - Output stream management
            - Buffer flushing
            - OS-level output handling

        => We just use it. This is abstraction — **show what’s necessary, hide the rest**.


    2. Under the Hood = Encapsulation at Work

        -> Inside the Java library:
            - `PrintStream` uses `private` fields and internal logic.
            - Access is limited and controlled via public methods.
            - We **can’t tamper** with its internals unless explicitly allowed.

        => This is encapsulation — **protecting data, hiding internal structure**, while still exposing useful functionality.



    Q Data Hiding vs Encapsulation
      -> Data Hiding is about restricting direct access to class members,
         while Encapsulation is about wrapping data and behavior together with controlled access
*/
