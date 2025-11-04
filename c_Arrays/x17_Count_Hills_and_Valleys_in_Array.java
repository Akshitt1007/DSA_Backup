package c_Arrays;
import java.util.ArrayList;

// 2210. Count Hills and Valleys in an Array
// https://leetcode.com/problems/count-hills-and-valleys-in-an-array/description/?envType=daily-question&envId=2025-07-27

public class x17_Count_Hills_and_Valleys_in_Array {
    public static void main(String[] args) {

        System.out.println( countHillValley_1ms(new int[]{6, 6, 5, 5, 4, 1}));
        System.out.println( countHillValley_1ms(new int[]{18, 87, 35, 78, 74, 3, 86, 66, 60, 7, 67}));
        System.out.println( countHillValley_1ms(new int[]{1, 1, 2, 2, 2, 2, 2, 1}));

        System.out.println( countHillValley_0ms(new int[]{6, 6, 5, 5, 4, 1}));
        System.out.println( countHillValley_0ms(new int[]{18, 87, 35, 78, 74, 3, 86, 66, 60, 7, 67}));
        System.out.println( countHillValley_0ms(new int[]{1, 1, 2, 2, 2, 2, 2, 1}));

    }

    public static int countHillValley_0ms(int[] arr) {
        int count = 0;

        for (int i = 1; i < arr.length - 1; i++) {

            if (arr[i] == arr[i - 1]) {
                continue;
            }

            // to go to far left side till index 1 if there are duplicates
            int left = i - 1;
            while (left >= 0 && arr[left] == arr[i]) {
                left--;
            }

            // to go to far right side till index length-1 if there are duplicates
            int right = i + 1;
            while (right < arr.length && arr[right] == arr[i]) {
                right++;
            }

            if (left >= 0 && right < arr.length) {
                if ((arr[left] < arr[i] && arr[right] < arr[i]) || (arr[left] > arr[i] && arr[right] > arr[i])) {
                    //   for hill and valley check
                    count++;
                }
            }
        }
        return count;
    }

    public static int countHillValley_1ms(int[] arr) {
        ArrayList<Integer> nums = new ArrayList<>();

        for( int i=0 ; i<arr.length-1 ; i++ ){
            if( arr[i] == arr[i+1] ){
                continue;
            }
            else{
                nums.add( arr[i] );
            }
        }
        nums.add(arr[arr.length-1]);

        int hill = 0;
        int valley = 0;

        for (int i = 1; i < nums.size() - 1; i++) {
            int prev = nums.get(i - 1);
            int curr = nums.get(i);
            int next = nums.get(i + 1);

            if (curr > prev && curr > next) {
                hill++;
            } else if (curr < prev && curr < next) {
                valley++;
            }
        }
        return valley + hill;
    }
}
