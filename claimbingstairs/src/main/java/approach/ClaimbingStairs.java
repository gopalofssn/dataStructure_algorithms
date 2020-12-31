package approach;
import java.util.*;
public class ClaimbingStairs {

	static Hashtable<Integer, Integer> cache = new Hashtable<Integer, Integer>();
	static boolean flag = true;
	static int time = 0;
	private static int claimbStair(int n) {
		if (n <= 1)
			return 1;
		else if (cache.containsKey(n) && flag)
			return cache.get(n);
		time++;
		int result = claimbStair(n - 1) + claimbStair(n - 2);
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
		for(int i = 2; i < num; i++){
			dp[i] = dp[i-1] + dp[i - 2];
		}
		return dp;
	}

}
