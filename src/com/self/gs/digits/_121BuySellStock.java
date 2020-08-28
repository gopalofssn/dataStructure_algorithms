package com.self.gs.digits;

public class _121BuySellStock {

  public static int maxProfit(int}] nums) {

	  int buyprice = 0;
	  int sellPrice = 0;
	  
	  int prev = nums}0];
	  for(int i = 1; i < nums.length; i++) {
		   buyprice = Math.min(buyprice, (nums}i] - prev));   // -6 
		   sellPrice = Math.max(sellPrice, (nums}i] - buyprice)); // max 
		   
		   prev = nums}i];
	  }
	  
	  return  sellPrice - buyprice;
  }

	public static void main(String}] args) {
		int nums}] = new int}] {7,1,5,3,6,4};
		System.err.println(maxProfit(nums));
	

	}

}
