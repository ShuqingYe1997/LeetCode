public class ContainsPermutation {
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
//            if(s1==null || s2==null || s2.length()==0)
//                return false;
//            if(s1.length()==0)
//                return true;

//            int[] alphabet1 = new int[26];
//            int[] alphabet2;
//            for (int i = 0; i < s1.length(); i++)
//                alphabet1[s1.charAt(i) - 'a']++;
//
//            for (int i = 0; i <= s2.length() - s1.length(); i++) {
//                //不知怎么的，过不了，已经过了前2/3了
//                if (alphabet1[s2.charAt(i) - 'a'] != 0) {
//
//                    alphabet2 = new int[26];
//                    for (int j = 0; j < s1.length(); j++) {
//                        int a = s1.charAt(j) - 'a';
//                        int b = s2.charAt(i+j)-'a';
//                        alphabet2[b]++;
//                        if(alphabet2[b] > alphabet1[a])
//                            break;
//                    }
//                    boolean flag = true;
//                    for(int k = 0; k < 26; k++) {
//                        if (alphabet1[k] != alphabet2[k]) {
//                            flag = false;
//                            break;
//                        }
//                    }
//                    if(flag) return true;
//                }
//            }

            int[] alphabet1 = new int[26];
            int[] alphabet2 = new int[26];

            for(int i=0;i<s1.length();i++){
                alphabet1[s1.charAt(i)-'a']++;
                alphabet2[s2.charAt(i)-'a']++;
            }

            //slide window
            for(int i=0; i+s1.length()<s2.length();i++){
                alphabet2[s2.charAt(i)-'a']--;
                alphabet2[s2.charAt(i+s1.length())-'a']++;
                if(isEqual(alphabet1,alphabet2))
                    return true;
            }
            return false;
        }

        boolean isEqual(int[] n, int[] m){
            for(int i = 0; i<n.length;i++)
                if(n[i]!=m[i])
                    return false;
                return true;
        }
    }
}
