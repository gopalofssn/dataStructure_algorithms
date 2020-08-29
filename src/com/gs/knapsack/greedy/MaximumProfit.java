package com.gs.knapsack.greedy;

import java.util.*;

/*
  
Get max profit by X kg
   fraction ok
   
   Object #  0  1  2  3  4  5  6  
   profit   10  5 15  7  6 18  3
   weight   2   3  5  7  1  4  1
*/

public class MaximumProfit {

	private float bagSize;
	
	public MaximumProfit(int bagSize) {
		this.bagSize = bagSize;
	}
	
	public float calculateProfit(int[] profits, int[] weights) {
		
		Comparator<ProfitWeightHolder> cmp = new Comparator<ProfitWeightHolder>() {
			@Override
			public int compare(ProfitWeightHolder a, ProfitWeightHolder b) {
				float aProfitPerWeight = (float)a.profit / (float)a.weight;
				float bProfitPerWeight = (float)b.profit / (float)b.weight;
				double diff = Math.ceil(bProfitPerWeight - aProfitPerWeight);
				return (int)(diff);
			}
		};
		
		PriorityQueue<ProfitWeightHolder> max_heap = new PriorityQueue<ProfitWeightHolder>(cmp);
		
		for(int i = 0; i < profits.length; i++){
			max_heap.offer(new ProfitWeightHolder(i, profits[i], weights[i]));
		}
		
		float max_profit = 0.0f;
		while(!max_heap.isEmpty()){
			ProfitWeightHolder current = max_heap.poll();
			if(current.weight < bagSize){
				max_profit += current.profit;
				bagSize -= current.weight;
			}else{
				float fraction = (float)current.profit / (float)current.weight;
				max_profit += bagSize * (fraction);
			}
		}
		
		return max_profit;
	}
	  
	public static void main(String[] args) {
		int[] profits = {10,  5, 15,  7,  6, 18,  3};
		int[] weights = {2,   3,  5,  7,  1,  4,  1}; 
		
		System.err.println(" Maximum Profit " + new MaximumProfit(15).calculateProfit(profits, weights));

	}
	

}


class ProfitWeightHolder{
	 int index;
	 int profit;
	 int weight;
	ProfitWeightHolder(int index, int profit, int weight){
		this.index = index;
		this.profit = profit;
		this.weight = weight;
	}
	@Override
	public String toString() {
		return "ProfitWeightHolder [index=" + index + ", profit=" + profit + ", weight=" + weight + "]";
	}
	
}

