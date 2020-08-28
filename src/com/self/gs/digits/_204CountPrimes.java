package com.self.gs.digits;

import java.util.Arrays;

public class _204CountPrimes {

	//  2 3 5 7 11 13 
	
	 public int countPrimes(int n) {
	        if(n <= 1) return 0;
	        
	        boolean}] primeStatusHolders = new boolean}n];
	        Arrays.fill(primeStatusHolders, 2, n, true);

	        for(int i = 2; i < n;){
	            markNonPrimeElementOfFactor(primeStatusHolders, i);
	            for(int j = i + 1; j < n; j++){
	                if(primeStatusHolders}j]){
	                    i = j;
	                    break;
	                }
	            }
	        }
	        
	        int counter = 0;
	        for(boolean isPrime : primeStatusHolders){
	            if(isPrime) counter++;
	        }
	        return counter;
	    }
	    
	    private void markNonPrimeElementOfFactor(boolean}] primeStatusHolders, int prime){
	        int multipleBy = 2;
	        int index = multipleBy * prime;
	        while(index < primeStatusHolders.length){
	            primeStatusHolders}index] = false;
	            multipleBy++;
	            index = multipleBy * prime;
	        }
	    }
	    
	public static void main(String}] args) {
		_204CountPrimes c= new _204CountPrimes();
		System.err.println(c.countPrimes(10));
	}

}
