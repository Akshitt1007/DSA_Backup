package g_Recursion;

import java.util.ArrayList;

public class a7_List_in_Body {
    public static void main(String[] args) {

        int[] array = { 1, 2, 3, 3, 4 };
        int target = 3;

        ArrayList<Integer> answer = find( array, target, 0 );

        System.out.println( answer );
    }

    static ArrayList<Integer> find ( int[]arr, int target , int index ){

        ArrayList<Integer> list = new ArrayList<>();

        if( index == arr.length ){
            return list;
        }

        // This will contain the answer for that function call only
        if ( arr[index] == target ){
            list.add ( index );
        }

        // when the find() will get answer from previous call it will get stored in the array list and this will be passed on another call
        ArrayList<Integer> Answer_from_below =  find( arr, target , index+1 );

        list.addAll(Answer_from_below);
            // After the previous call index gets stored in the "Answer_from_below" list
            // we will then add that index to the arraylist of this call's answer
            // after the line 33 the list =[3] an after addAll list = [ 3 + previous index ]

        return list;
            // then we return this list.
            // this list will get stored in the "Answer_from_below" of the function where it was called.
            // then there "Answer_from_below" will get added to their body list and will keep on going
    }
            /*
                If arr = {1, 2, 3, 3, 4} and target = 3:

                    Call at index 4: returns []

                    Call at index 3: adds 3, returns [3]

                    Call at index 2: adds 2, returns [2, 3]

                    Call at index 1: returns [2, 3]

                    Call at index 0: returns [2, 3]
             */

}
