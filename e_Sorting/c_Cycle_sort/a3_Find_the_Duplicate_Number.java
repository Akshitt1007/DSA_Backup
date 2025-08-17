package e_Sorting.c_Cycle_sort.Questions;

public class a3_Find_the_Duplicate_Number {
    public static void main(String[] args) {

        int[] array_0 = {1,3,4,2,2};
        int[] array_1 = {3,1,3,4,2};
        int[] array_2 = {3,3,3,3,3};
        int[] array_3 = {5,4,3,2,1};

        System.out.println( Find_the_Duplicate_Number( array_0 ) );
        System.out.println( Find_the_Duplicate_Number( array_1 ) );
        System.out.println( Find_the_Duplicate_Number( array_2 ) );
        System.out.println( Find_the_Duplicate_Number( array_3 ) );
    }

    static int Find_the_Duplicate_Number( int[] arr ){

        int i = 0 ;

        while ( i < arr.length ){

            if ( arr[i] != i+1 ){

                int index = arr[i] - 1;

                if ( arr[i] != arr[index] ){

                    int temp = arr[i];
                    arr[i] = arr[index];
                    arr[index] = temp;

                }
                else{

                    return arr[i];

                }
            }
            else{
                i++;
            }
        }

        return -1;
    }
}
