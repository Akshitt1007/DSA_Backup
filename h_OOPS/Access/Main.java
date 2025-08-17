package h_OOPS.Access;

public class Main {
    public static void main(String[] args) {

        Access_Modifiers obj = new Access_Modifiers( 10, "Akshit" );

        System.out.println( obj.getDefault_num() ); // Giving the value of default num
        obj.setDefault_num(100);                    // Setting the value to something new
        System.out.println( obj.getDefault_num() );

        System.out.println( obj.name );
        obj.name = "Rohan";
        System.out.println( obj.name );

    }
}
