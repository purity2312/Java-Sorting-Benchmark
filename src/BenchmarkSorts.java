/**
 * Name: Yechan Lim
 * UMGC CMSC 451
 * Project 1: The project involves benchmarking the behavior of Java implemenations of insertion sort and heap sort.
 * Date: November 12, 2024
 * BenchmarkSorts class perform the benchmarking and generate two data files, one for each of the two sorting algorithms.
 * Java 21
 */


import java.io.FileWriter;
import java.util.Arrays;
import java.util.Random;

public class BenchmarkSorts {

	public static void main(String[] args) throws Exception {
		
		// initial array size
		int arraySize = 100;
		
		
		FileWriter heapWriter = new FileWriter("HeapSortResult.txt");
		FileWriter insertWriter = new FileWriter("InsertionResult.txt");
		HeapSort heap = new HeapSort();
		InsertionSort insert = new InsertionSort();
		
		// run sorts for 12 different sizes of data sets
		for (int l = 0; l < 12; l++) {
			heapWriter.write(arraySize + " ");
			insertWriter.write(arraySize + " ");
			
			// run sorts for 40 data sets for each value of arraySize
			for (int val = 0; val < 40; val++) {
				
				int[] array1 = createRandomArray(arraySize);
				int[] array2 = array1.clone();
				int[] array3 = array1.clone();
				
				// perform sorting
				heap.sort(array1);
				insert.sort(array2);
				Arrays.sort(array3);
				
				// Verify the correctness of the algorithm
				for (int i = 0; i < array1.length; i++) {
					if (array1[i] != array3[i]) {
						throw new Exception("Heap sort did not sort correctly.");
					}
					if (array2[i] != array3[i]) {
						throw new Exception("Insertion sort did not sort correctly.");
					}
				}
				
				// write data on a file
				heapWriter.write(heap.getCount() + " " + heap.getTime() + " ");
				insertWriter.write(insert.getCount() + " " + insert.getTime() + " ");
				
			}
			
			arraySize += 100;
			heapWriter.write("\n");
			insertWriter.write("\n");
			

		}
		heapWriter.close();
		insertWriter.close();
		System.out.println("Successfully generated the data files.");

	}
	
	// create array of random integers
	public static int[] createRandomArray(int size) {
		Random rand = new Random();
		int arr[] = new int[size];
		for (int j = 0; j < arr.length; j++) {
			arr[j] = rand.nextInt(0, 1000);
			
		}
		return arr;
	}

}
