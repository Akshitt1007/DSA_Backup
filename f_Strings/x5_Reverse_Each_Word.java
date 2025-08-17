package f_Strings;

public class x5_Reverse_Each_Word {
    public static void main(String[] args) {

        System.out.println( reverseEachWord("Hello World"));
    }

    public static String reverseEachWord( String line){
        String[] words = line.split("\\s+");

        StringBuilder sb = new StringBuilder();

        for ( int i=0 ; i<words.length ; i++ ){
            String x = words[i];

            StringBuilder rev = new StringBuilder(x);
            String y = String.valueOf(rev.reverse());

            sb.append(y);
            sb.append(" ");
        }
        return sb.toString();
    }
}
