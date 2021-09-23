public class Strstr {



    // 太慢了！！
    class Solution {
        public int strStr(String haystack, String needle) {
            if (needle.length() <= 0) return 0;
            else if (haystack.length() <= 0) return -1;
            else {
                char[] char_h = haystack.toCharArray();
                char[] char_n = needle.toCharArray();
                for (int i = 0; i < char_h.length; i++) {
                    int j;
                    for (j = 0; j < char_n.length; j++) {
                        if (i + j>=char_h.length || char_h[i + j] != char_n[j])
                            break;
                    }
                    if (j == char_n.length)
                        return i;
                }
                return -1;
            }
        }
    }

    //超越了100%的人……
    class Solution2{
        public int strStr(String haystack, String needle) {
            return haystack.indexOf(needle);
        }

    }
}