package algorithms;

import java.util.Arrays;

public class Sort {

	public static void main(final String args[]){
		System.out.println("Hello World!");
		int[] array = {7, 2, 1, 5, 3, 8, 4, 6};
		int[] a2 = Arrays.copyOf(array, array.length);
		printArray(array);
		mergeSort(array, 0, array.length - 1);
		printArray(array);
		//quicksort(a2, 0, a2.length - 1);
		//printArray(a2);
	}
	
	public static void mergeSort(int[] array, int start, int end) {
		//check if end - start == 0
		if(end == start) {
			return;
		}
		int middle = start + (end - start)/2;
		//split left half
		mergeSort(array, start, middle);
		//split right half
		mergeSort(array, middle+1, end);
		//merge both halves
		int i = start;
		int j = middle + 1;
		int k = start;
		int[] newArray = Arrays.copyOf(array, array.length);
		while(i <= middle && j <= end) {
			if(newArray[i] <= newArray[j]) {
				array[k] = newArray[i];
				i++; k++;
			} else {
				array[k] = newArray[j];
				j++; k++;
			}
		}
		while(i <= middle) {
			array[k] = newArray[i];
			i++; k++;
		}
	}
	
	public static void quicksort(int[] array, int start, int end) {
		int i = start;
		int j = end;
		int pivot = array[start + (end - start)/2];
		
		while(i <= j) {
			//if elements to the left are less than pivot move on
			while(array[i] < pivot) i++;
			
			//to the right of the pivot, advance until element is no longer > pivot
			while(array[j] > pivot) j--;
			
			//perform swap operation, first checking that i, j are still within bounds
			if(i <= j) {
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				i++; j--;
			}	
		}
		//if loop terminates and quicksort isn't finished, recursively quicksort
		if(start < j) quicksort(array, start, j);
		if(end > i) quicksort(array, i, end);
	}
	
	public static void printArray(int[] a) {
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
}
