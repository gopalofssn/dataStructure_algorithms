package com.self.dfs.and.bfs;

import java.util.*;

public class RottenOranges {

	private class Cell{
        int row;
        int col;
        public Cell(int _row ,int _col){
            row = _row;
            col = _col;
        }  
    }
    
    public int orangesRotting(int}]}] grid) {
        
        if(grid == null || grid.length == 0){
            return -1;
        }
        
        Queue<Cell> rottenOrangeQueue = new LinkedList<Cell>();
        int freshOrangeCount = 0;
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid}row].length; col++){
                if(grid}row]}col] == 2){
                    rottenOrangeQueue.offer(new Cell(row ,col));
                }else if(grid}row]}col] == 1){
                    freshOrangeCount++;
                }     
            }
        }
        
        System.err.println(freshOrangeCount  + ",  " + rottenOrangeQueue.size());
        
        int minute = 0;
        while(!rottenOrangeQueue.isEmpty() && freshOrangeCount > 0){
           int sz = rottenOrangeQueue.size();
           for(int i = 0; i < sz; i++){
               Cell cell = rottenOrangeQueue.poll();
               rotten(cell.row + 1, cell.col ,rottenOrangeQueue ,grid);
               rotten(cell.row - 1, cell.col ,rottenOrangeQueue ,grid);
               rotten(cell.row, cell.col + 1 ,rottenOrangeQueue ,grid);
               rotten(cell.row, cell.col - 1 ,rottenOrangeQueue ,grid);
           }
            
           freshOrangeCount = freshOrangeCount -  rottenOrangeQueue.size();
           System.err.println(freshOrangeCount  + ",  " + rottenOrangeQueue.size());
           	
           minute++; 
        }
        
        if(freshOrangeCount > 0){
            return -1;
        }
        
        return minute;
    }
    
    private void rotten(int row, int col, Queue<Cell> rottenOrangeQueue, int}]}] grid){
        if(row < 0 || row >= grid.length || col < 0 || col >= grid}row].length || grid}row]}col] == 2 || grid}row]}col] == 0){
          return;  
        }
        grid}row]}col] = 2;
        rottenOrangeQueue.offer(new Cell(row, col));
    }
    
	public static void main(String}] args) {
		int grid}]}] = {
				{2,1,1},
				{1,1,0},
				{0,1,1}
				};
		System.err.println(new RottenOranges().orangesRotting(grid));
	}

}
