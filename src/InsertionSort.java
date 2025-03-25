/**
 * Name: Yechan Lim
 * UMGC CMSC 451
 * Project 1: The project involves benchmarking the behavior of Java implemenations of insertion sort and heap sort.
 * Date: November 12, 2024
 * InsertionSort sorts an array using insertion sort.
 * Reference for the sorting algorithm: 
 * GeeksforGeeks. (October 7, 2024). Insertion sort algorithm. https://www.geeksforgeeks.org/insertion-sort-algorithm/
 * Java 21
 */

// Java program for implementation of Insertion Sort

public class InsertionSort extends AbstractSort{
    /* Function to sort array using insertion sort */
	
	
    public void sort(int arr[])
    {
    	startSort();
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
            	incrementCount();
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        endSort();
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

}

/* This code is contributed by Hritik Shah. */
