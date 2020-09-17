package com.gs.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TwoDArrayLevelOrderDataCollection {
	
	private static List<List<Integer>> collect(int[][] grid) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(grid == null || grid.length == 0) return result;
		
		final int ROWS = grid.length;
		final int COLS = grid[0].length;
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visited = new boolean[ROWS][COLS];
		queue.offer(new int[]{0, 0});
		visited[0][0] = true;
		int[][] directions = { {1, 0}, {0, 1} };
		boolean reverseLevelOrderData = true;
		
		while(!queue.isEmpty()){
			int sz = queue.size();
			LinkedList<Integer> levelListData = new LinkedList<>();
			for(int i = 0; i < sz; i++){
				int[] current = queue.poll();
				int row = current[0];
				int col = current[1];
				
				if(reverseLevelOrderData){
				  levelListData.addFirst(grid[row][col]);
				}else{
				  levelListData.addLast(grid[row][col]);
				}
				
				for(int[] dir : directions ){
					addToQueue(row + dir[0], col + dir[1], queue, visited);
				}
			}
			result.add(levelListData);
			reverseLevelOrderData = !reverseLevelOrderData;
		}
		return result;
	}
	
	private static void addToQueue(int row, int col, Queue<int[]> queue, boolean[][] visited) {
		if(row >= visited.length || col >= visited[0].length || visited[row][col]){
			return;
		}
		
		visited[row][col] = true;
		queue.add(new int[]{row, col});
	}
	
	public static void main(String[] args) {
		int[][] grid = {
						 {1,   2,  3,  4},
						 {5,   6,  7,  8},
						 {9,  10, 11, 12},
						 {13, 14, 15, 16}
						};
		List<List<Integer>> result = collect(grid);
		for(List<Integer> level : result){
			System.out.println(level);
		}
	}



}
