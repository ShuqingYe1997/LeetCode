import java.util.ArrayList;
import java.util.List;

/*
The gray code is a binary numeral system where two SUCCESSIVE values differ in only ONE bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code.

A gray code sequence must BEGIN WITH 0.
*/

// i ^ (i>>1)

public class GrayCode {

    //Wrong! Doesn't follow the rule that two SUCCESSIVE values differ in only ONE bit.
    class Solution0 {
        public List<Integer> grayCode(int n) {
            List<Integer> result = new ArrayList<>();
            backtrace(result,new ArrayList<>(),n);
            return result;
        }

        public void backtrace(List<Integer> result, List<Integer> list,int len){
            if(list.size()==len){
                int factor = 1;
                int sum = 0;
                for(int i=list.size()-1;i>=0;i--){
                    sum+=list.get(i)*factor;
                    factor*=2;
                }
                result.add(sum);
                return;
            }
            else{
                for(int i=0;i<=1;i++){
                    list.add(i);
                    backtrace(result,list,len);
                    list.remove(list.size()-1);
                }
            }
        }
    }
}
