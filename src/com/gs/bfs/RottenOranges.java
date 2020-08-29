package com.gs.bfs;

import java.util.LinkedList;
import java.util.Queue;

import com.gs.model.Cell;

/*
   2 - rotten orange
   1 - fresh orange
   0 - empty cell
 */
public class RottenOranges {
 
	private int orangesRotting(int[][] grid) {
	    if(grid == null || grid.length == 0) return 0;
	    
	    int freshOranges = 0;
	    Queue<Cell> queue = new LinkedList<Cell>();
	    
	    freshOranges = helper(grid, queue); // load rotten into queue and get fresh count
	    int minutes = 0;
	    while(!queue.isEmpty()){
	    	int sz = queue.size();
	    	int infectedCount = 0;
	    	for(int i = 0; i < sz; i++){
	    		Cell current = queue.poll();
	    		infectedCount += infectneighbours(grid, current, queue);
	    	}

	    	freshOranges -= infectedCount;
	    	minutes++;
	    	
	    	if(freshOranges == 0) return minutes;
	    	
	    }
	    
		return (freshOranges == 0)? minutes : -1;
	}

	private int infectneighbours(int[][] grid, Cell current, Queue<Cell> queue) {
		int[][] directions = { {1, 0}, {0, 1},{-1, 0},{0, -1} };
		int row = current.row;
		int col = current.col;
		int infectedCount = 0;
		for(int[] dir : directions){
			int nextRow = row + dir[0];
			int nextCol = col + dir[1];
			boolean isNextCellInfected = infectNextCell(grid, queue, nextRow, nextCol);
			if(isNextCellInfected) infectedCount++;
		}
		return infectedCount;
	}

	private boolean infectNextCell(int[][] grid, Queue<Cell> queue, int row, int col) {
		
		if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != 1){
			return false;
		}
		grid[row][col] = 2;
		queue.offer(new Cell(row, col));
		return true;
	}

	private int helper(int[][] grid, Queue<Cell> queue) {
		int freshOranges = 0;
		for(int row = 0; row < grid.length; row++){
	    	for(int col = 0; col < grid[row].length; col++){
	    		if(grid[row][col] == 1){
	    			freshOranges++;
	    		}else if(grid[row][col] == 2)
	    			queue.offer(new Cell(row, col));
	    		}
	    }
		return freshOranges;
	}
    
	public static void main(String[] args) {
		int grid[][] = {
				{2,1,1},
				{1,1,0},
				{0,1,1}
				};
		System.err.println(new RottenOranges().orangesRotting(grid));
	}



}
