package d_Searching.Binary_Search;

// LeetCode744

public class b5_Smallest_Char_Greater_Than_Target {
    public static void main(String[] args) {

        char[] letter_1 = {'a', 'b', 'b', 'b', 'c', 'c', 'd'};
        char[] letter_2 = {'c', 'f', 'j', 'k', 'm', 'p'};
        char[] letter_3 = {'c', 'f', 'j'};
        char[] letter_4 = {'e', 'e', 'e', 'e', 'e', 'e', 'n', 'n', 'n', 'n'};
        char[] letter_5 = {'x', 'x', 'y', 'y'};
        char[] letter_6 = {'c', 'f', 'j'};

        System.out.println( nextGreatestLetter( letter_1 , 'b'));
        System.out.println( nextGreatestLetter( letter_2 , 'l'));
        System.out.println( nextGreatestLetter( letter_3 , 'd'));
        System.out.println( nextGreatestLetter( letter_3 , 'g'));
        System.out.println( nextGreatestLetter( letter_4 , 'e'));
        System.out.println( nextGreatestLetter( letter_5 , 'z'));
        System.out.println( nextGreatestLetter( letter_6 , 'c'));
        System.out.println( nextGreatestLetter( letter_6 , 'a'));
    }



    static char nextGreatestLetter(char[] letter, char target) {
        int start = 0 ;
        int end = letter.length - 1;

        if( target < letter[start] ){
            return letter[start];
        }
        if( target > letter[end] ){
            return letter[start];
        }
        if( target == letter[end]){
            return letter[start];
        }
        while ( start <= end ){
            int middle = start + (end - start) / 2;

            if( target < letter[middle] ){
                end = middle -1 ;
            }
            else if ( target > letter[middle] ){
                start = middle + 1;
            }
            else{
                // return letter[middle+1];
                for(int i=middle ; i<letter.length ; i++){
                    if(letter[i]<letter[i+1]){
                        return letter[i+1];
                    }
                }
            }
        }
        return letter[start];
    }
}

