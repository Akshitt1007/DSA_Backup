package c_Arrays;

import java.util.*;

public class x4_Spiral_Matrix {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>(); // To store the final spiral order

        if (matrix.length == 0) return result; // Edge case: empty matrix

        // Define boundaries
        int top = 0; // Starting row
        int bottom = matrix.length - 1; // Last row
        int left = 0; // Starting column
        int right = matrix[0].length - 1; // Last column

        // Loop until all elements are visited
        while (top <= bottom && left <= right) {

            // 1️⃣ Traverse from Left to Right across the top row
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++; // Move the top boundary down

            // 2️⃣ Traverse from Top to Bottom down the right column
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--; // Move the right boundary left

            // 3️⃣ Traverse from Right to Left along the bottom row (if still within bounds)
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--; // Move the bottom boundary up
            }

            // 4️⃣ Traverse from Bottom to Top up the left column (if still within bounds)
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++; // Move the left boundary right
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        List<Integer> spiral = spiralOrder(matrix);
        System.out.println("Spiral Order: " + spiral); // Output: [1, 2, 3, 6, 9, 8, 7, 4, 5]
    }
}
