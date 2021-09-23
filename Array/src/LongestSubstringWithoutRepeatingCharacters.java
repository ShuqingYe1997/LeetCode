public class LongestSubstringWithoutRepeatingCharacters {

    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int i = 0, j = i + 1;
            int maxLen = 0;
            while (j < s.length()) {
                for(int k = i; k < j; k++)
                    if (s.charAt(j) == s.charAt(k)) {
                        i = k+1;
                        break;
                }
                maxLen = Math.max(maxLen, j - i + 1);
                j++;
            }
            return maxLen;
        }
    }
}