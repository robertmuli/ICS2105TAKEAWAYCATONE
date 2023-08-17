package ICS2105TAKEAWAYCATONE;

public class leftrotatearray {
    static void leftRotate(int arr[], int d, int n) {
        // Perform d left rotations
        for (int i = 0; i < d; i++) {
            // Store the first element in a temporary variable
            int temp = arr[0];
            // Shift all elements to the left by one position
            for (int j = 0; j < n - 1; j++)
                arr[j] = arr[j + 1];
            // Move the first element to the end of the array
            arr[n - 1] = temp;
        }
    }

    public static void main(String[] args) {
        // Initialize the array and its size
        int a[] = {1, 2, 3, 4, 5};
        int n = a.length;
        // Set the number of left rotations to perform
        int d = 2;
        // Perform the left rotations
        leftRotate(a, d, n);
        // Print the updated array
        for (int i = 0; i < n; i++)
            System.out.print(a[i] + " ");
    }
}