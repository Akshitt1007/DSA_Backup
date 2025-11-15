package q_Additional.q3_Karp_Rabin_String_Matching_Algo;


/*
    - If we are given a string, and we have to find a target substring within it

        String a = "blajfbkhbdvdbfvAKSHIT";
        String target = "AKSHIT";

    - We can search by checking every substring of length target.length() in 'a'
      and comparing it with the target.

    - But this approach is not optimized —
      it has a quadratic time complexity (O(n * m)) in the worst case.


    => To find the target substring in linear time,
      we can use the Rabin–Karp String Matching Algorithm.

        String a = "blajfbkhbdvdbfvAKSHIT";
        String target = "AKSHIT";

    - The idea:
        → Compute the hash value of the target string: hash("AKSHIT")
        → Compute the hash value of each substring of length target.length() in 'a'
        → If the hash values match, compare the actual substring to confirm (to avoid false positives)

    - This way, we avoid checking every character individually.
      Instead, we slide a window of size target.length() across 'a'
      and update the hash in O(1) time using a rolling hash formula.

    - Overall time complexity:
        → Average case: O(n + m)
        → Worst case: O(n * m) (when many hash collisions occur)

*/

class KarpRabin{
    private final int prime = 101;

    // 1. To calculate the hash of the first slot in given string
    // This takes o(n) and rest of the calculation would be constant
    private long calculateHash( String str ){
        long hash = 0;

        for( int i=0 ; i<str.length(); i++ ){
            hash += str.charAt(i) * Math.pow( prime, i );
        }

        return hash;
    }

    // 2. To update the hash when moving to second slot in the given string
    // we will remove from start and add in end
    private long updateHash( long preHASH, char oldCHAR, char newCHAR, int patternLENGTH ){

        // To remove the value since we moved from that slot
        long newHASH = ( preHASH - oldCHAR ) / prime;

        // Storing the new char's hash in the Hash
        // patternLENGTH would be the index number
        newHASH += newCHAR * Math.pow( prime, patternLENGTH-1);

        return newHASH;
    }

    // 3. Main Algorithm
    public void search(String text, String pattern ){

        // This will give us the slot length that we have to find
        int patternLENGTH = pattern.length();

        // To calculate the hash value of the target pattern
        long targetHash = calculateHash( pattern );

        // To calculate the hash of slot from starting
        long slotHash = calculateHash( text.substring(0, patternLENGTH) );      // To pass the string of pattern size

        // This is our window
        for( int i=0 ; i <= text.length() - patternLENGTH; i++ ){

            // Check 1: If both the has values matches
            if( targetHash == slotHash ){

                // Check 2: in case of hash collision
                // There might be many cases where hashes are same but string are different
                if( text.substring( i, i+patternLENGTH).equals( pattern) ){
                    System.out.println( "Yes the pattern is present " + i );
                }
            }

            // To update the value
            // and this check if we are in the window or not
            if( i < text.length() - patternLENGTH ){
                slotHash = updateHash( slotHash, text.charAt(i), text.charAt( i + patternLENGTH), patternLENGTH );
            }
        }
    }
}
public class q2 {
    public static void main(String[] args) {

        KarpRabin chck = new KarpRabin();

        String x = "AKSHITABHINAVARYANANSHULADITIYADAKSHAARONANUJSEMWAL";
        String target = "SEMWAL";

        chck.search( x, target );
    }
}
