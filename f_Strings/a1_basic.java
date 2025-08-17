package f_Strings;

public class a1_basic {
    public static void main(String[] args) {

        String x = " akshit ";


        String a = " Akshit Choudhary ";

        String b = " Akshit Choudhary ";

        System.out.println( a == b );
        System.out.println();



        String name_1 = new String( " akshit ");

        String name_2 = new String( " akshit ");

        String name_3 = " akshit ";

        System.out.println( name_1 == name_2 );
        System.out.println( name_1 == name_3 );
        System.out.println( name_2 == name_3 );
        System.out.println( x == name_3 );

        System.out.println();

        System.out.println( name_1.equals(name_2) );
        System.out.println( name_1.equals(name_3) );



    }
}
