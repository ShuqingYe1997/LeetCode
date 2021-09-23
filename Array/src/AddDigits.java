public class AddDigits {

    //速度很快，内存较大
    class Solution0 {
        public int addDigits(int num) {
            while(num>=10)
                num = getSum(num);
            return num;
        }

        public int getSum(int num){
            int sum = 0;
            while (num>0){
                int a = num%10;
                sum+=a;
                num/=10;
            }
            return sum;
        }
    }
    // do it without any loop/recursion in O(1) runtime
    // 用上面那段程序跑了一下，找到规律了……
    class Solution{
        public int addDigits(int num) {
            if(num%9 ==0)
                return 9;
            else return num%9;

        }
    }
}
