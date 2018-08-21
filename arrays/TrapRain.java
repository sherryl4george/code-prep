/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

class TrapRain{
	int a[] = {3,0,1,3};
	
	public TrapRain(){
		// a = {3,0,1,3};
	}
	//O(n2) time O(n) space
	public void withStack(){
		Stack<Integer> stack = new Stack<>();
		int water = 0;
		for(int i=0;i<a.length;i++){
			while(!stack.isEmpty() && a[i] > a[stack.peek()]){
				int top = stack.pop();
				int distance = i - stack.peek() - 1;
				water += distance * ( Math.min(a[i] , a[stack.peek()]) - a[top] );
			}
			stack.push(i);
		}
		System.out.println(water);
	}
	//O(n) time O(n) space
	public void withArray(){
		int left[] = new int[a.length]	;
		int right[] = new int[a.length]	;
		int water = 0;
		left[0] = a[0];
		right[a.length-1] = a[a.length-1];
		for(int i=1;i<a.length;i++){
		left[i] = Math.max(a[i],left[i-1]);
		// System.out.print(left[i]);
		}
		for(int i=a.length-2;i>=0;i--){
		right[i] = Math.max(a[i],right[i+1]);
		// System.out.print(left[i]);
		}
		for(int i=0;i<a.length;i++)
		water+= Math.min(left[i],right[i]) - a[i];
			System.out.println(water);
	}
	
	public void rainTrap(){
		int left_max = -999;
		int right_max = -999;
		int right = a.length;
		int left = 0;
		int water = 0;
		// while(left<right){
		// 	if(a[left]>left_max){
		// 		left_max = a[left];
		// 		// water += left_max - arr[i]	;
		// 	}
		// }
	}
}

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		TrapRain t1 = new TrapRain();
		// t1.withStack();
		t1.withArray();
		// your code goes here
	}
}