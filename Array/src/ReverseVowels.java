import java.util.HashSet;
import java.util.Set;

public class ReverseVowels {
    class Solution {
        public String reverseVowels(String s) {
            if(s.length()<=1) return s;
            Set<Character> set = new HashSet();
            set.add('a');set.add('e');set.add('i');set.add('o');set.add('u');
            set.add('A');set.add('E');set.add('I');set.add('O');set.add('U');
            int[] idx = new int[s.length()];
            char[] chars = s.toCharArray();
            int cnt=0;
            for(int i=0;i<s.length();i++){
                if(set.contains(chars[i]))
                    idx[cnt++] = i;
            }
            for(int i=0, j=cnt-1;i+j<cnt && i<j;i++,j--){
                char temp = chars[idx[i]];
                chars[idx[i]] = chars[idx[j]];
                chars[idx[j]] = temp;
            }
            return String.valueOf(chars);
        }
    }
}
