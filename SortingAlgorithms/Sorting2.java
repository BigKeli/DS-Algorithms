package SortingAlgorithms;

public class Sorting2 {
    public static void main(String[] args) {

        // Arrays to be sorted using different sorting algorithms
        int[] heapArr = {6, 3, 4, 1, 10, 16};
        int[] mergeArr = {7, 4, 8, 1, 10, 12, 11};
        int[] quickArr = {5, 3, 8, 2, 10, 12, 11, 4, 6};

        // Print the array before performing heap sort
        System.out.println("Array before heap sort: ");
        printArray(heapArr);

        // Perform heap sort on the array
        heapSort(heapArr);

        // Print the array after heap sort
        System.out.println("Array after heap sort: ");
        printArray(heapArr);

        // Print the array before performing merge sort
        System.out.println("Array before merge sort: ");
        printArray(mergeArr);

        // Perform merge sort on the array
        mergeSort(mergeArr);

        // Print the array after merge sort
        System.out.println("Array after merge sort: ");
        printArray(mergeArr);

        // Print the array before performing quick sort
        System.out.println("Array before quick sort:  ");
        printArray(quickArr);

        // Perform quick sort on the array
        quickSort(quickArr);

        // Print the array after quick sort
        System.out.println("Array after quick sort:  ");
        printArray(quickArr);
    }

    // Merge two subarrays of arr[]
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    static void merge(int arr[], int l, int m, int r) {
        int arr1Size = m - l + 1;
        int arr2Size = r - m;
        int Left[] = new int[arr1Size];
        int Right[] = new int[arr2Size];

        // Copy data to temporary arrays Left[] and Right[]
        for (int i = 0; i < arr1Size; ++i)
            Left[i] = arr[l + i];
        for (int j = 0; j < arr2Size; ++j)
            Right[j] = arr[m + 1 + j];

        int i = 0, j = 0;
        int x = l;

        // Merge the temporary arrays back into arr[]
        while (i < arr1Size && j < arr2Size) {
            if (Left[i] <= Right[j]) {
                arr[x] = Left[i];
                i++;
            } else {
                arr[x] = Right[j];
                j++;
            }
            x++;
        }

        // Copy remaining elements of Left[] if any
        while (i < arr1Size) {
            arr[x] = Left[i];
            i++;
            x++;
        }

        // Copy remaining elements of Right[] if any
        while (j < arr2Size) {
            arr[x] = Right[j];
            j++;
            x++;
        }
    }

    // Recursive merge sort function
    // Divides the array into halves and merges them
    static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int mid = l + (r - l) / 2;
            mergeSort(arr, l, mid);  // Sort first half
            mergeSort(arr, mid + 1, r);  // Sort second half
            merge(arr, l, mid, r);  // Merge the sorted halves
        }
    }

    // Wrapper method for mergeSort with initial parameters
    static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    // Partition function for quicksort
    // Rearranges elements based on the pivot
    static int Holder(int[] arr, int start, int fin) {
        int pivot = arr[fin];
        int i = (start - 1);

        // Rearrange array elements based on the pivot
        for (int j = start; j <= fin - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, fin);
        return (i + 1);
    }

    // Public quicksort method
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    // Recursive quicksort function
    // Sorts elements by selecting a pivot and partitioning the array
    static void quickSort(int[] arr, int first, int last) {
        if (first < last) {
            int piv = Holder(arr, first, last);
            quickSort(arr, first, piv - 1);  // Sort elements before the pivot
            quickSort(arr, piv + 1, last);  // Sort elements after the pivot
        }
    }

    // Heap sort function
    // Builds a heap and sorts the array
    public static void heapSort(int arr[]) {
        int len = arr.length;

        // Build heap (rearrange array)
        for (int i = len / 2 - 1; i >= 0; i--)
            heap(arr, len, i);

        // Extract elements from heap one by one
        for (int i = len - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Call max heapify on the reduced heap
            heap(arr, i, 0);
        }
    }

    // To heapify a subtree rooted with node curr
    // Maintains the heap property
    static void heap(int arr[], int len, int curr) {
        int biggest = curr;
        int left = 2 * curr + 1;
        int right = 2 * curr + 2;

        // Check if left child exists and is greater than root
        if (left < len && arr[left] > arr[biggest])
            biggest = left;

        // Check if right child exists and is greater than root
        if (right < len && arr[right] > arr[biggest])
            biggest = right;

        // Swap and continue heapifying if root is not the largest
        if (biggest != curr) {
            int swap = arr[curr];
            arr[curr] = arr[biggest];
            arr[biggest] = swap;
            heap(arr, len, biggest);
        }
    }

    // Method to swap two elements in an array
    static void swap(int[] arr, int here, int there) {
        int temp = arr[here];
        arr[here] = arr[there];
        arr[there] = temp;
    }

    // Method to print elements of an array
    public static void printArray(int[] print) {
        for (int i = 0; i < print.length; i++) {
            System.out.print(print[i] + " ");
        }
        System.out.println();
    }
}