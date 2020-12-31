package approach;

import java.util.Arrays;
import java.util.Hashtable;

// Each time you can either climb 1 or 2 or 3 steps. In how many distinct ways can you climb to the top n?
public class ClaimbingStairs3Options {

sadsad
	static Hashtable<Integer, Integer> cache = new Hashtable<Integer, Integer>();
	static boolean flag = true;
	static int time = 0;
	private static int claimbStair(int n) {
		if(n <= 0)
			return 0;
		else if (n == 1)
			return 1;
		else if(n == 2)
			return 2;
		else if(n == 3)
			return 3;
		else if (cache.containsKey(n) && flag)
			return cache.get(n);
		time++;
		int result = claimbStair(n - 1) + claimbStair(n - 2) + claimbStair(n - 3);
		cache.put(n, result);
		return result;
	}

	public static void main(String[] args) {
		for(int i = 1; i <= 20; i++){
		time = 0;
		cache.clear();
		  System.out.println(i + " Stairs result " + claimbStair(i) + " with time " + time);
		}
		System.out.println(Arrays.toString(fib(20)));
	}

	private static int[] fib(int num) {
		int[] dp = new int[num];
		dp[0] = 1;
		dp[1] = 2;
		dp[2] = 3;
		for(int i = 3; i < num; i++){
			dp[i] = dp[i-1] + dp[i - 2] + dp[i - 2];
		}
		return dp;
	}


}
