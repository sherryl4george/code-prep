/* package whatever; // don't place package name! */

/* 
This problem was recently asked by Google.

Given a list of numbers and a number k, return whether any two numbers from the list add up to k.

For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.

Bonus: Can you do this in one pass?
*/

import java.util.*;
import java.lang.*;
import java.io.*;


/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int a[] = {10, 15, 3, 7};
		int key = 17;
		Set<Integer> s = new HashSet<>();
		for(int i=0;i<a.length;i++)
		{
			int diff = Math.abs(key - a[i]);
			if(s.contains(diff))
				System.out.println("yes");
			s.add(a[i]);
		}
	}
}