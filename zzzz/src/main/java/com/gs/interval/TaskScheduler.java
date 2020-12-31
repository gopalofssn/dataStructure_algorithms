package com.gs.interval;

import java.util.*;

public class TaskScheduler {
	 /*
    ['A','A','A','A','A','A','B','C','D','E','F','G'], n = 2
    find total of each char
    A -> 6 5 4  3  2 1 1
    B -> 1 0
    C -> 1 0
    D -> 1   0
    E - 1    0
    F - 1       0
    G - 1       0
    
    A B C A D E A F G A idle idle A idle idle A 
       - total 16
       
       
      A A A B B B , n =2
      A -> 3 2 1 0
      B -> 3 2 1 0
      A B idle A B idle A B
    */
    public int leastInterval(char[] tasks, int n) {
    	 if(tasks == null || tasks.length == 0) return 0;
         Map<Character, Integer> taskByCountMap = new HashMap<Character, Integer>();
         for(char task : tasks){
             taskByCountMap.merge(task, 1, (a, b) -> a + b );
         }
         
         Comparator<Character> cmp = (a, b) -> ( taskByCountMap.get(b) - taskByCountMap.get(a) );
         PriorityQueue<Character> maxHeap = new PriorityQueue<Character>(cmp);
         maxHeap.addAll(taskByCountMap.keySet());
         int result = 0;
         while(!maxHeap.isEmpty()){
        	 System.out.println(maxHeap.size());
        	 if(maxHeap.size() == 1 && taskByCountMap.get(maxHeap.peek()) == 1) {
        		 System.out.println("dd");
        		 return result + 1;
        	 }
        	 
            // List<Character> currentTaskList = new ArrayList<Character>();
             for(int i = 0; i <= n; i++){
            	 int cnt  = 0;
            	 
                 if(!maxHeap.isEmpty()) {
	                 char c = maxHeap.poll();
	                 taskByCountMap.put(c, taskByCountMap.get(c) - 1);
	                 currentTaskList.add(c);
                 }
                 result++; 
                 System.out.println("dd dd " + result);
             }
  
             for(char c : currentTaskList){
                 if(taskByCountMap.getOrDefault(c, 0) == 0) continue;  
                 maxHeap.offer(c);
             }
             
         }
         return result;
        
    }
	public static void main(String[] args) {
		char[] tasks = {'A','A','A','A','A','A','B','C','D','E','F','G'};
		int n = 2;
		int r = new TaskScheduler().leastInterval(tasks, n);
		System.out.println("leastInterval  : " + r);
		
		tasks = new char[]{'A','A','A','B','B','B'};
		r = new TaskScheduler().leastInterval(tasks, n);
		System.out.println("leastInterval  : " + r); // 8 - issue??
	}

}
