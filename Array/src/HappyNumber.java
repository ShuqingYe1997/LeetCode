import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    class Solution {
        public boolean isHappy(int n) {
            Set set = new HashSet();
           do {
               if(!set.contains(n))
                   set.add(n);
               else return false;
               n=whatAmIDoing(n);
           }while (n!=1);

           return true;
        }

        public int whatAmIDoing(int n){
            int squareSum = 0;
            while(n>0){
                int a = n%10;
                squareSum+=a*a;
                n/=10;
            }
            return squareSum;
        }
    }
}
