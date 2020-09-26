package com.gs.bfs;

import java.util.LinkedList;
import java.util.Queue;
/*
   2 - rotten orange
   1 - fresh orange
   0 - empty cell
 */
public class RottenOranges {
 
	private int orangesRotting(int[][] grid) {
	    if(grid == null || grid.length == 0) return 0;
	    int freshOranges = 0;
	    Queue<int[]> rottenOrangeQueue = new LinkedList<int[]>();
	    for(int row = 0; row < grid.length; row++){
	    	for(int col = 0; col < grid[0].length; col++){
	    		int val = grid[row][col];
	    		if(val == 2) rottenOrangeQueue.offer(new int[]{row, col});
	    		else if(val == 1) freshOranges++;
	    	}
	    }
	    
	    int hours = 0;
	    while(!rottenOrangeQueue.isEmpty() && freshOranges != 0){
	    	int sz = rottenOrangeQueue.size();
	    	int infectedCount = 0;
	    	for(int i = 0; i < sz; i++){
	    		int[] current = rottenOrangeQueue.poll();
	    		int[][] directions = { {-1,0}, {1, 0}, {0, -1}, {0, 1} };
	    		for(int[] dir : directions){
	    			int row = current[0] + dir[0];
	    			int col = current[1] + dir[1];
	    			if(hasInfected(grid, row, col, rottenOrangeQueue)){
	    				infectedCount++;
	    			}
	    		}
	    	}
	    	if(infectedCount == 0) return -1;
	        hours++;
	    	freshOranges -= infectedCount;
	    }
	    return (freshOranges == 0) ? hours: -1;
	}
	
	private boolean hasInfected(int[][] grid, int row, int col, Queue<int[]> rottenOrangeQueue) {
		if(isValidBoundary(grid, row, col) || grid[row][col] != 1) return false;
		rottenOrangeQueue.offer(new int[]{row, col});
		grid[row][col] = 2;
		return true;
	}

	private boolean isValidBoundary(int[][] grid, int row, int col) {
		return (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length );
	}

	public static void main(String[] args) {
		int grid[][] = {
				{2,1,1},
				{1,1,0},
				{0,1,1}
				};
		System.err.println(" Hour to rotten all of oranges :  " + new RottenOranges().orangesRotting(grid)); //4
	}
}
