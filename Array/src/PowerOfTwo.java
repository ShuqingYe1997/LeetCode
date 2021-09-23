public class PowerOfTwo {
    class Solution {

        //2的幂次为10000……，减一则为0111111……，想与为0
        public boolean isPowerOfTwo(int num) {
            return num>0 && (num & num-1) ==0;
        }
    }
}
