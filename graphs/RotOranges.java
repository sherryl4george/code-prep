/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

class RotOranges{
	Loc delim;
	int R = 3; int C = 5;
	int arr[][] = { {2, 1, 0, 2, 1},
                     {0, 0, 1, 2, 1},
                     {1, 0, 0, 2, 1}};
private class Loc{
	int x;
	int y;
	public Loc(int x, int y){
		this.x = x;
		this.y = y;
	}
	public int getX(){
		return this.x;
	}
	public int getY(){
		return this.y;
	}
}
public RotOranges(){
	delim = new Loc(-1,-1);
}
public boolean isValid(int r, int c){
		return r>=0 && r<R && c>=0 && c<C;
	}
	
	public  int rotOranges(){
		Queue<Loc> q = new LinkedList<>();
		// Loc delim = new Loc(-1,-1);
		int count = 0;
		for(int i = 0; i<R;i++)
			for(int j=0;j<C;j++)
				if(arr[i][j]==2)
					q.add(new Loc(i,j));
				
		q.add(delim);
		while(!q.isEmpty()){
			Loc temp = q.poll();
			int x = temp.getX();
			int y = temp.getY();
          
			if(temp.equals(delim))
			{	
			
				if(!q.isEmpty()){
				q.add(delim);
				count++;
				}
				
				continue;
			}
			
			if(isValid(x-1,y) && arr[x-1][y]==1){
              
				arr[x-1][y]=2;
				q.add(new Loc(x-1,y));
			}
			if(isValid(x+1,y) && arr[x+1][y]==1){
				arr[x+1][y]=2;
				q.add(new Loc(x+1,y));
			}
			if(isValid(x,y-1) && arr[x][y-1]==1){
				arr[x][y-1]=2;
				q.add(new Loc(x,y-1));
			}
			if(isValid(x,y+1) && arr[x][y+1]==1){
				arr[x][y+1]=2;
				q.add(new Loc(x,y+1));
			}
			// for(int i = 0; i<R;i++){
			// 	System.out.println("");
			// for(int j=0;j<C;j++)
			// 	System.out.print(arr[i][j]+" ");
			// }
		}
			for(int i = 0; i<R;i++)
			for(int j=0;j<C;j++)
				if(arr[i][j]==1)
					return -1;
		return count;
	}
}

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	// static int R = 3; static int C = 3;
	// public static boolean isValid(int r, int c){
	// 	return r>=0 && r<R && c>=0 && c<C;
	// }
	// public static int rotOranges(int arr[][]){
	// 	Queue<Loc> q = new LinkedList<>();
	// 	Loc delim = new Loc(-1,-1);
		
	// 	for(int i = 0; i<R;i++){
	// 		for(int j=0;j<C;j++){
	// 			if(arr[i][j]==2){
	// 				q.add(new Loc(i,j));
	// 			}}}
	// q.add(delim);
		
	// }
	public static void main (String[] args) throws java.lang.Exception
	{
		int arr[][] = { {2, 1, 0, 2, 1},
                        {1, 0, 1, 2, 1},
                        {1, 0, 0, 2, 1}};
                         RotOranges r1 = new  RotOranges();
		int ans = r1.rotOranges();
		System.out.println("Rotten Oranges: "+ans);
	}
}