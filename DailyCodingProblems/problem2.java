/* package whatever; // don't place package name! */

/*
This problem was asked by Uber.

Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.

For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].

Follow-up: what if you can't use division?
*/


import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		int a[] = {1, 2, 3, 4, 5};
		int ltr[] = new int[a.length];
		int rtl[] = new int[a.length];
		ltr[0] = a[0];
		for(int i=1;i<a.length;i++)
			ltr[i] = ltr[i-1] * a[i-1];
		rtl[a.length-1] = 1;
		for(int i=a.length-2;i>=0;i--)
			rtl[i] = rtl[i+1] * a[i+1];
		for(int i=0;i<a.length;i++)
			System.out.print(ltr[i]*rtl[i]+" ");
	}
}