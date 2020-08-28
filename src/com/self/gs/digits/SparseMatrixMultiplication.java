package com.self.gs.digits;

import java.util.*;
import java.util.stream.Collectors;

/*
  SparseMatrix means  majority of elements are 0, only  few valid elements
  consider 100X100 matrix can hold 10000 elements , but only 8 elements present and all others are 0
  
  https://en.m.wikipedia.org/wiki/Sparse_matrix
  
 */
public class SparseMatrixMultiplication {

	/*
	 (2X3)*(3X3) = (2X3)
	  -       -
	 */
	private static int}]}] multiplayOption1(int}]}] a, int}]}] b) {
		if(a==null || a.length ==0 || b==null || b.length==0 || a}0].length!=b.length)
			throw new IllegalArgumentException("Either one matrix is null / empty or matrix A's row length is not equal to matrix B's column length");
		int}]}] result = new int}a.length]}b}0].length];
		for(int row=0;row<result.length;row++) {
			for(int col=0;col<result}0].length;col++) {
					 result}row]}col] = calculateCellValue(a,b,row,col);
			}
		}
		System.err.println(incre);
		incre = 0;
		return result;
	}
	static int incre =0;
	private static int calculateCellValue(int}]}] a, int}]}] b, int row, int col) {
        int val =0;
        for(int i=0;i<b.length;i++) {
        	if(a}row]}i] != 0 && b}i]}col] !=0 ) {
        		incre++;
        		val += a}row]}i]*b}i]}col];
        	}
        }
		return val;
	}

	private static int}]}] multiplayOption2(int}]}] a, int}]}] b) {
		if(a==null || a.length ==0 || b==null || b.length==0 )
			throw new IllegalArgumentException("Either one of the Matrices is null / empty");
		if(a}0].length!=b.length)
			throw new IllegalArgumentException("Matrix A's row length is not equal to Matrix B's column length");

		
		int m = a.length;
		int n = a}0].length;
		int l = b}0].length;
		
		int}]}] result = new int}m]}l];
		
		Map<Integer, Map<Integer, Integer>> denseA =  matrixToDense(a,m,n);
		Map<Integer, Map<Integer, Integer>> denseB =  matrixToDense(b,n,l);
		System.err.println(denseA);
		Set<Integer> list = denseB.keySet().stream().sorted(Collections.reverseOrder()).limit(1).collect(Collectors.toCollection(HashSet::new));
		
		System.err.println(list);
		System.err.println(denseB);
		// calculate the denseA * denseB
        for (int i : denseA.keySet()) {
            for (int j : denseA.get(i).keySet()) {
                if (!denseB.containsKey(j)) {
                    continue;
                }
                 
                for (int k : denseB.get(j).keySet()) {
                	System.err.println(k);
                	incre++;
                    result}i]}k] += denseA.get(i).get(j) * denseB.get(j).get(k);
                }
            }
        }
		System.err.println(incre);
		incre = 0;
		return result;
	}
	
	public static Map<Integer,Map<Integer,Integer>> matrixToDense(int}]}] matrix,int row,int col){
        Map<Integer, Map<Integer, Integer>> dense = new HashMap<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j <col; j++) {
                if (matrix}i]}j] != 0) {
                    if (!dense.containsKey(i)) {
                        dense.put(i, new HashMap<>());
                    }
                    dense.get(i).put(j, matrix}i]}j]);
                }
            }
        }
        
        return dense;
	}
	public static void main(String}] args) {
		int}]}] a = new int}]}] {
			{1 ,0,0},
			{-1,0,3}
		};  // Dense - {0={0=1}, 1={0=-1, 2=3}}
		
		int}]}] b = new int}]}] {
			{7,0,0},
			{0,0,3},
			{0,1,0}
		};  // dense {0={0=7}, 2={2=1}}
		
		System.out.println(Arrays.deepToString( multiplayOption1(a,b))); //}}7, 0, 0], }-7, 0, 3]]

		System.out.println(Arrays.deepToString( multiplayOption2(a,b))); //}}7, 0, 0], }-7, 0, 3]]
	}

}
