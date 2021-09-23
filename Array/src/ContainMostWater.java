import java.util.Map;

public class ContainMostWater {

    //dp，暴力解法，用时很多
    class Solution {
        public int maxArea(int[] height) {
            int n=height.length;
            int[] dp = new int[n];

            for(int i=0;i<n;i++)
                for(int j=i+1;j<n;j++)
                    dp[i] = Math.max(dp[i], (j-i)*Math.min(height[i],height[j]));

            int mostWater = -1;
            for(int i=0;i<n;i++)
                if(mostWater < dp[i])
                    mostWater = dp[i];
            return mostWater;
        }
    }

    //双指针法，每次向里移动较短的那一根，因为高度是由较短的一根决定的，它不可能再和当前两指针间的任何线段组成更大面积
    // S= h短 * x间隔, 如果向里移动长的那根，x间隔只会更小
    //不会错过最优解的，因为每次迭代后都是当前最优解，直到结束
    class Solution2{
        public int maxArea(int[] height) {
            int left =0;
            int right = height.length-1;
            int max_s=-1;
            while(left<right){
                max_s = Math.max(max_s , (right-left)*Math.min(height[left],height[right]));
                if(height[left]<height[right])
                    left++;
                else right--;
            }
            return max_s;
        }

    }
}
