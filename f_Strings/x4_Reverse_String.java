package f_Strings;

public class x4_Reverse_String {
    public static void main(String[] args) {

        System.out.println( reverse( "get better at coding"));
        System.out.println( reverse( "code quotient"));
    }

    public static  String reverse(String str) {

        StringBuilder sb = new StringBuilder();

        sb.append(str);
        sb.reverse();

        return sb.toString();

    }
}
