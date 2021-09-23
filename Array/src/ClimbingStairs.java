
// Fibonacci的微笑
public class ClimbingStairs {
    class Solution {
        public int climbStairs(int n) {
            int[] Fibonacci = new int[30];
            Fibonacci[1] = 1;
            Fibonacci[2] = 2;
            for(int i=3;i<=n;i++)
                Fibonacci[i] = Fibonacci[i-2]+Fibonacci[i-1];
            return Fibonacci[n];
        }
    }
}
