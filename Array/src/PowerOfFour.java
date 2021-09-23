public class PowerOfFour {
    class Solution0 {
        public boolean isPowerOfFour(int num) {
            int base = 1;
            for(int i=0;i<16;i++){
                if(num==base)
                    return true;
                else if(num<base)
                    break;
                else
                    base<<=2;
            }
            return false;
        }
    }

    // 5 = 101, 4的幂次只在奇数位上为零，0x55555555可以来校验奇数位上的1
    //4的幂次也是2的幂次
    class Solution {
        public boolean isPowerOfFour(int num) {
            return ((num & 0x55555555) != 0) && ((num & (num - 1)) == 0);
        }
    }
}