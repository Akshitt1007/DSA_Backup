package d_Searching.Binary_Search;

public class b4_Floor_of_number {
    public static void main(String[] args) {
        int []array = { 2, 3, 5, 9, 12, 14, 16, 20 };

        System.out.println("Ceiling of 8: " + Floor_of_number(array, 8));  // Output: 5
        System.out.println("Ceiling of 10: " + Floor_of_number(array, 10)); // Output: 9
        System.out.println("Ceiling of 21: " + Floor_of_number(array, 21)); // Output: 20
        System.out.println("Ceiling of 23: " + Floor_of_number(array, 23)); // Output: 20
    }

    static int Floor_of_number(int [] array , int target){
        int start = 0;
        int end = array.length-1;

        if( target < array[start] ){
            return -1;
        }

        while( start <= end ){

            int middle = ( start + end ) / 2;

            if ( target < array[middle]){
                end = middle - 1;
            }
            else if ( target > array[middle] ){
                start = middle + 1;
            }
            else{
                return target ;
            }
        }
        return array[end];
    }
}
