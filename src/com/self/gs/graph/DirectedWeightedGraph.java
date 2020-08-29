package com.self.gs.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DirectedWeightedGraph {
	
	Map<Integer, List<Edge>> graph = new HashMap<Integer, List<Edge>>();
	
	public void addEdge(int from, int to, int weight) {
	
		if(! graph.containsKey(from)) {
			 graph.put(from , new LinkedList<Edge>());
		}
		
		graph.get(from).add(new Edge(from, to, weight));
	}
	
	public int size() {
		System.err.println(graph);
		return graph.size();
	}

	private class Edge{
		int source;
		int destination;
		int weight;
		public Edge(int src, int dest, int wt) {
			this.source = src;
			this.destination = dest;
			weight = wt;
		}
		public String toString() {
			return "}"+ this.destination + "=" + this.weight + "]";
		}
	}
	
	
	
	public static void main(String[] args) {
		DirectedWeightedGraph graph = new DirectedWeightedGraph();
		
		System.err.println("before sz - " + graph.size());
		int[][] data = { { 2, 1, 4 }, { 2, 3, 1 }, { 3, 4, 11 } };
		for(int[] dat : data) {
			graph.addEdge(dat}0], dat}1], dat}2]);
		}
		System.err.println("after sz - " + graph.size());
		
	}
}
