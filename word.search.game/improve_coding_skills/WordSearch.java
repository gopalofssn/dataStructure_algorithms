package improve_coding_skills;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordSearch {

	private static boolean[] isAvail(char[][] grid, String[] words) {
		Map<Character, List<int[]>> map = fillCharMap(grid);
		boolean[] isAvail = new boolean[words.length];
		int counter = 0;
		for(String word : words){
			isAvail[counter++] = isAvail(grid, map, word);
		}
		return isAvail;
	}
	
	private static boolean isAvail(char[][] grid, Map<Character, List<int[]>> map, String word) {
		if(word == null || word.trim().isEmpty()) return false;
		char firstChar = word.charAt(0);
		if(word.trim().length() == 1) return map.containsKey(firstChar);
		
		int[][] directions = { {-1, -1}, {-1, 0} , {-1, 1},
				 			   {0, -1},            {0, 1},
				               {1, -1},  {1, 0},   {1, 1}
				             };
		for(int[] pos : map.getOrDefault(firstChar, Collections.emptyList())){
			for(int[] dir : directions){
				if(dfs(grid, pos, dir, word, 1))
				  return true; 
			}
		}
		return false;
	}

	private static boolean dfs(char[][] grid, int[] pos, int[] dir, String word, int index) {
		int row = pos[0] + dir[0];
		int col = pos[1] + dir[1];
		if(row < 0 || row >= grid.length || col < 0 || col >= grid.length){
			return false;
		}else if(index == word.length() -1){
			return word.charAt(index) == grid[row][col];
		}else if(word.charAt(index) != grid[row][col]){
			return false;
		}else{
			return dfs(grid, new int[]{row, col}, dir, word, index + 1);
		}
	}

	private static Map<Character, List<int[]>> fillCharMap(char[][] grid) {
		Map<Character, List<int[]>> map = new HashMap<Character, List<int[]>>();
		for(int row = 0; row < grid.length; row++){
			for(int col = 0; col < grid[0].length; col++){
				char c = grid[row][col];
				map.putIfAbsent(c, new ArrayList<int[]>());
				map.get(c).add(new int[]{row, col});
			}
		}
		return map;
	}

	public static void main(String[] args) {
		char[][] grid = {
							{'a', 'p', 'e'},
							{'n', 'w', 't'},
							{'t', 'o', 'p'}
						};
		String[] words = {"an", "to", "we", "wet","p"};
		System.out.println(Arrays.toString(isAvail(grid, words)));
	}


}
