package c_Arrays;

public class c4_JaggedArray {
    public static void main(String[] args) {
        // Declare a jagged 2D array
        int[][] jaggedArray = new int[3][];

        // Initialize each row with different column lengths
        jaggedArray[0] = new int[3]; // 1st row with 3 columns
        jaggedArray[1] = new int[5]; // 2nd row with 5 columns
        jaggedArray[2] = new int[2]; // 3rd row with 2 columns

        // Fill the jagged array with values
        // Row 1: 3 columns
        for (int i = 0; i < jaggedArray[0].length; i++) {
            jaggedArray[0][i] = i + 1; // Filling with 1, 2, 3
        }

        // Row 2: 5 columns
        for (int i = 0; i < jaggedArray[1].length; i++) {
            jaggedArray[1][i] = (i + 1) * 10; // Filling with 10, 20, 30, 40, 50
        }

        // Row 3: 2 columns
        for (int i = 0; i < jaggedArray[2].length; i++) {
            jaggedArray[2][i] = (i + 1) * 100; // Filling with 100, 200
        }

        // Print the jagged array
        System.out.println("Jagged Array Output:");
        for (int i = 0; i < jaggedArray.length; i++) {
            for (int j = 0; j < jaggedArray[i].length; j++) {
                System.out.print(jaggedArray[i][j] + " ");
            }
            System.out.println(); // Move to the next line after each row
        }
    }
}
