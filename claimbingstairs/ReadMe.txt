Given
  Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top n?
  
 Naive Approach
 ----------------
 Simple recursion but it take lots of time.
  Time : O(n!)
    - repetative compute
  Space : O(n)
    - call stack
 
 Memoization Approach
 --------------------
 recursion but with memoization, so we dont have to compute again and again
 Time : O(n)
 Space : O(n)
 
Dynamic Programming Approach
--------------------
 Time : O(n)
 Space : O(n)
 
1 step =1 way,
2 steps =2 ways,
3 steps =3 ways,
4 steps =5 ways,
5 steps =8 ways, 
6 steps =13 ways
7 steps =21 ways
8 steps =34 ways
9 steps =55 ways
10 steps =89 ways
11 steps =144 ways
12 steps =233 ways
13 steps =377 ways

which form the Fibonacci's sequence. we can simply apply DP