package h_OOPS;

public class a11_Check_Instance {

    a11_Check_Instance (){
    }

    static class sub extends a11_Check_Instance{
        sub(){
        }
    }

    static class demo{
        demo(){
            
        }
    }

    public static void main(String[] args) {

        sub obj = new sub();

        System.out.println( obj instanceof sub );
        System.out.println( obj instanceof a11_Check_Instance );
        System.out.println( obj instanceof Object );

        /*
            1. 'obj' is an instance of 'sub' — direct match
            2. Since 'sub' extends 'a11_Check_Instance', it's also an instance of that class
            3. All Java classes inherit from 'Object', so 'obj' is also an instance of Object
         */

        demo obj2 = new demo();

        System.out.println( obj2 instanceof demo );
        System.out.println( obj2 instanceof Object );
//        System.out.println( obj2 instanceof a11_Check_Instance );
        
         /*
            4. 'obj2' is an instance of 'demo' — direct match
            5. 'demo' also extends Object implicitly — so it's an instance of Object
            6. But 'demo' does NOT extend 'a11_Check_Instance', so comparing them using instanceof is illegal  (compile-time error)
        */
    }
}

