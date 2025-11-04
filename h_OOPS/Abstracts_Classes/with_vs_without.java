//package h_OOPS.Abstracts_Classes;
//
//class with_vs_without {
//    // No method defined here!
//}
//
//class Circle extends with_vs_without {
//    void draw() {
//        System.out.println("Drawing a circle");
//    }
//}
//
//class Triangle extends with_vs_without {
//    void paint() {
//        System.out.println("Painting a triangle");
//    }
//}
//
//class Hexagon extends with_vs_without {
//    void renderMeBaby() {
//        System.out.println("Rendering a hexagon");
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//        with_vs_without s1 = new Circle();
//        with_vs_without s2 = new Triangle();
//        with_vs_without s3 = new Hexagon();
//
//        // What method do we call here?
//        // s1.draw(); // ❌ Compilation error: draw() not found in Shape
//        // s2.paint(); // ❌ Same problem
//        // s3.renderMeBaby(); // ❌ Again, no such method on reference type Shape
//
//        // You’re stuck calling nothing or casting — spaghetti alert! 🍝
//        ((Circle) s1).draw();
//        ((Triangle) s2).paint();
//        ((Hexagon) s3).renderMeBaby();
//    }
//}
