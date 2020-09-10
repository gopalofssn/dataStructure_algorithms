package com.gs.self.ngreedy;

import java.util.*;

public class ActivitySelection {

	//with PQ
	// Time (worst ) : O(n log n)
    // Space (worst) : O(1)
    private static List<int[]> findUserActivities(int[][] activites) {
    	if(activites == null || activites.length == 0) return Collections.emptyList();
    	
    	Comparator<int[]> cmp = (a, b) -> (a[1] - b[1]);
    	PriorityQueue<int[]> earlyEndActivity = new PriorityQueue<int[]>(cmp);
    	for(int[] activity : activites){
    		earlyEndActivity.offer(activity);
    	}
    	
    	LinkedList<int[]> result = new LinkedList<int[]>();
    	result.addLast(earlyEndActivity.poll());
    	while(!earlyEndActivity.isEmpty()){
    		int[] current = earlyEndActivity.poll();
    		int[] prevSelection = result.peekLast();
    		if(prevSelection[1] <= current[0]){
    			result.addLast(current);
    		}
    	}
		return result;
	}

    //without PQ
    // Time (worst ) : O(n * n) - java array uses quicksort internally
    // Space (worst) : O(n * n)
    private static List<int[]> findUserActivitiess(int[][] activites) {
        
        Arrays.sort(activites, (a ,b) -> Integer.compare(a[1], b[1]));  // sort by  earliest finish
        
        //System.err.println(Arrays.deepToString(activites));
        
        List<int[]> selectedActivities = new ArrayList<int[]>();
        selectedActivities.add(activites[0]);
        int[] current = activites[0];
        
        for(int i = 0; i < activites.length; i++) {
          if(activites[i][0] >= current[1] ) {
            selectedActivities.add(activites[i]);
            current = activites[i];
          }
        }
        
        return selectedActivities;
        
      }
    public static void main(String[] args) {
      int[][] activites = {
    		  				{1, 4}, 
    		  				{3, 5},
    		  				{0, 6}, 
    		  				{5, 7},
    		  				{3, 8}, 
    		  				{5, 9},
    		  				{6, 10}, 
    		  				{8, 11}, 
    		  				{8, 12}, 
    		  				{2, 13}, 
    		  				{12, 14}
                          };
      
      List<int[]> output = findUserActivities(activites);
      for (int[] o : output) {
        System.err.println(Arrays.toString(o));
        
      }
    }
 
}
