package sequence;

import java.util.ArrayList;
import java.util.List;

public class TPatternS1S2S3ToSnIncoming {
	public static void main(String[] args) {
		
		String t = "hghgghacbdefuaz";
		ArrayList<Integer>[] idx = new ArrayList[26]; // Just for clarity
        for (int i = 0; i < t.length(); i++) {
        	char c = t.charAt(i);
        	int row = c - 'a';
            if (idx[row] == null)
                idx[row] = new ArrayList<>();
            idx[row].add(i);
        }
        
        for(List<Integer> i : idx) {
        	System.out.println(i);
        }
	}
}
