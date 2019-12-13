package com.self.gs.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestCommonSubsequence1143 {
    
	//https://www.youtube.com/watch?v=sSno9rV8Rhg - see 3 options below
	static Integer count=0;
    public static int longestCommonSubsequence(String s1, String s2) {
        if(s1==null || s2==null)
            return 0;
       // return recurssion(s1,0,s2,0);
       // return recurssionWithMemoization(s1,0,s2,0,new HashMap<String,Integer>());
        return dp(s1,s2);
    }
    /*
          a b c d e
        0 0 0 0 0 0
      
      a 0 1 1 1 1 1
       
      c 0 1 1 2 2 2
      
      e 0 1 1 2 2 3
    */
    private static int dp(String s1, String s2) {
    	if(s1==null || s2==null)
            return 0;
        int max = 0;
        int[][] holder = new int[s2.length()+1][s1.length()+1];  // s2 as row and s1 as column
        for(int row=1;row<holder.length;row++) {
        	for(int col=1;col<holder[0].length;col++){
        		if(s2.charAt(row-1)==s1.charAt(col-1)) {
        			holder[row][col] = 1 + holder[row-1][col-1];
        			max = Math.max(max, holder[row][col]);
        		}else {
        			holder[row][col] = Math.max(holder[row-1][col], holder[row][col-1]);
        		}
            }
        }
        System.err.println(Arrays.deepToString(holder));
        return max;
          
	}
	// Time : exponential  
    private static int recurssion(String s1, int idx1, String s2, int idx2){
    	count++;
        if(idx1==s1.length() || idx2==s2.length()){
            return 0;
        }else if(s1.charAt(idx1)==s2.charAt(idx2)){
            return 1+recurssion(s1,idx1+1,s2,idx2+1);
        }else{
            return Math.max(recurssion(s1,idx1+1,s2,idx2),recurssion(s1,idx1,s2,idx2+1));
        }
    }
    //Time : O(nm) for memoization plus recuss= time
    private static int recurssionWithMemoization(String s1, int idx1, String s2, int idx2,Map<String,Integer> cache){
    	count++;
        if(idx1==s1.length() || idx2==s2.length()){
            return 0;
        }else if(s1.charAt(idx1)==s2.charAt(idx2)){
            if(cache.containsKey("s1"+(idx1+1)+"s2"+(idx2+1))){
                return 1+cache.get("s1"+idx1+"s2"+idx2);
            }else{
                int tmp = recurssionWithMemoization(s1,idx1+1,s2,idx2+1,cache);
                cache.put("s1"+(idx1+1)+"s2"+(idx2+1),tmp);
                return 1+tmp;
            }    
        }else{
        	int tmp1 = 0;
        	if(cache.containsKey("s1"+(idx1+1)+"s2"+(idx2))) {
        	    tmp1 = cache.get("s1"+(idx1+1)+"s2"+(idx2));
        	}else{
        		tmp1 =recurssionWithMemoization(s1,idx1+1,s2,idx2,cache);
        		cache.put("s1"+(idx1+1)+"s2"+(idx2),tmp1);
        	}
             
            int tmp2 = 0 ;
            if(cache.containsKey("s1"+(idx1)+"s2"+(idx2+1))) {
            	tmp2 = cache.get("s1"+(idx1)+"s2"+(idx2+1));
            }else {
                tmp2 = recurssionWithMemoization(s1,idx1,s2,idx2+1,cache);
                cache.put("s1"+(idx1)+"s2"+(idx2+1),tmp2);
            }
            return Math.max(tmp1, tmp2);
        }
    }
	public static void main(String[] args) {
		System.err.println(longestCommonSubsequence( "GENELIA","GOPALAKRISHNAN"));

	}
}

 

/*
[[0, 0, 0, 0, 0, 0, 0, 0], 
[0, 1, 1, 1, 1, 1, 1, 1], 
[0, 1, 1, 1, 1, 1, 1, 1], 
[0, 1, 1, 1, 1, 1, 1, 1], 
[0, 1, 1, 1, 1, 1, 1, 2], 
[0, 1, 1, 1, 1, 2, 2, 2], 
[0, 1, 1, 1, 1, 2, 2, 3], 
[0, 1, 1, 1, 1, 2, 2, 3], 
[0, 1, 1, 1, 1, 2, 2, 3], 
[0, 1, 1, 1, 1, 2, 3, 3],
 [0, 1, 1, 1, 1, 2, 3, 3], 
 [0, 1, 1, 1, 1, 2, 3, 3], 
 [0, 1, 1, 2, 2, 2, 3, 3], 
 [0, 1, 1, 2, 2, 2, 3, 4], 
 [0, 1, 1, 2, 2, 2, 3, 4]]


*/