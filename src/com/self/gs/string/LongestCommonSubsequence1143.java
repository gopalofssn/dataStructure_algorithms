package com.self.gs.string;

import java.util.ArrayList;

public class LongestCommonSubsequence1143 {
    
	//https://www.youtube.com/watch?v=sSno9rV8Rhg 
	
	
/*
if col char == row char , then  diagonal previous +1
otherwise , max(prev row, prev col)
			
        G  E  N  E  L  I  A
    [0, 0, 0, 0, 0, 0, 0, 0], 
G   [0, 1, 1, 1, 1, 1, 1, 1], 
O	[0, 1, 1, 1, 1, 1, 1, 1], 
P	[0, 1, 1, 1, 1, 1, 1, 1], 
A	[0, 1, 1, 1, 1, 1, 1, 2], 
L	[0, 1, 1, 1, 1, 2, 2, 2], 
A	[0, 1, 1, 1, 1, 2, 2, 3], 
K	[0, 1, 1, 1, 1, 2, 2, 3], 
R	[0, 1, 1, 1, 1, 2, 2, 3], 
I	[0, 1, 1, 1, 1, 2, 3, 3],
S	[0, 1, 1, 1, 1, 2, 3, 3], 
H	[0, 1, 1, 1, 1, 2, 3, 3], 
N	[0, 1, 1, 2, 2, 2, 3, 3], 
A	[0, 1, 1, 2, 2, 2, 3, 4], 
N	[0, 1, 1, 2, 2, 2, 3, 4]
	*/
	
    // same concept as about , but only maintain 2 rows on smallest string 
	private static int longestCommonSubsequenceUsingOptimizedDPArray(String s1, String s2) {
		if(isNullOrEmpty(s1) || isNullOrEmpty(s2)){
			return 1;
		}else if(s1.length() > s2.length()){
			return helper(s1, s2);
		}else{
			return helper(s2, s1);
		}
	}
	
	
    private static int helper(String big, String small) {
    	final int ROWS = big.length() + 1;
    	final int COLS = small.length() + 1;
		int[] prev = new int[COLS];
		int[] current = new int[COLS];

		for(int row = 1; row < ROWS; row++){
			for(int col = 1; col < COLS; col++){
				char b = big.charAt(row -1);
				char c = small.charAt(col - 1);
				if(b == c){
					current[col] = 1 + prev[col -1];
				}else{
					current[col] = Math.max(current[col -1], prev[col]);
				}
			}
			int[] tmp = current;
			current = prev;
			prev = tmp;
		}
		showMemoryUsage(" small " );
		return prev[COLS -  1];
	}


	private static boolean isNullOrEmpty(String s) {
		return (s == null || s.isEmpty() );
	}


	public static int longestCommonSubsequence(String s1, String s2) {
        if(s1==null || s2==null)
            return 0;
        int s1Len = s1.length();
        int s2Len = s2.length();
        int[][] dp = new int[s1Len + 1 ][s2Len + 1];
        for(int row = 1; row <= s1Len; row++){
        	
        	for(int col = 1; col <= s2Len; col++){
        		char c1 = s1.charAt(row - 1);
        		char c2 = s2.charAt(col - 1);
        		if(c1 == c2){
        			dp[row][col] = 1 + dp[row - 1][col -1];
        		}else{
        			dp[row][col] = Math.max(dp[row - 1][col], dp[row][col - 1]);
        		}
        	}
        }
        showMemoryUsage(" big.. " );
        
        return dp[s1Len][s2Len];
    }
    
	public static void main(String[] args) {
		System.out.println(" bid DP " + longestCommonSubsequence( "GENELIA" ,"GOPALAKRISHNAN" + generateLargeStrings())); // 4
		System.out.println("Small DP " + longestCommonSubsequenceUsingOptimizedDPArray( "GENELIA","GOPALAKRISHNAN"+ generateLargeStrings())); // 4
		
		//gcInMethod();
	}
	
	 static final int N = 50;//7500;
	 
	 private static String generateLargeStrings() {
		 StringBuilder sb = new StringBuilder(N * N);
	        for (int i = 0; i < N; i++) {
	            
	            for (int j = 0; j < N; j++) {
	                sb.append((char)Math.round(Math.random() * 0xFFFF));
	            }
	        }

	        return sb.toString();
	    }
	
	
	 
	 public static void gcInMethod() {

	        showMemoryUsage("Before first memory allocating");
	        ArrayList<String> strings = generateLargeStringsArray(N);
	        showMemoryUsage("After first memory allocation");


	        // this is only one difference - after the iterator created, memory won't be collected till end of this function
	        for (String string : strings);
	        showMemoryUsage("After iteration");

	        strings = null; // discard the reference to the array

	        // one says this doesn't guarantee garbage collection,
	        // Oracle says "the Java Virtual Machine has made a best effort to reclaim space from all discarded objects".
	        // but no matter - the program behavior remains the same with or without this line. You may skip it and test.
	        System.gc();

	        showMemoryUsage("After force GC in the method body");

	        try {
	            System.out.println("Try to allocate memory in the method body again:");
	            ArrayList<String> strings2 = generateLargeStringsArray(N);
	            showMemoryUsage("After secondary memory allocation");
	        } catch (OutOfMemoryError e) {
	            showMemoryUsage("!!!! Out of memory error !!!!");
	            System.out.println();
	        }
	    }
	    
	 private static ArrayList<String> generateLargeStringsArray(int N) {
	        ArrayList<String> strings = new ArrayList<>(N);
	        for (int i = 0; i < N; i++) {
	            StringBuilder sb = new StringBuilder(N);
	            for (int j = 0; j < N; j++) {
	                sb.append((char)Math.round(Math.random() * 0xFFFF));
	            }
	            strings.add(sb.toString());
	        }

	        return strings;
	    }
	 public static void showMemoryUsage(String action) {
	        long free = Runtime.getRuntime().freeMemory();
	        long total = Runtime.getRuntime().totalMemory();
	        long max = Runtime.getRuntime().maxMemory();
	        long used = total - free;
	        System.out.printf("\t%40s: %10dk of max %10dk%n", action, used / 1024, max / 1024);
	    }
	 
}

 

