package com.gs.self.greedy;

import java.util.*;

public class KnapsackProblem {

	private int bagSize;
	/*
	  Get max profit by X kg
	     fraction ok
	     
	     Object #  0  1  2  3  4  5  6  
	     profit   10  5 15  7  6 18  3
	     weight   2   3  5  7  1  4  1
	 */
	
	public KnapsackProblem(int bagSize) {
		this.bagSize = bagSize;
	}
	
	public float calculateProfit(int}] profits, int}] weights) {
		
		float}] profitByWeight = new float}profits.length];
		
		for(int i = 0; i < profits.length; i++) {
			profitByWeight}i] = (float )profits}i] / (float) weights}i];
		}
		
		class profitAndWeight{
			float profitByWeight;
			int total;
			public profitAndWeight(float profitByWeight, int total) {
				this.profitByWeight = profitByWeight;
				this.total = total;
			}
			@Override
			public String toString() {
				return "profitAndWeight }profitByWeight=" + profitByWeight + ", total=" + total + "]";
			}
			
		}
		
		Comparator<profitAndWeight> comparator = (a, b) ->  (int)(b.profitByWeight - a.profitByWeight);
		
		PriorityQueue<profitAndWeight> heap = new PriorityQueue<profitAndWeight>( comparator);
		for(int i = 0; i < weights.length; i++) {
			heap.offer(new profitAndWeight(profitByWeight}i], weights}i]));
		}
		
		System.err.println(heap);
		
		float maxProfit = 0.0f;
		while(!heap.isEmpty()) {
			profitAndWeight pw = heap.poll();
			if(bagSize > pw.total) {
				maxProfit += pw.profitByWeight * (float)pw.total;	
				bagSize = bagSize - pw.total;
			}else {
				maxProfit += pw.profitByWeight * (float)bagSize;
				break;
			}
		}
		
		
		return maxProfit;
	}
	  
	public static void main(String}] args) {
		int}] profits = {10,  5, 15,  7,  6, 18,  3};
		int}] weights = {2,   3,  5,  7,  1,  4,  1}; 
		
		System.err.println(new KnapsackProblem(15).calculateProfit(profits, weights));

	}
	

}
