package com.gs.self.dfsbfscombination;

import java.util.*;

public class ShortestBridge {


	private int shortestBridge(int[][] grid) {
		
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		outerloop:
		for(int row = 0; row < grid.length; row++){
			for(int col = 0; col < grid[0].length; col++){
				if(grid[row][col] == 1){
					addToQueue(grid, row, col, queue, visited);
					break outerloop;
				}
			}
		}
		
		return helper(grid, queue, visited);
	}
	
    private int helper(int[][] grid, Queue<int[]> queue, boolean[][] visited) {
		
    	int steps = 0;
    	while(!queue.isEmpty()){
    		System.out.println("step " + steps);
    		int sz = queue.size();
    		for(int i = 0; i < sz; i++){
    			int[] current = queue.poll();
    			System.out.println(Arrays.toString(current));
    			 int[][] directions = { {0, -1} , {0, 1}, {-1, 0}, {1, 0} };
    			 for(int[] dir : directions){
    				 int row = current[0] + dir[0];
    				 int col = current[1] + dir[1];
    				 if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || visited[row][col]){
    					 continue;
    				 }
    				 if(grid[row][col] == 1){
    					 return steps;
    				 }
    				 queue.offer(new int[]{row, col});
    				 visited[row][col] = true;
    			 }
    		}
    		steps++;
    	}
		return -1;
	}

	private void addToQueue(int[][] grid, int row, int col, Queue<int[]> queue, boolean[][] visited ) {
		 if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || visited[row][col] || grid[row][col] != 1){
			 return;
		 }
		 queue.offer(new int[]{row, col});
		 visited[row][col] = true;
		 int[][] directions = { {0, -1} , {0, 1}, {-1, 0}, {1, 0} };
		 for(int[] dir : directions){
			 addToQueue(grid, row + dir[0], col + dir[1], queue, visited);
		 } 
	 }

	public static void main(String[] args) {
        int[][] A = {
        		        {0, 0, 1, 0},
	                    {0, 1, 1, 1},
	                    {0, 0, 0, 1},
	                    {1, 0, 0, 0},
	                    {1, 0, 0, 0}
                    };
        
        System.out.println("Ans - " + new ShortestBridge().shortestBridge(A));
        
      }

    }





/*

  
	 private class Cell{
	        int row;
	        int col;
	        public Cell(int row, int col){
	            this.row = row;
	            this.col = col;
	        }
	    }
	    
	    public int shortestBridge(int[][] grid) {
	        if(grid == null || grid.length == 0) return 0;
	        Queue<Cell> queue = new LinkedList<Cell>();
	        boolean[][] visited = new boolean[grid.length][];
	        for(int row = 0; row < grid.length; row++){
	            visited[row] = new boolean[grid[row].length];
	        }
	        //dfs
	        findFirstIslandCorners(grid, queue, visited);
	        
	        
	        //dfs
	        int steps = 0;
	        while(!queue.isEmpty()){
	            int sz = queue.size();
	            for(int i = 0; i< sz; i++){
	                Cell current = queue.poll();
	                if(hasFoundSecondIsLandCorner(grid, queue, current, visited)){
	                    return steps;
	                }
	            }
	            steps++;
	        }
	        
	        return -1;
	    }
	    
	    private void findFirstIslandCorners(int[][] grid, Queue<Cell> queue, boolean[][] visited){
	        for(int row = 0; row < grid.length; row++){
	            for(int col = 0; col < grid[row].length; col++){
	                if(grid[row][col] == 1){
	                   dfs(grid, queue, row, col, visited);
	                   return;
	                }
	            }
	        }
	    }
	    
	    private void dfs(int[][] grid, Queue<Cell> queue, int row, int col, boolean[][] visited){
	    	if(!isValidBoundary(grid, row, col)){
	            return;
	        }

	    	if(visited[row][col] || grid[row][col] != 1){
	            return;
	        }
	        
	        visited[row][col] = true;
	        queue.offer(new Cell(row, col));
	        
	        int[][] directions = { {1,0}, {0,1}, {-1, 0}, {0, -1}};
	        for(int[] dir : directions){
	            dfs(grid, queue, row + dir[0], col + dir[1], visited);
	        }
	        
	    }
	   
	    private boolean hasFoundSecondIsLandCorner(int[][] grid, Queue<Cell> queue, Cell current, boolean[][] visited){
	        
	    	boolean found = false;
	    	
	    	int[][] directions = { {1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	        for(int[] direction : directions){
	            found = found || bfshelper(grid, queue, current.row + direction[0] ,  current.col + direction[1], visited);
	        }
	        return found;
	    }
	    
	    private boolean bfshelper(int[][] grid, Queue<Cell> queue, int row, int col, boolean[][] visited){
	        if(!isValidBoundary(grid, row, col)){
	            return false;
	        }
	        
	        if(visited[row][col]) {
	            return false;
	        }
	        
	        if(grid[row][col] == 1){
	            return true;
	        }
	        
	        visited[row][col] = true;
	        queue.offer(new Cell(row, col));
	        
	        return false;
	        
	    }
	    
	    private boolean isValidBoundary(int[][] grid, int row, int col){
	        if(row >= 0 && row < grid.length && col >= 0 && col < grid[row].length)
	            return true;
	        
	        return false;
	    }
      
*/