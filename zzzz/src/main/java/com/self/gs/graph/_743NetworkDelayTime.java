package com.self.gs.graph;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class _743NetworkDelayTime {

	private static class Pair{
		public Pair(int k, int i) {
			label = k;
			dest = i;
		}
		int label;
		int dest;
	}

	public static int networkDelayTime(int[][] times, int N, int K) {

		 
		Map<Integer, Map<Integer, Integer>> graph = buildGraph(times);

		System.err.println(graph); // {2={3=1, 1=4}, 3={4=1}}
		
		Set<Integer> visited = new HashSet<Integer>();
		Comparator<Pair> pairCmp = new Comparator<Pair>() {
			public int compare(Pair p1, Pair p2) {
				return p1.dest - p2.dest;
			}
		};
		PriorityQueue<Pair> minHeap = new PriorityQueue<Pair>(pairCmp);
		minHeap.offer(new Pair(K, 0));
		int total = 0;
		
		while(!minHeap.isEmpty()) {
			Pair current = minHeap.poll();
			int currLabel = current.label;
			int currDest = current.dest;
			if(visited.contains(currLabel)) {
				continue;
			}
			visited.add(currLabel);
			
			total = Math.max(total, currDest);
			
			if(! graph.containsKey(currLabel)) {
				continue;
			}
			
			Set<Integer> currentLabelAdjVertexKeySet = graph.get(currLabel).keySet();
			for(Integer adjVertex : currentLabelAdjVertexKeySet) {
				int label = adjVertex;
				int dest = currDest +  graph.get(currLabel).get(adjVertex);
				System.err.println(dest);
				minHeap.offer(new Pair(label, dest));
			}
			
		}
		

		return (visited.size() == N ? total : -1);
	}

	private static Map<Integer, Map<Integer, Integer>> buildGraph(int[][] times) {
		
		Map<Integer, Map<Integer, Integer>> graph = new HashMap<Integer, Map<Integer,Integer>>();
		
		if(times == null || times.length == 0) {
			return graph;
		}
		
		for (int[] time : times) {
			Integer sourceVertex = new Integer(time}0]);
			Integer destVertex = new Integer(time}1]);
			int travelTime = time}2];

			if (!graph.containsKey(sourceVertex)) {
				graph.put(sourceVertex, new HashMap<Integer, Integer>());
			}
			Map<Integer, Integer> edge = graph.get(sourceVertex);
			edge.put(destVertex, travelTime);
		}
		
		return graph;
	}

	public static void main(String[] args) {
		int[][] times = { { 2, 1, 4 }, { 2, 3, 1 }, { 3, 4, 11 } };

		System.err.println(networkDelayTime(null, 4, 2));
	}

}
