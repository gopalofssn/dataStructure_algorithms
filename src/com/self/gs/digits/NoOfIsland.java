package com.self.gs.digits;

import java.util.Arrays;

public class NoOfIsland {
	

	private static int noOfInslan(int[][] mat) {
		if(mat==null || mat.length<1)
			return 0;
        int result = 0; 
        boolean visited[][] = new boolean[mat.length][mat[0].length];
        for(int row=0 ; row<mat.length ; row++) {
        	for(int col=0; col<mat[row].length; col++) {
        		if(mat[row][col]==1 && !visited[row][col]) {
        			result+=1;
        			dfs(mat,row,col,visited);
        	        System.out.println(Arrays.deepToString(visited));
        		}
        	}
        }
		return result;
	}
	
	private static void dfs(int[][] grid,int row,int col,boolean[][] isVisited){
        if(row<0 || row>=grid.length || col<0 || col>=grid[0].length || isVisited[row][col] || grid[row][col] == 0)
            return;
        isVisited[row][col]=true;
        dfs(grid,row-1,col,isVisited);
        dfs(grid,row+1,col,isVisited);
        dfs(grid,row,col-1,isVisited);
        dfs(grid,row,col+1,isVisited);
    }

public static void main(String[] args) {
	/*int mat[][] = {
		    {1, 1, 0, 0, 0},
            {0, 1, 0, 0, 1},
            {1, 0, 0, 1, 1},
            {0, 0, 0, 0, 0},
            {1, 0, 1, 0, 1} 
	    };*/
	int[][] mat = {
			{1,1,1,1,0},
			{1,1,0,1,0},
			{1,1,0,0,0},
			{0,0,0,0,0}		
	};
	System.out.println(noOfInslan(mat));
   }


}
