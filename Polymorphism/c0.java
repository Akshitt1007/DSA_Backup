/*

    Polymorphism:
            -> Poly = many
            -> morphism = ways to represent

            so it's means many ways to represent a single entity in different ways


            Types of Polymorphism:

                1. Compile Time/ Static Polymorphism:

                   -> This is done via METHOD OVERLOADING
                   -> Method Overloading ?
                        => Method having same name but different parameters, arguments, return type, and ordering can be different
                        => example: Multiple Constructors
                                    In them we made many constructor have same name as the class name.
                                    but they differ in how many number of arguments it is taking

                    -> example :  class_x name = new class_x();
                                  class_x name2 = new class_x( 1, 2, 3 );

                2. Run Time/ Dynamic Polymorphism

                    -> This is done via METHOD OVERRIDING
                    -> method overriding?
                        => Method Overriding in Java means providing a new implementation of a method in a subclass
                           that already exists in the superclass — with the same name, same parameters, and same return type.
                        => example: Multiple Method in classes
                                    All must have same name, parameters, and return types

                    -> @Override is a compiler check that ensures a method in a subclass is correctly overriding a method defined in its superclass.
                    -> A method can only be overridden if it is already defined in a parent class — no parent method, no override.


                    ✅ Rules of Method Overriding:
                        1. Method name must be the same
                        2. Parameters must match exactly (type, number, order)
                        3. Return type must be the same (or covariant)
                        4. Only inherited methods can be overridden
                        5. Can't override:
                            i) static, final, or private methods
                            ii) Constructors
 */