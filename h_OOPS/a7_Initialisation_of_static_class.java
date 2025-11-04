package h_OOPS;

public class a7_Initialisation_of_static_class {

    static int a = 10;
    static int b ;

    // This only runs once when the first object is created
    // i.e. when the class is loaded for the fist time.
    static {

        System.out.println( "I only run once ");

        b = a * 2;
    }

    public static void main(String[] args) {

        a7_Initialisation_of_static_class obj = new a7_Initialisation_of_static_class();
        System.out.println( a7_Initialisation_of_static_class.a + " " + a7_Initialisation_of_static_class.b );

        a7_Initialisation_of_static_class.b += 5;

        a7_Initialisation_of_static_class objII = new a7_Initialisation_of_static_class();
        System.out.println( a7_Initialisation_of_static_class.a + " " + a7_Initialisation_of_static_class.b );

    }
}
