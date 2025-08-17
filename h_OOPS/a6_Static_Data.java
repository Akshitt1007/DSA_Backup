package h_OOPS;

public class a6_Static_Data {
    public static void main(String[] args) {

        greeting();
        // Why does this work?
        // Because both main() and greeting() are static methods.
        // Static methods belong to the class, not to any instance (object).
        // Since main() is static, it cannot directly call a non-static method.
        // So greeting() must also be static to be accessible from main().
    }

    // If we remove 'static' from this method, we’ll get a compile-time error.
    // Why?
    // Because static methods can only directly call other static methods.
    // Non-static methods belong to objects, and we haven’t created any object here.
    static void greeting(){

        // To call a non-static method (like hello()) from a static method,
        // we need to create an object of the class.
        // Why? Because non-static members belong to objects, not the class itself.
        a6_Static_Data obj = new a6_Static_Data();
        obj.fun();

        System.out.println("Hello everyone!!");
    }

    // This id wrong because how could we use something that depend of instance in something that does not depend on instances
//    void greeting(){ System.out.println("Hello everyone!!"); }


    // Non-static methods can call static methods freely.
    // Because static members are always available—shared by all instances.
    void fun(){
        greeting();
    }

    void hello(){
        System.out.println("Hello");
    }
}

class random{

    int age;

    static void age(){
//        System.out.println( this.age );

        // Here we cannot access "this.age"
        // because the "this" represent the object,
        // and we cannot use object in a static method
    }

    void ageII(){
        System.out.println( this.age );
    }

    random(int age){
        this.age = age;
    }
}

