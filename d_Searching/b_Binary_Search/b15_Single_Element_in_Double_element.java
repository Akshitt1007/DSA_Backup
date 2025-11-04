package d_Searching.Binary_Search;

public class b15_Single_Element_in_Double_element {
    public static void main(String[] args) {

        int [] arr_1 = {1,1,2,3,3,4,4,8,8};
        int [] arr_2 = {3,3,7,7,10,11,11};

        System.out.println( "The single element is: " + singleNonDuplicate( arr_1 ));
        System.out.println( "The single element is: " + singleNonDuplicate( arr_2 ));
    }
    static int singleNonDuplicate(int[] nums) {

        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            // Ensure mid is even so we can check pairs correctly
            if (mid % 2 == 1) {
                mid--;
            }

            // If mid and mid+1 are equal, the single element is on the right side
            if (nums[mid] == nums[mid + 1]) {
                start = mid + 2; // Move right
            }
            // Otherwise, the single element is on the left side
            else {
                end = mid; // Move left
            }
        }
        // The start (or end) index will hold the single element
        return nums[start];
    }
}
