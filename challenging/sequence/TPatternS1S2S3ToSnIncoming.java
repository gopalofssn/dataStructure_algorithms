package sequence;

import java.util.ArrayList;

public class TPatternS1S2S3ToSnIncoming {
	
	private ArrayList<Integer>[] charIndexHolder;
	
	public TPatternS1S2S3ToSnIncoming(String t) {
		charIndexHolder = new ArrayList[26];
		for(int i = 0; i < 26; i++) {
			charIndexHolder[i] = new ArrayList<Integer>();
		}
		buildGrid(t);
	}
	
	private void buildGrid(String t) {
		for(int i = 0; i < t.length(); i++) {
			char c = t.charAt(i);
			int index = c - 'a';
			charIndexHolder[index].add(i);
		}
		System.out.println(" charIndexHolder ");
	    for(char c = 'a' ; c <='z'; c++) {
	    	int index = c - 'a';
	    	System.out.println(c + "'s postions - > " + charIndexHolder[index]);
	    }
	}

	public boolean isSubSequence(String s) {
		if(s == null || s.isEmpty() ) return true;
		int key = 0;
		for(char c : s.toCharArray()) {
			int index = c - 'a';
			key = binarySearch(charIndexHolder[index], key);
			if(key == -1) return false;
			key++;
		}
		return true;
	}
     // [0, 2, 5]
	private int binarySearch(ArrayList<Integer> list, int target) {
		int left = 0;
		int right = list.size() -1;
		while(left <= right) {
			int mid = left + ((right - left) / 2);
			if(mid == 0 && list.get(mid) >= target) {
				return list.get(mid);
			}else if(mid > 0 && list.get(mid -1) < target  && list.get(mid) >= target){
				return list.get(mid);
			}else if(target > list.get(mid) ) {
				left = mid + 1;
			}else {
				right = mid - 1;
			}	
		}
		System.out.println("oh ha");
		return -1;
	}

	public static void main(String[] args) {
		
		String t = "hghgghacbdefuaz";
		TPatternS1S2S3ToSnIncoming c = new TPatternS1S2S3ToSnIncoming(t);
        String s = "aeazh";
        System.out.println("isSubSequence ? " + c.isSubSequence(s));
        
	}
}
