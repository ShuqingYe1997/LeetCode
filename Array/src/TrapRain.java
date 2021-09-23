public class TrapRain {
    class Solution {

        //太精彩了
        //找到最高点，从两边往中间遍历，如果下一个数比当前次高点小（凹字形），则可以积水
        public int trap(int[] height) {
            if(height == null || height.length == 1 || height.length == 2)
                return 0;

            int sum = 0;
            int highest = 0, highestIndex = 0;
            for(int i=0;i<height.length;i++){
                if(height[i] > highest){
                    highest = height[i];
                    highestIndex = i;
                }
            }

            int leftSecondHighest = 0;
            for(int i = 0;i<highestIndex;i++){
                if(height[i] > leftSecondHighest)
                    leftSecondHighest = height[i];
                else
                    sum += leftSecondHighest - height[i];
            }

            int rightSecondHighest = 0;
            for(int i = height.length-1;i>highestIndex;i--){
                if(height[i] > rightSecondHighest)
                    rightSecondHighest = height[i];
                else
                    sum += rightSecondHighest - height[i];
            }
            return sum;
        }
    }
}
