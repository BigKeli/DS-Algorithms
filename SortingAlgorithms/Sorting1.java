package SortingAlgorithms;

public class Sorting1 {
    public static void main(String[] args) {

        int [] insertionArr ={4,1,6,2,7,8,12,3,16};
        int [] selectionArr ={4,9,1,2,7,3,6,12,11,16};
        int [] bubbleSortArr={6,2,23,1,13,14,11,17,12,7};

        // Print array before insertion sort
        System.out.println(" before insertion sort: ");
        printArr(insertionArr);
        // Perform insertion sort
        insertionSort(insertionArr);
        // Print array after insertion sort
        System.out.println(" after insertion sort: ");
        printArr(insertionArr);

        // Print array before selection sort
        System.out.println(" before selection sort: ");
        printArr(selectionArr);
        // Perform selection sort
        selectionSort(selectionArr);
        // Print array after selection sort
        System.out.println(" after selection sort: ");
        printArr(selectionArr);

        // Print array before bubble sort
        System.out.println(" before bubble sort:  ");
        printArr(bubbleSortArr);
        // Perform bubble sort
        bubbleSort(bubbleSortArr);
        // Print array after bubble sort
        System.out.println(" after bubble sort:  ");
        printArr(bubbleSortArr);
    }

    // Insertion Sort Algorithm
    public static void insertionSort(int[] Array) {

        int length = Array.length;
        for (int i = 1; i < length; ++i) {
            int value = Array[i];
            int j = i - 1;
            // Shift elements of Array[0..i-1] that are greater than value
            while (j >= 0 && Array[j] > value) {
                Array[j + 1] = Array[j];
                j = j - 1;
            }
            // Place value at its correct position
            Array[j + 1] = value;
        }
    }

    // Selection Sort Algorithm
    public static void selectionSort(int[] Array) {
        for (int i = 0; i < Array.length; i++) {
            int Minimum = i;
            // Find the minimum element in the unsorted part
            for (int j = i+1; j < Array.length; j++) {
                if (Array[j] < Array[Minimum]) {
                    Minimum = j;
                }
            }
            // Swap the found minimum element with the first unsorted element
            mover(Array, Minimum, i);
        }
    }



    // Bubble Sort Algorithm
    static void bubbleSort(int array[])
    {
        boolean moved;
        int x;
        int n = array.length;

        for (int i = 0; i < n-1; i++) {
            moved = false;
            // Compare adjacent elements and swap if needed
            for (int j = 0; j < n-1; j++) {
                if (array[j] > array[j + 1]) {
                    x = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = x;
                    moved = true;
                }
            }
            // If no elements were moved, the array is sorted
            if (moved == false)
                break;
        }
    }

    // Print array elements
    public static void printArr(int[] Array) {
        for (int i = 0; i < Array.length; i++) {
            System.out.print(Array[i] + " ");
        }
        System.out.println();
    }

    // Swap elements at specified indices
    static void mover(int[] array, int hereindx, int thereindx) {
        int temp = array[hereindx];
        array[hereindx] = array[thereindx];
        array[thereindx] = temp;
    }
}