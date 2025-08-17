package h_OOPS;

public class a9_main {
    public static void main(String[] args) {

        a9_Singleton_Class obj1 = a9_Singleton_Class.getInstance();
        a9_Singleton_Class obj2 = a9_Singleton_Class.getInstance();

        System.out.println(obj1 == obj2); // true, same instance
        System.out.println( obj1 );
        System.out.println( obj2 );
        // both will have same reference because this singleton object is created once
        // and every other object we make would point to that first ever object created
    }
}
