import java.util.ArrayList;
import java.util.List;

public class ValidIPAddress {
    class Solution {
        public List<String> restoreIpAddresses(String s) {
            List<String> res = new ArrayList<>();
            if(s.length()>=4 && s.length()<=12)
                backTrace(res,s,"",1);
            return res;
        }

        public void backTrace(List<String> res, String s, String temp ,int cnt){
            if(cnt==4 && isValid(s))
                res.add(temp+s);
            else{
                for(int i = 1; i<(s.length()<4 ? s.length():4);i++){
                    String sub = s.substring(0,i);
                    if(isValid(sub))
                        backTrace(res,s.substring(i),temp+sub+".", cnt+1);
                }
            }
        }

        public boolean isValid(String s){
            if(s.length()==0 || s.length()>3)
                return false;
            if(s.charAt(0)=='0')  //在验证字符串是否是数字的时候，要注意0的情况，001，010，03都是非法的。
                return s.compareTo("0")==0;  // 所以，如果第一位取出来是0，那么我们就判断字符串是否是"0"，不是的情况都是非法的
            int n = Integer.valueOf(s);
            return n<=255;
        }
    }
}
