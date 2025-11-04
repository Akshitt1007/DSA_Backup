package h_OOPS;

public class a9_Singleton_Class {

//    A Singleton class is a design pattern where only one object (instance) of the class can be created, and that one object is shared everywhere.

    private a9_Singleton_Class(){

    }

    private static a9_Singleton_Class instance;

    public static a9_Singleton_Class getInstance(){

        // chck whether the 1 obj only is created or not
        if (instance == null) {     // no object made
            instance = new a9_Singleton_Class(); // only created once
        }
        return instance;
    }

}
