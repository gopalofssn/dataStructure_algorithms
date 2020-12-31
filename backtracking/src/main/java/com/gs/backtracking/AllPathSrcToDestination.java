package com.gs.backtracking;

import java.util.*;

public class AllPathSrcToDestination {

	private static List<List<Integer>> findAllpath(int[][] grid) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		helper(grid, 0, 0, new LinkedList<>(), result);
		return result;
	}

	private static void helper(int[][] grid, int row, int col, LinkedList<Integer> current, List<List<Integer>> result) {
		if(isOutOfBoundary(grid, row, col)) return;
		System.out.println("visiting cell (" + row + ", " + col + ")" );
		current.addLast(grid[row][col]);
		if(isEnd(grid, row, col)){
			result.add(new LinkedList<>(current));
		}else{
			int[][] directions = { {0, 1} , {1, 0} };
			for(int[] dir : directions){
				helper(grid, row + dir[0], col + dir[1], current, result);
			}
		}
		current.removeLast();
	}

	private static boolean isEnd(int[][] grid, int row, int col) {
		return (row == grid.length -1) && (col == grid[0].length - 1);
	}

	private static boolean isOutOfBoundary(int[][] grid, int row, int col) {
		if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) return true;
		return false;
	}

	public static void main(String[] args) {
		int[][] grid = { 
							{1, 2, 3, 4},
							{5, 6, 7, 8},
							{9, 10, 11, 12},
							{13,14,15,16}
						};
		List<List<Integer>> result = findAllpath(grid);
		System.out.println("Total possible path " + result.size());
		for (List<Integer> list : result) {
			System.out.println(list);
		}
	}

}
