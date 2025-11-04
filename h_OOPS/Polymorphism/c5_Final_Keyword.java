package h_OOPS.Polymorphism;

/*
        In Java, final is used to restrict change.

        You can use it in three places:

            1. final variable → can't be reassigned.
            2. final method   → can't be overridden.
            3. final class    → can't be extended (no subclassing).


        1. Final and Inheritance:
            📍 a) final class – "No more kids allowed"

                        final class Parent {
                            void hello() {
                                System.out.println("Hi from Parent");
                            }
                        }

                        // ❌ Not allowed
                        class Child extends Parent { }  // Compile-time error

                -> You cannot inherit from a final class.
                -> It’s sealed. Think of it like a sealed box — you can't open it or add more.

            📍 b) final method – "This method is locked"

                        class Parent {
                            final void hello() {
                                System.out.println("Hi from Parent");
                            }
                        }

                        class Child extends Parent {
                            // ❌ This will cause a compile-time error
                            void hello() {
                                System.out.println("Hi from Child");
                            }
                        }

                -> You can inherit the method, but you cannot override it.
                -> It’s like saying: "Child, you may inherit this, but you shall not mess with it."
                ---------------------------------------------------------------------

        2. Final and Polymorphism:

            -> If a method is declared final, it can't be overridden.
            -> And if it can't be overridden, it can't participate in runtime polymorphism.

                        class Parent {
                            final void hello() {
                                System.out.println("Hi from Parent");
                            }
                        }

                        class Child extends Parent {
                        // ❌ Cannot override hello()
                        }

                        Parent obj = new Child();
                        obj.hello();  // Only Parent's hello() is called

            -> Even though the object is of type Child, it cannot override hello() because it’s final.
            -> So, runtime polymorphism does not happen here.
            -> It becomes compile-time binding, not dynamic dispatch.
 */



