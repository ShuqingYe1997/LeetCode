public class AddBinary {
    class Solution {
        public String addBinary(String a, String b) {
            StringBuffer sb_a=new StringBuffer(a);
            sb_a = sb_a.reverse();
            StringBuffer sb_b=new StringBuffer(b);
            sb_b = sb_b.reverse();
            StringBuffer sum = new StringBuffer();

            int len = (a.length()<b.length() ? a.length(): b.length());
            int in=0;
            int i;
            for(i=0; i<len;i++){
                int aa = sb_a.charAt(i)-'0';
                int bb = sb_b.charAt(i)-'0';
                sum.append((aa+bb+in)%2);  //still reverse

                if(aa+bb+in>1)
                    in=1;
                else in=0;
            }
            if(i<a.length()){
                for(;i<a.length();i++){
                    int aa = sb_a.charAt(i)-'0';
                    sum.append((aa+in)%2);  //still reverse
                    if(aa+in>1)
                        in=1;
                    else in=0;
                }
            }
            else if(i<b.length()){
                for(;i<b.length();i++){
                    int bb = sb_b.charAt(i)-'0';
                    sum.append((bb+in)%2);  //still reverse
                    if(bb+in>1)
                        in=1;
                    else in=0;
                }
            }
            if(in==1) sum.append(in);
            sum = sum.reverse();
            return sum.toString();
        }
    }
}
