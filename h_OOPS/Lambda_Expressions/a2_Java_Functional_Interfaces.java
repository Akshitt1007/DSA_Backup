/*
    ================================
           Java Functional Interfaces
           --- Quick Notes ---
    ================================

    1. Consumer<T>
       - Package: java.util.function
       - Purpose: Perform an action with a value, no return.
       - Method: void accept(T t)
       - Takes: 1 argument (T)
       - Returns: void
       - Use case: Printing, logging, saving, modifying external state.

       Example:
       Consumer<Integer> fun = (item) -> System.out.println(item * 2);
       arr.forEach(fun); // Calls accept() for each element

    ---------------------------------------------------

    2. Function<T,R>
       - Purpose: Transform input T to output R.
       - Method: R apply(T t)
       - Takes: 1 argument (T)
       - Returns: R
       - Example: Convert Integer to String, calculate square, etc.

    ---------------------------------------------------

    3. Supplier<R>
       - Purpose: Supply a value without input.
       - Method: R get()
       - Takes: 0 arguments
       - Returns: R
       - Example: Generate random number, provide default values.

    ---------------------------------------------------

    4. Predicate<T>
       - Purpose: Check condition and return boolean.
       - Method: boolean test(T t)
       - Takes: 1 argument (T)
       - Returns: boolean
       - Example: Filter even numbers, validate input.

    ---------------------------------------------------

    Interface        | Takes    | Returns  | Method     | Common Use
    ----------------------------------------------------------------
    Consumer<T>      | 1 value  | void     | accept()   | Side effects (print, log)
    Function<T,R>    | 1 value  | value    | apply()    | Transform data
    Supplier<R>      | 0 value  | value    | get()      | Provide value
    Predicate<T>     | 1 value  | boolean  | test()     | Filter/condition check

    ---------------------------------------------------

    Remember:
    - Consumer -> Side-effects only
    - Function -> Data transformation
    - Supplier -> Generate/return data
    - Predicate -> Condition check
*/
