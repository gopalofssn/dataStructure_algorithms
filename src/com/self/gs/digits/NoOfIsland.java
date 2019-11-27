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
	
   private static void dfs(int[][] mat,int row,int col,boolean[][] visited) {
	   System.out.println(row + " ," + col +","+( mat[0].length));
		 if(row<0 || col<0 || row>=mat.length || col>=mat[0].length || visited[row][col] || mat[row][col]==0) {
			 
			 return;
		 }
		 
		 visited[row][col] = true;
		 
		 dfs(mat,row+1,col,visited);
		 dfs(mat,row-1,col,visited);
		 dfs(mat,row,col+1,visited);
		 dfs(mat,row,col-1,visited);
		 dfs(mat,row-1,col+1,visited);
		 dfs(mat,row-1,col-1,visited);
		 dfs(mat,row+1,col+1,visited);
		 dfs(mat,row+1,col-1,visited);
	}

public static void main(String[] args) {
	int mat[][] = {
		    {1, 1, 0, 0, 0},
            {0, 1, 0, 0, 1},
            {1, 0, 0, 1, 1},
            {0, 0, 0, 0, 0},
            {1, 0, 1, 0, 1} 
	    };
	
	System.out.println(noOfInslan(mat));
   }


}
