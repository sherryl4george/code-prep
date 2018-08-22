/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

class EditDistance{
	String s1, s2;
	int t[][];
	public EditDistance(){
		s1 = "kitten";
		s2 = "sitting";
		t= new int[s1.length()+1][s2.length()+1];
	}
	public int editDistance(){
		for(int i=0;i<=s1.length();i++)
			t[i][0] = i;
		for(int i=0;i<=s2.length();i++)
			t[0][i] = i;
		for(int i=1;i<=s1.length();i++)
			for(int j=1;j<=s2.length();j++){
			if(s1.charAt(i-1) == s2.charAt(j-1))
			t[i][j] = Math.min(t[i-1][j], Math.min(t[i-1][j-1],t[i][j-1]));
			else
			t[i][j] = 1 + Math.min(t[i-1][j], Math.min(t[i-1][j-1],t[i][j-1]));
			}
		return t[s1.length()][s2.length()];
		
	}
	
}

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		EditDistance e1 = new EditDistance();
		System.out.println(e1.editDistance());
	}
}