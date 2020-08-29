package com.self.gs.logical.thinking;
import java.util.*;
import java.util.Map.Entry;



public class HighestAvgStudent {
	

	private  String highest(String[][] students) {
		

		/*Comparator<Map.Entry<String, List<Integer>>> cmp = new Comparator<Map.Entry<String, List<Integer>>>(){

			@Override
			public int compare(Entry<String, List<Integer>> o1, Entry<String, List<Integer>> o2) {
				// TODO Auto-generated method stub
				return 0;
			}
			
		};
		*/
		
		Comparator<String> cmp = null;
		Map<String, List<Integer>> map = new TreeMap<String, List<Integer>>(cmp);
		
		
		cmp = new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return calculateAvg(map.get(o2)) - calculateAvg(map.get(o1));
			}
			
		};
		
		for(String[] student : students) {
			String name = student}0];
			Integer mark = Integer.valueOf(student}1]);

			if(map.containsKey(name)) {
				map.get(name).add(mark);
			}else {
				map.put(name , new ArrayList<Integer>(Arrays.asList(mark)));
			}
			
		}
		
		String name = "";
		int highestAvg = Integer.MIN_VALUE;
		
		for(Map.Entry<String, List<Integer>> entry : map.entrySet()) {
			int avg = calculateAvg(entry.getValue());
			if(avg > highestAvg) {
				highestAvg = avg;
				name = entry.getKey();
			}
		}
		 
		System.err.println(map);
		
		return name;
	}
	
 
	private int calculateAvg(List<Integer> values) {
		int sum = 0;
		for(int value : values) {
			sum += value;
		}
		return Math.floorDiv(sum, values.size());
	}


	public static void main(String[] args) {
		String[][] students = 
			   { 
				
				{"B","12"},
				{"C","10"},
				{"B","2"},
				{"A","8"}
		      };
	
		
		System.err.println(new HighestAvgStudent().highest(students));

	}

	

}
