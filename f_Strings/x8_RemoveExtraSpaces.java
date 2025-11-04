package f_Strings;

public class x8_RemoveExtraSpaces {
    public static void main(String[] args) {
        String input = "   Hello     World   ";
        System.out.println(removeSpaces(input)); // Output: "Hello World"
    }

    public static String removeSpaces(String str) {
        // Trim leading/trailing and reduce all spaces to one
        return str.trim().replaceAll("\\s+", " ");
    }
}
