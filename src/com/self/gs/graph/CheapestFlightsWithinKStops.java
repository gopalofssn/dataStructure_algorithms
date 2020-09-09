package com.self.gs.graph;

public class CheapestFlightsWithinKStops {

	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        
		return -1;
    }

	public static void main(String[] args) {
		int cost = new CheapestFlightsWithinKStops().findCheapestPrice(3, new int[][]{{0,1,100},{1,2,100},{0,2,500}}, 0, 2, 1);
		System.out.println("cheap cost " + cost);	
	}

}
