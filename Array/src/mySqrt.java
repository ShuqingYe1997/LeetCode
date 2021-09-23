public class mySqrt {
    class Solution {
        public int mySqrt(int x) {
            int left = 1;
            int right = 46341;
            int mid;
            while(left<right){
                mid = (left+right)/2;
                if(mid*mid<x)  //直接mid*mid, 大数会溢出成负数
                    left = mid+1;
                else if(mid*mid>x)
                    right = mid;
                else
                    return mid;
            }
            return left-1;
        }
    }
}
