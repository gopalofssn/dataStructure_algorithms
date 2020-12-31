package com.self.gs.graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/*
  FloydWarshall Matrix based approach
  Find total Numbers Of Vertex
  build matrix 
     - for unknown distance , fill INT MAX
 */
public class AllPairShortestPath {
	
	private static int[][] findAllPairShortestPath(int[][] adjList) {
		if(adjList == null || adjList.length == 0) return new int[0][];
		int vertices = findTotalNumbersOfVertex(adjList);
		int[][] matrix = new int[vertices][vertices];
		fillMatrixWithAdjacencyList(matrix, adjList);
		allPairShortestPathHelper(matrix);
		return matrix;
	}
	
	
	private static void allPairShortestPathHelper(int[][] matrix) {
		for(int k = 0; k < matrix.length; k++){
			for(int i = 0; i < matrix.length; i++){
				for(int j = 0; j < matrix.length; j++){
					int current = matrix[i][j];
					int viaPoint =  viaPointHelper(matrix[i][k] , matrix[k][j]);
					matrix[i][j] = Math.min(current, viaPoint);
				}
			}
		}
	}


	private static int viaPointHelper(int i, int j) {
		if(i == Integer.MAX_VALUE || j == Integer.MAX_VALUE) return Integer.MAX_VALUE;
		return i + j;
	}

	private static void fillMatrixWithAdjacencyList(int[][] matrix, int[][] adjList) {
		for(int[] mat : matrix){
			Arrays.fill(mat,  Integer.MAX_VALUE);
		}
		for(int[] edge : adjList){
			int row = edge[0] - 1;
			int col = edge[1] - 1;
			int dist = edge[2];
			matrix[row][col] = dist;
		}
		
	}

	private static int findTotalNumbersOfVertex(int[][] adjList) {
		Set<Integer> vetices = new HashSet<Integer>();
		for(int row = 0; row < adjList.length; row++){
			vetices.add(adjList[row][0]);
			vetices.add(adjList[row][1]);
		}
		return vetices.size();
	}

	public static void main(String[] args) {
		  // GIVEN : SRC DEST distance - directed graph
		  int[][] adjList = {
	              {1, 2, 3},
	              {2, 1, 8},
	              {2, 3, 2},
	              {3, 4, 1},
	              {3, 1, 5},
	              {4, 1, 2},
	              {1, 4, 7}
	            };
		  int[][] shortestPathMatrix = findAllPairShortestPath(adjList);
		  for(int[] row : shortestPathMatrix){
		    	 System.out.println(Arrays.toString(row));
		  }
		    
		  for(int row = 0 ; row < shortestPathMatrix.length; row++){
		       for(int col = 0; col < shortestPathMatrix[0].length; col++){
		    		 if(row == col) continue;
		    		 System.out.println("SRC " + (row + 1)  + " TO DEST " + (col + 1)  + " - " + shortestPathMatrix[row][col]);
		    	 }
		  }  
	}
}
