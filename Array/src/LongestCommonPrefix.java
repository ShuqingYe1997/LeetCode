/*Write a function to find the longest common prefix string amongst an array of strings.

        If there is no common prefix, return an empty string "".

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/longest-common-prefix
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length<=0) return "";

        int minLen = 2<<10;
        for(int i=0;i<strs.length;i++){
            if(minLen > strs[i].length())
                minLen = strs[i].length();
        }
        if(minLen<=0) return "";

        int i=0;
        boolean flag=true;
        for(i=0;i<minLen;i++){
            char c = strs[0].charAt(i);
            for(int j=1;j<strs.length;j++){
                if(strs[j].charAt(i)!=c){
                    flag=false;
                    break;
                }
            } // end of j
            if(!flag)
                break;
        }
        if (i>0) return strs[0].substring(0,i);
        else return "";
    }
}
