package d_Searching.b_Binary_Search;

/*
    Split Array Largest Sum

        array = 7, 2, 5, 10, 8
        m = 2;

        total possible way to divide the array in m parts (ie 2 here):
            [7], [2, 5, 10, 8] max sum = 25
            [7, 2], [5, 10, 8] max sum = 23
            [7, 2, 5,] [10, 8] max sum = 18
            [7, 2, 5, 10,] [8] max sum = 24

            so we have to return the min of the max sum ie 18 when array is divided by [7, 2, 5],[10, 8] way


            CASE I : min sum ?
                    when the m = array.length
                    and array is divided like = [7][2][5][10][8]
                    and the min sum = max number = 10

            CASE II : max sum ?
                    when the m = 1
                    and array is not divided [7, 2, 5, 10, 8];
                    max sum = sum of all element = 32
 */

public class b16_Split_The_Array {
    public static void main(String[] args) {

        int[] array = { 7, 2, 5, 10, 8};
        int parts = 2;

        System.out.println( "Split the array largest sum is: " + finding_range(array , parts));
    }

    static int Split_Array_Largest_Sum( int[] arr , int times , int start , int end){

        while ( start < end ){

            int middle = start + ( end - start ) / 2;

            int sum = 0;
            int piece = 1;

            for (int i = 0; i < arr.length; i++) {
                int num = arr[i];

                if ( sum + num > middle ){
                    /*
                        a) sabse pahele hum ek ek karke arr ke element ka sum lenge
                        b) pahele 7 hai toh sum = 7 aur 7< mid
                        c) jasse hi koi element ko add karke middle se zada sum aega toh usse
                        d) toh sum ko us element ke barabar rakh denge aur piece ko update kr denge
                        e) agar toh voh piece given time se kaam hua matlb hum hor bhi tarike se tod sakte se array isliye hum end = mid kr denge
                        f) agar given time se zada hua to humne zada peice mai divide kiya hai toh hum mid ko bada karne ke liye start = mid
                        g) end mai end/start ko return kr denge
                    */
                        // If the sum of element is greater than the middle then we cannot add more element sum to it
                        // and will be creating another array
                        // by pieces ++;
                    sum = num;      // then sum would be the '10' and we would take this as new array
                    piece++;
                }
                else{
                        // This would run when the sum would be less than the middle, and we would be kept on adding the element.
                    sum += num;
                }
            }

                // If the pieces is less than given times
                // that means we can divide in more sub array of less size
            if (piece <= times) {
                end = middle;
            }

                // If the pieces is more than given times
                // means if you have divided the array more than required sub array
                // and have to divide less time to get answer
            else if (piece > times) {
                start = middle + 1;
            }
        }
        return end;
    }

    static int finding_range( int[] arr, int times ){

        int max = 0 ;
        for (int i=0; i<arr.length ; i++){
            if( arr[i] > max ){
                max = arr[i];
            }
        }
        int start = max;        // to find the min. max sum of the array

        int sum = 0;
        for (int i=0 ; i<arr.length; i++){
            sum += arr[i];
        }
        int end = sum;          // to find the max sum of array that would be

        return Split_Array_Largest_Sum(arr, times, start , end );
    }

}
