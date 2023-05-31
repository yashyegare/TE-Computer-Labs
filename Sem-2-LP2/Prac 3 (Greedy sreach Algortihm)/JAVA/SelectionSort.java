import java.util.*;

public class SelectionSort {
    // Method to perform selection sort
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        // Iterate through the array
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i; // min index is initalised to keep track of minimum element found during each
                             // iterartion
            // Find the index of the minimum element in the unsorted portion
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }

            // Swap the minimum element with the current element
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the size of the input: ");
        int n = in.nextInt();
        int arr[] = new int[n]; // array of size n to store input elements
        System.out.println("Enter the elements of the array");

        for (int i = 0; i < n; i++) {
            System.out.print("Enter the " + (i + 1) + " element: ");
            arr[i] = in.nextInt();
        }
        System.out.println("Unsorted array:");
        // Display the unsorted array
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        selectionSort(arr);
        System.out.println("\nSorted array:");
        // Display the sorted array
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
