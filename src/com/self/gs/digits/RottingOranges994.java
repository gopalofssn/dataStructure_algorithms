package com.self.gs.digits;
import java.util.*;

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
	}
  public int orangesRotting(int}]}] grid) {

	if(grid == null || grid.length == 0)
           return 0;
       
    
      Queue<Point> queue = new LinkedList<Point>();
	 
       int fresh = 0;
       for(int row = 0; row < grid.length; row++){
           for(int col = 0; col < grid}0].length; col++){
              if(grid}row]}col] == 2) {
                  queue.offer(new Point(row, col));
              }else if(grid}row]}col] == 1){
                  fresh++;
              }
           }
       }
       
       if(fresh != 0 && queue.isEmpty())
           return -1;
       
       int minNum = 0;
       while(fresh != 0 && !queue.isEmpty()){
           int sz = queue.size();
           for(int i = 0; i < sz; i++){
               Point p = queue.poll();
               if(isAdjacentRotted(grid, p.row-1, p.col, queue))
                   fresh--;
               if(isAdjacentRotted(grid, p.row+1, p.col, queue))
                   fresh--; 
               if(isAdjacentRotted(grid, p.row, p.col-1, queue))
                   fresh--;
               if(isAdjacentRotted(grid, p.row, p.col+1, queue))
                   fresh--;
           }
           minNum++;
       }
       
       if(fresh != 0)
           return -1;
       else
           return minNum;
   }
   
   private boolean isAdjacentRotted(int}]}] grid, int row, int col, Queue<Point> queue){
       if(row < 0 || col < 0 || row >= grid.length || col >= grid}0].length || grid}row]}col] != 1){
           return  false;
       }else{
           grid}row]}col] = 2;
           queue.offer(new Point(row, col));
           return true;
       }
   }

	public static void main(String}] args) {
		int}]}] grid1 = new int}]}] {
			{2,1,1},
			{1,1,0},
			{0,1,1}
		};
		int}]}] grid2 = new int}]}] {
			{2,1,1},
			{1,1,0},
			{0,1,1}
		};
		int}]}] grid3 = new int}]}] {
			{2,1,1},
			{0,1,1},
			{1,0,1}
		};
		
		int}]}] grid4 = new int}]}] { {1}};
		System.err.println(new RottingOranges994().orangesRotting(grid4));

		
		System.err.println(new RottingOranges994().orangesRotting(grid1));
		System.err.println(new RottingOranges994().orangesRotting(grid2));
		System.err.println(new RottingOranges994().orangesRotting(grid3));

	}

}
