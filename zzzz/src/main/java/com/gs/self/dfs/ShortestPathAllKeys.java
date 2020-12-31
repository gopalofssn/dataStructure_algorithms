package com.gs.self.dfs;

import java.util.*;

public class ShortestPathAllKeys {

	/*
	 @ . . . a
	 . # # # A
	 . B c C b
	 */
public int shortestPathAllKeys(String[] grid) {
        
        Set<Character> expectedKeys = new HashSet<Character>();
        Queue<int[]> queue = new LinkedList<int[]>();
        boolean[][] visited  = new boolean[grid.length][];
            
        for(int row = 0; row < grid.length; row++){
            int colLen = grid[row].length();
            visited[row] = new boolean[colLen];
            for(int col = 0; col < colLen; col++){
                char c = grid[row].charAt(col);
                if(Character.isLowerCase(c)){
                    expectedKeys.add(c);
                }else if(c == '@'){
                    queue.offer(new int[]{row, col});
                    visited[row][col] = true;
                }
            }
        }
        
        Set<Character> collectedKeys = new HashSet<Character>();
        
        int steps = 0;
        while(!queue.isEmpty()){
            int sz = queue.size();
            for(int i = 0; i < sz; i++){
                int[] current = queue.poll();
                addNeighboursToQueue(grid, queue, current, collectedKeys, visited);
            }
            steps++;
            if(expectedKeys.size() == collectedKeys.size()){
                return steps;
            }
            
        }
        
        return (expectedKeys.size() == collectedKeys.size()) ? steps : -1;
    }
    
    private void addNeighboursToQueue(String[] grid, Queue<int[]> queue, int[] current, Set<Character> collectedKeys, boolean[][] visited){
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for(int[] dir : directions){
            addToQueue(grid, queue, current[0] + dir[0] , current[1] + dir[1], collectedKeys, visited);
        }
    }
    
    private void addToQueue(String[] grid,Queue<int[]> queue, int row , int col, Set<Character> collectedKeys, boolean[][] visited){
       if(row < 0 || row >= grid.length || col < 0 || col >= grid[row].length() || visited[row][col]){
	            return;
	        }
	        char c = grid[row].charAt(col);
	        if(c == '#'){
	            visited[row][col] = true;
	        }else if(Character.isLowerCase(c)){
	        	visited[row][col] = true;
	           queue.add(new int[]{row, col});
	           collectedKeys.add(c);
	        }else if(Character.isUpperCase(c) && collectedKeys.contains(Character.toLowerCase(c))){
	        	queue.add(new int[]{row, col});
	            visited[row][col] = true;
	        }else if( c == '.'){
	          queue.add(new int[]{row, col});
	          visited[row][col] = true;
	        }
        
    }
	    
	public static void main(String[] args) {
		String[] grid = {"@.a.#",
				         "###.#",
				         "b.A.B"};
		
		//System.err.println(new ShortestPathAllKeys().shortestPathAllKeys(grid));
		
		grid = new String[]{"@Aa"};
		//System.err.println(new ShortestPathAllKeys().shortestPathAllKeys(grid));

		grid = new String[]{"@...a",".###A",".BcCb"};
		System.err.println(new ShortestPathAllKeys().shortestPathAllKeys(grid));

	}

}
