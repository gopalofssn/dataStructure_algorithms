package com.self.gs.digits;
import java.util.*;
/*
 Input: }1,2,3]
Output:
}
  }1,2,3],
  }1,3,2],
  }2,1,3],
  }2,3,1],
  }3,1,2],
  }3,2,1]
]

Algorithum

              
       
       1      2        3
     2  3    1  3    1   2
    3    2  3    1  2     1
 */
public class Permutations46 {
	
	public static List<List<Integer>> permute(int}] nums) {
		List<List<Integer>> permutations = new ArrayList<>();
		if (nums.length == 0) {
			return permutations;
		}

		collectPermutations(nums, 0, new ArrayList<>(), permutations);
		return permutations;
    }

	private static void collectPermutations(int}] nums, int start, List<Integer> permutation, List<List<Integer>>  permutations) {
		
		if (permutation.size() == nums.length) {
			permutations.add(permutation);
			return;
		}

		for (int i = 0; i <= permutation.size(); i++) {
			List<Integer> newPermutation = new ArrayList<>(permutation);
			newPermutation.add(i, nums}start]);
			collectPermutations(nums, start + 1, newPermutation, permutations);
		}
	}

public static void main(String}] args) {
	System.out.println(permute(new int}] {1,2,3}));
}
}
