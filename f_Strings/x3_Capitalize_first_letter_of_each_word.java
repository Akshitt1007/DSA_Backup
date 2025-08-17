package f_Strings;

public class x3_Capitalize_first_letter_of_each_word {
    public static void main(String[] args) {

        System.out.println( capitalize( "get better at coding"));
        System.out.println( capitalize( "code quotient"));
    }

    public static String capitalize( String sentence ){

        String[] words = sentence.split("\\s+");

        StringBuilder sb = new StringBuilder();

        for(int i=0 ; i<words.length ; i++ ){
            String letter = words[i];

            String first = String.valueOf(letter.charAt(0)).toUpperCase();
            String middle = letter.substring( 1, letter.length() );

            sb.append(first).append(middle);
            sb.append(" ");
        }
        return sb.toString();
    }
}
