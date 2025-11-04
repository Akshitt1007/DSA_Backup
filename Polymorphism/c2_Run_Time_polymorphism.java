package h_OOPS.Polymorphism;

// ✅ @Override ensures we are properly overriding a method from a superclass.
// ❌ You CANNOT use @Override if the method does not exist in the parent.
// ✅ Method overriding only works when the method is first defined in the parent class.
// ✅ Even if we refer to the object via a parent reference (e.g., Shapes x = new Circle();),
//    the overridden method in the child is called — this is runtime polymorphism!

public class c2_Run_Time_polymorphism {
    public static void main(String[] args) {

        Shapes shape = new Shapes();
        Circle circle = new Circle();
        Triangle triangle = new Triangle();

        shape.Area();     // Output: I am in shapes
        circle.Area();    // Output: Area is pie * r * r
        triangle.Area();  // Output: Area is 0.5 * length * height

        Shapes x = new Circle();
        x.Area();         // Output: Area is pie * r * r
        // Even though reference type is Shapes, the actual object is Circle.
        // So, overridden method in Circle is called — this is runtime polymorphism.
    }
}

// @Override is a compiler-level check that ensures a method in a subclass truly overrides a method from its superclass.
// A method can only be overridden in a subclass, and only if that method is originally defined in one of its superclasses.

class Shapes {

    // Using @Override here would give an error
    // This is the original method, not an override.

    // @Override  // Invalid here
    void Area() {
        System.out.println("I am in shapes");
    }
}

class Circle extends Shapes {

    // This "Area()" method overrides the one in Shapes.
    // When a Circle object is created (even as a Shapes reference), this version is used.

    @Override
    void Area() {
        System.out.println("Area is pie * r * r");
    }

    // This method does not exist in Shapes, so it's NOT an override.
    // @Override here would cause a compiler error.

    // @Override  // This would cause a compiler error
    void AreaII() {
        System.out.println("xyz");
    }
}

class Triangle extends Shapes {

    // ✅ Properly overrides the method in Shapes
    @Override
    void Area() {
        System.out.println("Area is 0.5 * length * height");
    }

    // Same method name as in Circle, but that doesn't matter.
    // A method can only be overridden if it exists in the parent class (Shapes), not in sibling classes like Circle.

    // @Override  // This would cause a compiler error
    void AreaII() {
        System.out.println("abc");
    }
}
