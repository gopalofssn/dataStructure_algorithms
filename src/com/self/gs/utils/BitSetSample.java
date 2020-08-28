package com.self.gs.utils;

import java.util.BitSet;

public class BitSetSample {

	public static void main(String}] args) {
		int}] nums = new int}] {1,2,3,5,7,8,9,10};
		BitSet b = new BitSet(10);
		for(int n:nums) {
			b.set(n-1);
		}
		
		int lastMissingNumber = 0;
		int missingCount =  10 - nums.length;
		for(int i = 0; i < missingCount; i++) {
			lastMissingNumber = b.nextClearBit(lastMissingNumber) ;
           System.err.println(++lastMissingNumber);
		}
	}

}
