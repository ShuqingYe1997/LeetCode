public class FirstUniqueChar {
    class Solution {
        public int firstUniqChar(String s) {
            if (s.length()<=0) return -1;

            int[] letters = new int[26];
            char[] chars = s.toCharArray();
            for(int i=0;i<chars.length;i++)
                letters[chars[i]-'a']++;
            int index;
            for(index=0;index<chars.length;index++)
                if(letters[chars[index]-'a']==1)
                   break;
            if(index >= chars.length)
                index = -1;
            return index;


        }
    }
}
