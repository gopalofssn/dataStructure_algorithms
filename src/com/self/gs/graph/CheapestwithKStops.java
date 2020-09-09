package com.self.gs.graph;

import java.util.*;

public class CheapestwithKStops {

	private static class Edge {
		 
		int vertex;
		int weight;

		public Edge(int destination, int weight) {
 			this.vertex = destination;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Edge [  destination=" + vertex + ", weight=" + weight + "]";
		}

	}

	private static class Vertex implements Comparable<Vertex> {
		int city;
		int cost;
		int stop;

		public Vertex(int city, int cost, int stop) {
			this.city = city;
			this.cost = cost;
			this.stop = stop;
		}

		public int compareTo(Vertex that) {
			return this.cost - that.cost;
		}

		@Override
		public String toString() {
			return "CityAndCost }city=" + city + ", cost=" + cost + ", stop=" + stop + "]";
		}

	}

	public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
		
		Map<Integer, Set<Edge>> graph = buildGraph(flights);

		PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();
		pq.offer(new Vertex(src, 0, -1));
		Map<Integer, Integer> costMap = new HashMap<Integer, Integer>();
	    Set<Integer> visited = new HashSet<Integer>();
		
		while (!pq.isEmpty()) {
			Vertex current = pq.poll();
			visited.add(current.city);
			int stop = current.stop + 1;
			
			for (Edge edge : graph.getOrDefault(current.city, Collections.emptySet())) {
				
				int cost = current.cost + edge.weight;
				if(costMap.containsKey(edge.vertex)) {
					cost = Math.min(cost, costMap.get(edge.vertex) );
				}
				costMap.put(edge.vertex, cost);

				if(visited.contains(edge.vertex)) {
					continue;
				} 
				pq.add(new Vertex(edge.vertex, cost, stop));	 
			}
			
			if(stop == K ) {
				break;
			}
		 
		}
		

		return  costMap.getOrDefault(dst, -1);

	}

	private static Map<Integer, Set<Edge>> buildGraph(int[][] flights) {
		Map<Integer, Set<Edge>> graph = new HashMap<Integer, Set<Edge>>();

		for (int[] flight : flights) {
			graph.computeIfAbsent(flight[0], k -> new HashSet<Edge>())
                 .add(new Edge(flight[1], flight[2]));
		}
		return graph;
	}

	/*
	 * 0 - > 1 (5) - > 2 (5) | / | | 3(2) 4(1) --(1)
	 * 
	 */
	public static void main(String[] args) {
		int[][] data = {{0,1,100},{0,2,500},{1,2,100}};

		System.err.println(findCheapestPrice(3, data, 0, 2, 1));
	}

}
