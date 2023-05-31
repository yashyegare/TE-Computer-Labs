import java.util.*;

public class NQueensProblem {
    private int[] queens; // Array to store column positions of queens
    private int numSolutions; // number of soutions found

    public NQueensProblem(int n) {
        queens = new int[n]; // Initialize array with size n
    }

    public void solve() {
        solve(0); // Start solving from the first row (row 0)
    }

    private void solve(int row) {
        if (row == queens.length) { // Base case: If all queens are placed (reached the last row)
            numSolutions++; // Increment the number of solutions
            printSolution(); // print solution
        } else {
            for (int col = 0; col < queens.length; col++) { // Iterate through all columns in the current row
                queens[row] = col; // Place the queen at column 'col' in the current row
                if (isValid(row, col)) { // Check if the placement is valid
                    solve(row + 1); // Recursively move to the next row
                }
            }
        }
    }

    private boolean isValid(int row, int col) {
        for (int i = 0; i < row; i++) { // Iterate through previously placed queens
            int diff = Math.abs(queens[i] - col); // Calculate the column difference
            if (diff == 0 || diff == row - i) { // Check for conflicts horizontally or diagonally
                return false;
            }
        }
        return true;
    }

    private void printSolution() {
        if (numSolutions == 1) {
            System.out.print("Solution: ");
            for (int i = 0; i < queens.length; i++) {
                System.out.print(queens[i] + " "); // Print column positions of queens for each row
            }
            System.out.println();
            System.out.println("The Matrix Representation:");
            int[][] arr = new int[queens.length][queens.length];
            for (int i = 0; i < queens.length; i++) {
                for (int j = 0; j < queens.length; j++) {
                    if ((j) == queens[i]) {
                        arr[i][j] = 1; // Set the position as 1 if queen is present
                    } else {
                        arr[i][j] = 0; // Set the position as 0 if no queen is present
                    }
                }
            }
            for (int i = 0; i < queens.length; i++) {
                for (int j = 0; j < queens.length; j++) {
                    System.out.print(arr[i][j] + " "); // Print the matrix representation
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter N Queens Problem: ");
        int n = in.nextInt();
        NQueensProblem NQueensProblem = new NQueensProblem(n);
        NQueensProblem.solve();
    }
}
