/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;
/**
Given an array of integers, find the first missing positive integer in linear time and constant space. In other words, find the lowest positive integer that does not exist in the array. The array can contain duplicates and negative numbers as well.

For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.

You can modify the input array in-place.
**/
/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static int firstPostitive(int[] arr){
		int j = 0;
		for(int i=0;i<arr.length;i++){
			if(arr[i]<=0){
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				j++;
			}
		}
		arr = Arrays.copyOfRange(arr,j,arr.length);
		for(int i=0;i<arr.length;i++){
			if(arr[i]-1<arr.length && arr[arr[i]-1] > 0 ){
				arr[arr[i]-1] *= -1;
			}
		}	
		for(int i=0;i<arr.length;i++){
			if(arr[i]>0){
				return i+1;
			}
		}
		return arr.length + 1;
		
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		int arr[] = {-1,-2, 41,42};
		System.out.print("The first smallest +ve number: "+firstPostitive(arr));
	}
}
