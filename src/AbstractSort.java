/**
 * Name: Yechan Lim
 * UMGC CMSC 451
 * Project 1: The project involves benchmarking the behavior of Java implemenations of insertion sort and heap sort.
 * Date: November 12, 2024
 * AbstracSort class is a abstract class for HeapSort and InsertionSort.
 * Java 21
 */

public abstract class AbstractSort {
	private long count;
	private long startTime;
	private long elapsedTime;
	
	
	public abstract void sort(int[] arr);
	
	public void startSort() {
		count = 0;
		startTime = System.nanoTime();
	}
	
	public void endSort() {
		elapsedTime = System.nanoTime() - startTime;
		
	}
	
	public void incrementCount() {
		count++;
	}
	
	public long getCount() {
		return count;
	}
	
	public long getTime() {
		return elapsedTime;
		
	}
}
