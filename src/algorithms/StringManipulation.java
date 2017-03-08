package algorithms;

import java.util.Arrays;
/**
 * This class demonstrates different algorithms that manipulate strings in interesting ways.
 * @author Ian
 *
 */
public class StringManipulation {
	
	public static String reverseString(String str) {	
		char[] array = str.toCharArray();
		for(int j= 0, k = array.length - 1; j < array.length; j++, k--) {
			if(j >= k) {
				break;
			}
			char temp = array[k];
			array[k] = array[j]; 
			array[j] = temp;
		}
		return Arrays.toString(array);
	}
}
