package g_Recursion.e_Subsets_Permutation_BackTracking;

public class b4_House_Robbery {
    public static void main(String[] args) {

        int[] house = { 2, 1, 1, 9};

        System.out.println( rob(house) );
    }

    public static int rob(int[] nums) {

        return helper(nums, 0, nums.length);
    }

    public static int helper(int[] nums, int i, int n){

        if( i>=n ) {
            return 0;
        }

        int steal = nums[i] + helper(nums, i+2, n);

        int skip = helper(nums, i+1, n);

        if( steal > skip ){
            return steal;
        }
        else{
            return skip;
        }
    }
}
