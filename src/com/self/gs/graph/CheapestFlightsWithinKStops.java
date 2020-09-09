package com.self.gs.graph;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class CheapestFlightsWithinKStops {

	/*
	     0
  (100)/   \ (500)
	  1 _  2
	    100
	 */
	
	private final class Edge{
		private final int city;
		private final int cost;
		private final int stop;
		public Edge(int city, int cost){
			this.city = city;
			this.cost = cost;
			this.stop = 0;
		}
		public Edge(int city, int cost, int stop){
			this.city = city;
			this.cost = cost;
			this.stop = stop;
		}
		@Override
		public String toString() {
			return "Edge [city=" + city + ", cost=" + cost + "]";
		}
	}
	
	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
		if(flights == null || flights.length == 0) return -1;
        Map<Integer, Set<Edge>> graph = new HashMap<Integer, Set<Edge>>(); // input is 2d array , i should build graph
        buildGraph(graph, flights);
        
        Comparator<Edge> cmp = (a, b) -> a.cost - b.cost;
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>(cmp);
        Map<Integer, Integer> costMap = new HashMap<Integer, Integer>();
        Set<Integer> visited = new HashSet<>();
       
        pq.offer(new Edge(src, 0, -1)); // src city -1 stop
        costMap.put(src, 0); // src city always 0 cost
        
        while(!pq.isEmpty()){
        	Edge current = pq.poll();
        	visited.add(current.city); // mark as visited after poll from queue
        	int stop = current.stop + 1;
        	for(Edge edge : graph.getOrDefault(current.city, Collections.emptySet()) ){
        		int nextCity = edge.city;
        		if(visited.contains(nextCity)) continue; // if visted already , dont add in pq
        		int currentToNextCost = Math.min(edge.cost + current.cost, 
        				                         costMap.getOrDefault(nextCity, Integer.MAX_VALUE)); // calculate min cost
        		pq.offer(new Edge(nextCity, currentToNextCost, stop));
        		costMap.put(nextCity, currentToNextCost); // put newly calculated min cost
        	}
        	if(stop == K) break;
        }
        return  costMap.getOrDefault(dst, -1);
    }

	private void buildGraph(Map<Integer, Set<Edge>> graph, int[][] flights) {
		for(int[] flight : flights){
			int vertex = flight[0];
			Edge edge = new Edge(flight[1], flight[2]);
			graph.computeIfAbsent(vertex, k -> new HashSet<Edge>()) // put initialize val
			     .add(edge);  // add val
			/*
			 another option , put key and then add
			 graph.putIfAbsent(vertex, new HashSet<>());
			 graph.get(vertex).add(edge);
			 */
		}
		System.out.println("Graph - " + graph);
	}

	public static void main(String[] args) {
		int cost = new CheapestFlightsWithinKStops().findCheapestPrice(3, new int[][]{{0,1,100},{1,2,100},{0,2,500}}, 0, 2, 1);
		System.out.println("cheap cost " + cost);	
	}

}
