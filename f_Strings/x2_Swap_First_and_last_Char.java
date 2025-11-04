package f_Strings;

public class x2_Swap_First_and_last_Char {
    public static void main(String[] args) {

        System.out.println( swap( "Get better at coding") );

    }

    public static String swap(String str){
        String[] words = str.split("\\s+");
        StringBuilder sb = new StringBuilder();

        for ( int i=0 ; i< words.length ; i++ ){

            String word = words[i];
            int size = word.length();

            if ( size == 1){
                sb.append(word);
            }
            else{
                char first = word.charAt(0);
                char second = word.charAt(size-1);
                String middle = word.substring( 1, size-1 );

                sb.append(second).append(middle).append(first);
            }
            sb.append(" ");
        }
        return sb.toString();
    }
}
