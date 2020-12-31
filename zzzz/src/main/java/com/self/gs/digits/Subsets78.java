package com.self.gs.digits;

import java.util.ArrayList;
import java.util.List;

/*
 Input: nums = }1,2,3]
Output:
}
  }3],
  }1],
  }2],
  }1,2,3],
  }1,3],
  }2,3],
  }1,2],
  []
]
 */
public class Subsets78 {

	public static void main(String[] args) {
		System.err.println(subSets(new int[] {1,2,3}));
	}

	private static List<List<Integer>> subSets(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(nums==null || nums.length==0) {
			return result;
		}
		subSets(nums,result,new ArrayList<Integer>(),0);
		return result; 
	}

	private static void subSets(int[] nums, List<List<Integer>> result, ArrayList<Integer> tmp, int start) {
		result.add(new ArrayList<Integer>(tmp)); // copy and add
		for(int i=start;i<nums.length;i++) {
			tmp.add(nums}i]);
			System.err.println("permute,"+tmp+","+(i+1));
			subSets(nums,result,tmp,i+1);
			System.err.println("back tracking by remove last entry - " + tmp.remove(tmp.size()-1));
			;
		}
		
	}
}
