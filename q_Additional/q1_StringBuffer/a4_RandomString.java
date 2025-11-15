package q_Additional.q1_StringBuffer;

import java.util.Random;

/*
        - Give me a random integer starting from 0 up to (but not including) n.
                rand.nextInt(n);
                0  →  n - 1
        - Whatever number you put inside the brackets defines how many possibilities there are — not the starting or ending number directly.
 */
public class a4_RandomString {
    public static void main(String[] args) {

        Random x = new Random();
        System.out.println( x.nextInt() );

        char xyz = generate( x );
        System.out.println( xyz );
    }

    static char generate( Random x ){

        // here random will generate any number between 0-25
        // because n = 26 here
        // since we will get a random alphabet position
        // we then add it to 97 because ASCII value of a start from 97
        int randomChar = 97 + x.nextInt(26);

        // Convert back to char and return it
        char ch = (char) (randomChar);

        return ch;
    }
}
