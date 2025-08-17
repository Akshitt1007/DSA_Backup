package c_Arrays;

public class x14_2D_multiplication {
    public static void main(String[] args) {

        int[][] arr1 = {{1, 2, 3}, {1, 2, 3}, {1, 2, 3}};
        int[][] arr2 = {{1, 2, 3}, {1, 2, 3}, {1, 2, 3}};

        int r1 = arr1.length;
        int c1 = arr1[0].length;
        int r2 = arr2.length;
        int c2 = arr2[0].length;

        // Validate matrix multiplication dimensions
        if (c1 != r2) {
            System.out.println("Matrix multiplication not possible with these dimensions.");
            return;
        }

        int[][] x = new int[r1][c2];

        // Matrix multiplication logic
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int k = 0; k < c1; k++) {
                    x[i][j] += arr1[i][k] * arr2[k][j];  // Corrected logic
                }
            }
        }

        // Output result
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[0].length; j++) {
                System.out.print(x[i][j] + " ");
            }
            System.out.println();
        }
    }
}
