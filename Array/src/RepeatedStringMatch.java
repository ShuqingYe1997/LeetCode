public class RepeatedStringMatch {

    //用时和内存都不是很好
    class Solution {
        public int repeatedStringMatch(String A, String B) {
            for (int i=0;i<A.length();i++){
                if(A.charAt(i) == B.charAt(0)){
                    int j=i, k=0, cnt=1;
                    while(A.charAt(j) == B.charAt(k)){
                        j++;k++;
                        if(k == B.length()) return cnt;
                        if(j>=A.length()){
                            j=0;
                            cnt++;
                        }
                    }
                }
            }
            return -1;
        }
    }

    //一个完整的B可能首部用到A的一部分，尾部用到A的一部分，像这样A'[AA....AA]A' , [ ] 内必然<=B的长度，故总长<=2*A+B
    class Solution2{
        public int repeatedStringMatch(String A, String B){
            int maxLen = 2*A.length()+B.length();
            String AA=A;
            int cnt=1;
            while (AA.length()<maxLen){
                if(!AA.contains(B)){
                    AA+=A;
                    cnt++;
                }
                else break;
            }
            return cnt;
        }
    }
}
