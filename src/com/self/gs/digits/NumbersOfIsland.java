package com.self.gs.digits;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/*
 1 - land
 0 - water
Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00000
00011

Output: 2

land can connect horizontal , vertical and diagonal 

*/

class Solution1 {
	public static int totalPrint = 0;
	
    public int numIslands(char[][] grid) {
       int count = 0;
       
       for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				if(grid[i][j]=='1') {
					count++;
					//System.out.println("Found land at {"+i+","+j+"}");
					connectIsland(grid,i,j);
					System.out.println("******************");
					print(grid);
					System.out.println("******************");
				}
			}
       }
       
       
       return count;
    }
   
    private  Map<Integer,Integer> alreadyConnected = new Hashtable<Integer,Integer>();
    
	private void connectIsland(char[][] grid, int i, int j) {
		if(i<0 || j<0 
		   || i>=grid.length || j>=grid[i].length 
		   || grid[i][j]=='0' 
		   || (alreadyConnected.containsKey(i) && alreadyConnected.get(i)==j) )
			return;
		
		grid[i][j]='0';
		alreadyConnected.put(i, j);
		printalreadyConnected(alreadyConnected);
		
		connectIsland(grid,i+1,j); // up
		System.out.println("after finish up ");
		print(grid);
		connectIsland(grid,i-1,j); // down
		System.out.println("after finish down ");
		print(grid);
		connectIsland(grid,i,j+1);//left
		System.out.println("after finish left ");
		print(grid);
		connectIsland(grid,i,j-1); // right
		System.out.println("after finish right ");
		print(grid);
		
		
		connectIsland(grid,i+1,j+1); //diagonal  up right
		System.out.println("diagonal  up right ");
		print(grid);
		connectIsland(grid,i+1,j-1); //diagonal up left
		System.out.println("diagonal  up left ");
		print(grid);
		connectIsland(grid,i-1,j-1); //diagonal down left
		System.out.println("diagonal  down  left ");
		print(grid);
		connectIsland(grid,i-1,j+1); //diagonal up right
		System.out.println("diagonal  up right ");
		print(grid);
		
	}

	private void printalreadyConnected(Map<Integer, Integer> alreadyConnected2) {

		for (Map.Entry m:alreadyConnected.entrySet()) { 
            System.out.println("{" + m.getKey()+" "+m.getValue() + "}"); 
       } 
		
	}

	public void print(char[][] grid) {
		totalPrint++;
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				System.out.print(grid[i][j]+",");
			}
			System.out.print("\n");
		}
		
	}
    
    
}
public class NumbersOfIsland {

	public static void main(String[] args) {
		char[][] grid = new char[][]{
			{'1','1','0','1','0'},
			{'1','1','0','1','0'},
			{'0','0','0','0','0'},
			{'0','0','0','1','1'}
			};
			
			System.out.println("No of island - " + new Solution1().numIslands(grid) );
			System.out.println(new Solution1().totalPrint);
			
	}
}
