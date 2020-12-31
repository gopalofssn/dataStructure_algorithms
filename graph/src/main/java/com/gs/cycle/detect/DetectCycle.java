package com.gs.cycle.detect;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DetectCycle {

	private static boolean isCycle(char[][] grid, int i) {
		Map<Character, List<Character>> graph = new HashMap<>();
	    buildGraph(grid ,graph);
	    Set<Character> visited = new HashSet<Character>();
		for(Map.Entry<Character, List<Character>> entry : graph.entrySet()){
			char vertex = entry.getKey();
			if(visited.contains(vertex)) continue;
			if(isCycleUtil(graph, vertex, visited, new HashSet<Character>())){
				System.out.println("inside cycle " + visited);
				return true;
			}
		}
		System.out.println("at end" + visited);
		return false;
	}

	private static boolean isCycleUtil(Map<Character, List<Character>> graph, char vertex, Set<Character> visited,
			HashSet<Character> visiting) {
		if(visiting.contains(vertex)){
			return true;
		}
		visited.add(vertex);
		for(char neighborVertex : graph.getOrDefault(vertex, Collections.emptyList())){
			visiting.add(vertex);
		    return isCycleUtil(graph, neighborVertex, visited, visiting);
		}
		return false;
	}

	private static void buildGraph(char[][] grid, Map<Character, List<Character>> graph) {
		for(char[] edge : grid){
			char src = edge[0];
			char dest = edge[1];
			graph.putIfAbsent(src, new ArrayList<>());
			graph.get(src).add(dest);
		}
	}
	
	public static void main(String[] args) {
		char[][] grid = {
				{'A','B'}, 
				{'B','C'},
				{'C','D'},
			};
			System.out.println("isCycle - " + isCycle(grid, 4) );

			 grid = new char[][]{
						{'A','B'}, 
						{'C','B'},
						{'B','C'},
					};
			System.out.println("isCycle - " + isCycle(grid, 3) );
					
	}
}
