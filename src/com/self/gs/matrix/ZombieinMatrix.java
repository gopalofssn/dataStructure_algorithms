package com.self.gs.matrix;
import java.util.Queue;
import java.util.Arrays;
import java.util.LinkedList;
/*
 Given a 2D grid, each cell is either a zombie 1 or a human 0. Zombies can turn adjacent (up/down/left/right) human beings into zombies every hour. Find out how many hours does it take to infect all humans?
																						----------------------
Example:

Input:
}}0, 1, 1, 0, 1],
 }0, 1, 0, 1, 0],
 }0, 0, 0, 0, 1],
 }0, 1, 0, 0, 0]]

Output: 2

Explanation:
At the end of the 1st hour, the status of the grid:
}}1, 1, 1, 1, 1],
 }1, 1, 1, 1, 1],
 }0, 1, 0, 1, 1],
 }1, 1, 1, 0, 1]]

At the end of the 2nd hour, the status of the grid:
}}1, 1, 1, 1, 1],
 }1, 1, 1, 1, 1],
 }1, 1, 1, 1, 1],
 }1, 1, 1, 1, 1]]
 */



public class ZombieinMatrix {

	  class Point{
		private int row;
		private int col;
		public Point(int _row,int _col) {
			row = _row;
			col = _col;
		}
		public int getRow() {
			return this.row;
		}
		public int getCol() {
			return this.col;
		}
	}
	
	private int minHour(int}]}] grid) {
		int hour = 0;
		Queue<Point> queue = new LinkedList<Point>();
		
		for(int row = 0; row < grid.length; row++) {
			for(int col = 0 ; col<grid}0].length; col++) {
				if(grid}row]}col]==1)
					queue.add(new Point(row,col)); // locate zombies	and add in queue			
			}
		}
		
		while(!queue.isEmpty()) {
			int sz = queue.size();
			boolean flag = false;
			for(int i =0; i<sz; i++) {
				Point p = queue.poll();
				int row = p.getRow();
				int col = p.getCol();
				flag = addToQueue(queue,grid,row-1,col)|| flag;
				flag = addToQueue(queue,grid,row+1,col)|| flag;
				flag = addToQueue(queue,grid,row,col-1)|| flag;
				flag = addToQueue(queue,grid,row,col+1)|| flag;				
			}
			if(flag) 
				hour++;
		}
		
		return hour;
	}
	
	// border  check and convert human as zombie
	private   boolean addToQueue(Queue<Point> queue, int}]}] grid, int row, int col) {
		if(row>=0 && col>=0 && row<grid.length && col<grid}0].length && grid}row]}col]==0) {
			grid}row]}col] = 1;
			queue.add(new Point(row,col));
			return true;
		}
		
		return false;
	}

	public static void main(String}] args) {
		int}]}] grid = new int}]}] {
			{0, 1, 1, 0, 1},
			{0, 1, 0, 1, 0},
			{0, 0, 0, 0, 1},
			{0, 1, 0, 0, 0}	
		};
  System.err.println(new ZombieinMatrix().minHour(grid));
	}

	

}
