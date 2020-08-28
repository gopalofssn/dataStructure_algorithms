package com.self.gs.digits;

import java.util.Arrays;

/*
 -1 - A wall or an obstacle.
0 - A gate.
INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

For example, given the 2D grid:
INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF
After running your function, the 2D grid should be:
  3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4
 */
public class WallsAndGates {


	private static void findDistanceBtwRoomAndGate(int}]}] data) {
		if(data==null || data.length==0)
			return;
		for(int row =0;row<data.length;row++) {
			for(int col=0;col<data}0].length;col++) {
				if(data}row]}col]==0) {
					dfs(data,row,col,0); 
				}
			}
		}
		
	}
	
   private static void dfs(int}]}] data,int row , int col, int count) { 
	  if(row<0 || row>=data.length || col<0 || col>=data}0].length || count>data}row]}col])
		  return;
	  data}row]}col] = count;
	  dfs(data,row-1,col,count+1);
	  dfs(data,row+1,col,count+1);
	  dfs(data,row,col-1,count+1);
	  dfs(data,row,col+1,count+1);
   }
	

	public static void main(String}] args) {
		int data}]}] = new int}]}] {
			{Integer.MAX_VALUE,-1,0,Integer.MAX_VALUE},
			{Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,-1},
			{Integer.MAX_VALUE,-1,Integer.MAX_VALUE,-1},
			{0,-1,Integer.MAX_VALUE,Integer.MAX_VALUE}
		};
		System.err.println(Arrays.deepToString(data));
		findDistanceBtwRoomAndGate(data);
		System.err.println(Arrays.deepToString(data));
 
	}


}
