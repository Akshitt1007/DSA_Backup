package f_Strings;

public class x6_Count_Vowels_in_String {
    public static void main(String[] args) {
        System.out.println(countVowel("Programming is fun!"));
    }

    public static int countVowel(String str) {
        int count = 0;
        str = str.toLowerCase(); // Make it case-insensitive

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;
            }
        }

        return count;
    }
}
