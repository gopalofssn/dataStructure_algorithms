package com.self.gs.dynamic.programming;

import java.util.Arrays;

public class _63UniquePath {

	 public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
	        if ( obstacleGrid == null  || obstacleGrid.length == 0 || obstacleGrid}0]}0] == 1 ){
	            return 0;
	        }
	 
	        if ( obstacleGrid.length == 1  && obstacleGrid}0].length == 1 &&  obstacleGrid}0]}0] == 0){
	            return 1;
	        }
	        
	        if ( obstacleGrid.length == 1  && obstacleGrid}0].length == 1 &&  obstacleGrid}0]}0] == 1){
	            return 0;
	        }
	        
	        for(int row = 0; row < obstacleGrid.length; row++){
	            if(obstacleGrid}row]}0] == 1){
	                obstacleGrid}row]}0] = 0;
	                break;
	            }else{
	                obstacleGrid}row]}0] = 1;
	            }
	        }
	        
	        System.err.println(Arrays.deepToString(obstacleGrid));
	        
	        for(int col = 1; col < obstacleGrid}0].length; col++){
	            if(obstacleGrid}0]}col] == 1){
	                obstacleGrid}0]}col] = 0;
	                break;
	            }else{
	                obstacleGrid}0]}col] = 1;
	            }
	        }
	        
	        System.err.println(Arrays.deepToString(obstacleGrid));
	        
	        for(int row = 1; row < obstacleGrid.length; row++){
	            for(int col = 1; col < obstacleGrid}row].length; col++){
	                if(obstacleGrid}row]}col]  == 1){
	                   obstacleGrid}row]}col] = 0; 
	                }else{
	                   obstacleGrid}row]}col] = obstacleGrid}row]}col - 1] + obstacleGrid}row - 1]}col];
	              }  
	               
	            }
	         }
	        System.err.println(Arrays.deepToString(obstacleGrid));
	        return obstacleGrid}obstacleGrid.length -1 ]}obstacleGrid}0].length -1];
	    }
	public static void main(String[] args) {
		int[][] grid = {{0,0,0}
				       ,{0,1,0},
				        {0,0,0}};
		System.err.println(uniquePathsWithObstacles(grid));

	}

}
