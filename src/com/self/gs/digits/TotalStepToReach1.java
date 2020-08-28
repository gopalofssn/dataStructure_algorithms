package com.self.gs.digits;

public class TotalStepToReach1 {
	/*
	 permitted operations  
	  add 1 
	  subtract 1
	  divide by 2
	  
	  return minimun numbers of steps to reach 1.
	  
	  algorithum
	  ------
	   only pow(2) can bring 1 after m divide
	   so we have to use add or sub to reach 2 pow m
	   exmple 13,
	   8 .... 13 ....16
	   nearest is 16 with 3 steps compare to 8 with 5 steps.
	   if 12
	   both pow 2 is equal distance , in this case we choose lowest.
	   
	   way to find pow
	     0... 0101 - binary rep for integer 5
	         29 leading zeros - i can identify next pow , from 32 int bit - leading 0 (29) - 3, and its pow(2,3) - upper , diff 8-5 = 3 steps plus 3 div to reach 1
	            = 6 steps
	           further 1 4.
	           
	 */
   public static void main(String}] args) {
	   
	   int a = 13; // 1101 
	   
	   int totalIntegerBit = Integer.SIZE; // 32
	   int totalLeadingZeros = calculateTotalNumbersOfLeadingZeros(a); //Integer.numberOfLeadingZeros(a); // 28
	   System.err.println("totalLeadingZeros " + totalLeadingZeros);
	   
	   int diffBetweenUpperPow2 = totalIntegerBit - totalLeadingZeros; // 4
	   
	   int goingUpSteps = ((int) Math.pow(2, diffBetweenUpperPow2) - a) + diffBetweenUpperPow2; // (16 - 13) + 4 = 7 
	   
	   System.err.println(" add 1 and div combination " + goingUpSteps);
	   
	   
	   int diffBetweenLowerPow2 = (totalIntegerBit - totalLeadingZeros) - 1; // 3
	   int goingDownStep = (a - (int) Math.pow(2, diffBetweenLowerPow2)) + diffBetweenLowerPow2; // (13- 8) + 3 == 5 + 3;
	   
	   System.err.println("sub 1 and goingDownStep " + goingDownStep);
	
   }

	private static int calculateTotalNumbersOfLeadingZeros(int a) {
		
		int steps = 0;
		
		while(a != 0) {
			a = a/2;
			steps++;
		}
        
		
		return 32 - steps;
	}
}
