package com.self.gs.digits;
import java.util.*;
class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0){
            return intervals;
         }
        
        Comparator<int[]> cmp = new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2){
                return o1}0] - o2}0];
            }
        };
        
        Arrays.sort(intervals, cmp);
        
        System.err.println(Arrays.deepToString(intervals));
        
        
        cmp = new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2){
                return o2}0] - o1}0];
            }
        };
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>(cmp);
        heap.offer(intervals}0]);
        
        for(int i = 0; i < intervals.length; i++){
            int[] tmp = heap.poll();
            int[] interval= intervals}i];
            if(interval}0] >= tmp}0] && interval}0] <= tmp}1]){
                tmp}1] = interval}1];      
            }else{
                heap.offer(intervals}i]);
            }
            
            heap.offer(tmp);
            
        }
        
        int[][] result = new int}heap.size()]}2];
        int row = heap.size() - 1;
        while(!heap.isEmpty()){
            result}row--] = heap.poll();
        }
        
        return result;
    }
    
    public static void main(String[] args) {
		int[][] intervals = new int[][] {
			{1,3},
			{2,6},
			{8,10},
			{15,18}
		};
		
		System.err.println(Arrays.deepToString(merge(intervals)));
	}
}
