package f_Strings;

public class a7_performance {
    public static void main(String[] args) {

        for ( int i = 0 ; i < 26 ; i++ ){
            char ch = (char)('a' + i );
            System.out.print( ch + " ");
        }

        System.out.println();

        String series = "";

        for ( int i = 0 ; i < 26 ; i++ ){
            char ch = (char)('a' + i );
            series = series + ch + " ";
        }

        System.out.println( series );

        /*
            This is not a very good code to print the alphabetical series ?

            1. String Immutability:
                    In Java, String objects are immutable, meaning once created, they cannot be changed.

            2. Object Creation in Each Iteration:

                a) here first the series will have object "a"

                b) then after adding "a" + 'b' to it will form "ab" a new object and the series will point it instead of "a"
                   "a" object would be left de referenced

                c) then again after "ab" + 'c' it will form "abc" again a new object and the series will now point it instead of "ab"
                   and same as "a" the "ab" would also be left de referenced in string pool
                                                                .
                                                                .
                                                                .
                e) this will happen till string = "abcde.....z" and the string = " abcdef....y" would also be left dereferenced

              3.  How Many Objects Are Created?

                a) For 26 iterations, Java creates 25 intermediate objects before producing the final series.
                b) These intermediate objects are unreferenced and eligible for garbage collection.
                c) This can be computationally inefficient, especially with larger loop
         */
    }
}
