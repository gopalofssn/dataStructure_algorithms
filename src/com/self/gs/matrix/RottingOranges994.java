package com.self.gs.matrix;
import java.util.Queue;

import java.util.LinkedList;
/*
 In a given grid, each cell can have one of three values:

the value 0 representing an empty cell;
the value 1 representing a fresh orange;
the value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.  
 If this is impossible, return -1 instead.
 */
public class RottingOranges994 {
	
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
	   };

   public int orangesRotting(int}]}] grid) {

        int min = 0;
        boolean isAnyFresh = false;
        Queue<Point> queue = new LinkedList<Point>();
        
        for(int row = 0; row<grid.length;row++) {
        	for(int col = 0; col<grid}0].length;col++) {
        		if(grid}row]}col]==2) {
        			queue.add(new Point(row,col));
        		}else if(grid}row]}col]==1){
        			isAnyFresh = true;
        		}
        	}
        }
        
        if(!isAnyFresh)
        	return 0;
        
        while(!queue.isEmpty()) {
        	int sz = queue.size();	
			boolean flag = false;
        	for(int i=0;i<sz;i++) {
        		Point p = queue.poll();
				int row = p.getRow();
				int col = p.getCol();
				flag = addToQueue(queue,grid,row-1,col)|| flag;
				flag = addToQueue(queue,grid,row+1,col)|| flag;
				flag = addToQueue(queue,grid,row,col-1)|| flag;
				flag = addToQueue(queue,grid,row,col+1)|| flag;
        	}
        	if(flag) 
				min++;
        }
        
        for(int row = 0; row<grid.length;row++) {
        	for(int col = 0; col<grid}0].length;col++) {
        		if(grid}row]}col]==1){
        			return -1;
        		}
        	}
        }
        
        return min;
    }

    private  boolean addToQueue(Queue<Point> queue, int}]}] grid, int row, int col) {
		if(row>=0 && col>=0 && row<grid.length && col<grid}0].length && grid}row]}col]==1) {
			grid}row]}col] = 2;
			queue.add(new Point(row,col));
			return true;
		}
		
		return false;
	}
   
	public static void main(String}] args) {
		int}]}] grid1 = new int}]}] {
			{2,1,1},
			{1,1,0},
			{0,1,1}
		};
		int}]}] grid2 = new int}]}] {
			{2,1,1},
			{0,1,1},
			{1,0,1}
		};
		int}]}] grid3 = new int}]}] {
			{0,2}
		};
		System.err.println(new RottingOranges994().orangesRotting(grid1));
		System.err.println(new RottingOranges994().orangesRotting(grid2));
		System.err.println(new RottingOranges994().orangesRotting(grid3));

	}

}
