package f_Strings;

public class a2_index {

    public static void main(String[] args) {

        String name = " Akshit Choudhary ";

        System.out.println( name.charAt( 0 ));
        System.out.println( name.charAt( 1 ));
        System.out.println( name.charAt( 10 ));

        for( int i=0 ; i<name.length() ; i++ ){
            System.out.print( name.charAt(i) + "-");
        }

    }
}
