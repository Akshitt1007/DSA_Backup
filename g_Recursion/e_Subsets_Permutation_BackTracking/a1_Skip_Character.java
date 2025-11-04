package g_Recursion.e_Subsets_Permutation_BackTracking.a_Basic_Questions;

public class a1_Skip_Character {
    public static void main(String[] args) {

        String name1 = "baccad";
        skip_character_with_Global_variable( name1 );
        System.out.println( new_string );

        String name2 = "bbbbbaaaaaaaddddeijw";
        String new_string = skip_variable( name2 );
        System.out.println( new_string );

        String name3 = "bbbbbbaaaaaaaaaaaaaaaaadd";
        String new_string2 = skip_variable_through_body( name3, 0 );
        System.out.println( new_string2 );

        String name4 = "bacapplcdah";
        skip( "", name4 );

        String name5 = "bbbapple";
        String new_String3 = skipII( name5 );
        System.out.println( new_String3 );
    }


    // Way 1:
    static StringBuilder new_string = new StringBuilder();

    static void skip_character_with_Global_variable( String name ){
        helper ( name , 0 );
    }

    static void helper( String name, int i ){

        if( i == name.length() ){
            return;
        }

        if ( name.charAt(i) != 'a' ){
            new_string.append( name.charAt(i) );
        }

        helper( name, ++i );
    }


    // Way 2:
    static String  skip_variable( String name){
        return helperII( name, "", 0);
    }

    static String helperII( String name, String x , int i){

        if ( i == name.length() ){
            return x;
        }

        if ( name.charAt(i) != 'a' ){
            x = x + name.charAt(i);
        }

        return helperII( name, x, i+1 );
    }


    // Way 3:
    static String skip_variable_through_body ( String name, int i ){

        String x = "";

        if ( i == name.length() ){
            return x;
        }

        if ( name.charAt(i) != 'a' ){
            x = x + name.charAt(i);
        }

        String answer_from_below = skip_variable_through_body( name, i+1 );

        return x + answer_from_below ;
    }


    // Way 4:
    static void skip(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);

        if (ch == 'a') {
            skip(p, up.substring(1));
        } else {
            skip(p + ch, up.substring(1));
        }
    }


    // Way 5:
    static String skipII(String up) {
        if (up.isEmpty()) {
            return "";
        }

        char ch = up.charAt(0);

        if (ch == 'a') {
            return skipII(up.substring(1));
        } else {
            return ch + skipII(up.substring(1));
        }
    }

}
