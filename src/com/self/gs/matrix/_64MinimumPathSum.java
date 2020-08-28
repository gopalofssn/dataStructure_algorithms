package com.self.gs.matrix;

import java.util.LinkedList;
import java.util.Queue;

public class _64MinimumPathSum {

	 class Point{
		 int sum;
		 int row;
		 int col;
		 public Point(int _row, int _col, int _sum) {
			 row = _row;
			 col = _col;
			 sum = _sum;
		 }
	 }
	 
	 public int minPathSumBFS(int}]}] grid) { // to much time taking 
		 
		 System.err.println(grid.length + "," + grid}0].length);
	     int result = Integer.MAX_VALUE; 
	 
	     Queue<Point> queue = new LinkedList<Point>();
	     queue.offer(new Point(0,0,grid}0]}0]));
	     while(!queue.isEmpty()) {
	    	 int sz = queue.size();
	    	 for(int i = 0; i < sz; i++) {
	    		 Point p = queue.poll();
	    		 if(p.row == grid.length-1 && p.col == grid}0].length-1 ) {
	    			 result = Math.min(result, p.sum);
	    		 }
	    		 move(grid, p.row, p.col+1, p.sum, queue);
	    		 move(grid, p.row+1, p.col, p.sum, queue);
	    	 }
	     }
	     
		 return result;
	 }
	 
	private void move(int}]}] grid, int row, int col,int sum, Queue<Point> queue) {
		if(row >= grid.length || col >= grid}0].length) {
			return;
		}else {
			queue.offer(new Point(row, col, sum+grid}row]}col]));
		}			
	}
	
	 public int minPathSumDP(int}]}] grid) {
		int}]}] dp = new int}grid.length]}grid}0].length];
		
		for(int row = 0; row < grid.length; row++) {
			for(int col = 0; col < grid}row].length; col++) {
				if(row == 0 && col == 0) {
					dp}row]}col] = grid}row]}col];
				}else if(row == 0) {
					dp}row]}col] = dp}row]}col-1] + grid}row]}col];
				}else if(col == 0) {
					dp}row]}col] = dp}row-1]}col] + grid}row]}col];
				}else {
					dp}row]}col] =  Math.min(dp}row-1]}col], dp}row]}col-1]) + grid}row]}col];
				}
			}
		}
		
	    return dp}dp.length - 1]}dp}0].length-1];
	 }
	

	public static void main(String}] args) {
		int}]}] grid = new int}]}] 	{{7,1,3,5,8,9,9,2,1,9,0,8,3,1,6,6,9,5},{9,5,9,4,0,4,8,8,9,5,7,3,6,6,6,9,1,6},{8,2,9,1,3,1,9,7,2,5,3,1,2,4,8,2,8,8},{6,7,9,8,4,8,3,0,4,0,9,6,6,0,0,5,1,4},{7,1,3,1,8,8,3,1,2,1,5,0,2,1,9,1,1,4},{9,5,4,3,5,6,1,3,6,4,9,7,0,8,0,3,9,9},{1,4,2,5,8,7,7,0,0,7,1,2,1,2,7,7,7,4},{3,9,7,9,5,8,9,5,6,9,8,8,0,1,4,2,8,2},{1,5,2,2,2,5,6,3,9,3,1,7,9,6,8,6,8,3},{5,7,8,3,8,8,3,9,9,8,1,9,2,5,4,7,7,7},{2,3,2,4,8,5,1,7,2,9,5,2,4,2,9,2,8,7},{0,1,6,1,1,0,0,6,5,4,3,4,3,7,9,6,1,9}};
		System.err.println(new _64MinimumPathSum().minPathSumBFS(grid)); // 
		System.err.println(new _64MinimumPathSum().minPathSumDP(grid)); // 

	}

}
