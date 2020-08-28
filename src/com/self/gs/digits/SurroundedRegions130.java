package com.self.gs.digits;

import java.util.*;

/*
 Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example:

X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
Explanation:

Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.
 */

public class SurroundedRegions130 {
	class Point{
		int r;
		int c;
		public Point(int _r,int _c) {
			r = _r;
			c = _c;
		}
	}
	 public  void solve(char}]}] grid) {
	      if(grid==null || grid.length==0)
	    	  return;
	      int rowLen = grid.length;
	      int colLen = grid}0].length;
	      
	      Queue<Point> queue = new LinkedList<Point>();
	      boolean}]}] isVisited = new boolean}rowLen]}colLen];
	      for(int col=0;col<colLen;col++) {
	    	  if(grid}0]}col]=='o') 
	    		  addToQueue(grid,queue,0,col,isVisited);
	    	  if(grid}rowLen-1]}col]=='o') 
	    		  addToQueue(grid,queue,rowLen-1,col,isVisited);  
	      }
	      
	      for(int row=0;row<rowLen;row++) {
	    	  if(grid}row]}0]=='o') 
	    		  addToQueue(grid,queue,row,0,isVisited);
	    	  if(grid}row]}colLen-1]=='o') 	    		  
	    		  addToQueue(grid,queue,row,colLen-1,isVisited);
	      }
	      
	      while(!queue.isEmpty()) {
                  Point p = queue.poll();
	    		  int row = p.r;
	    		  int col = p.c;
	    		  addToQueue(grid,queue,row-1,col,isVisited);
	    		  addToQueue(grid,queue,row+1,col,isVisited);
	    		  addToQueue(grid,queue,row,col-1,isVisited);
	    		  addToQueue(grid,queue,row,col+1,isVisited);
	      }
	      for(int row=0;row<rowLen;row++) {
	    	  for(int col=0;col<colLen;col++) {
	    		  
	    		  if(grid}row]}col] == 'o')
	    			  grid}row]}col] = 'x';
	    		  
	    		  if(grid}row]}col] == '+')
	    			  grid}row]}col] = 'o';
	    		  
	    	  }
	      }
	    }

	private void addToQueue(char}]}] grid,Queue<Point> queue, int row, int col,boolean}]}] isVisited) {
		if(row<0 || row>=grid.length || col<0 || col>=grid}row].length || isVisited}row]}col] || grid}row]}col] =='x') { 
			return;
		}else{
			grid}row]}col] = '+';
			isVisited}row]}col]=true;
			queue.offer(new Point(row,col));
		}
	}
	public static void main(String}] args) {
		char}]}] board = new char}]}] {
			{'x','x','x','x'},	
			{'x','o','o','x'},	
			{'x','x','o','x'},	
			{'x','o','x','x'},
		};
		new SurroundedRegions130().solve(board);
		System.err.println(Arrays.deepToString(board));
		
		board = new char}]}] {
			{'o','o','o'},	
			{'o','o','o'},
			{'o','o','o'}
		};
		new SurroundedRegions130().solve(board);
		System.err.println(Arrays.deepToString(board));
		
		board = new char}]}] {
			{'o','x','x','o','x'},
			{'x','o','o','x','o'},
			{'x','o','x','o','x'},
			{'o','x','o','o','o'},
			{'x','x','o','x','o'}
		};
		
		/*
		}}o, x, x, o, x], 
		 }x, x, x, x, o], 
		 }x, x, x, o, x], 
		 }o, x, o, o, o], 
		 }x, x, o, x, o]]
		 */
		new SurroundedRegions130().solve(board);
		System.err.println(Arrays.deepToString(board));
		
		
	}

}
