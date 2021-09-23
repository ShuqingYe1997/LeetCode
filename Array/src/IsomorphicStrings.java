import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    //用时太多了, 要把substring改成Character(charAt)
    class Solution0 {
        public boolean isIsomorphic(String s, String t) {
            if (s.length() == 0 && t.length() == 0)
                return true;
//            else if(s.length()!=t.length())
//                return false;

            //用Map一身轻松
            Map<String, String> map1 = new HashMap<>();
            Map<String, String> map2 = new HashMap<>();

            for (int i = 0; i < s.length(); i++) {
                String ss = s.substring(i, i + 1);
                String tt = t.substring(i, i + 1);
                if (!map1.containsKey(ss))
                    map1.put(ss, tt);
                else if (map1.get(ss).compareTo(tt) != 0)
                    return false;
                if (!map2.containsKey(tt))
                    map2.put(tt, ss);
                else if (map2.get(tt).compareTo(ss) != 0)
                    return false;
            }
            return true;
        }
    }

    class Solution {
        public boolean isIsomorphic(String s, String t) {
            if (s.length() == 0 && t.length() == 0)
                return true;

            Map<Character, Character> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                if (!map.containsKey(s.charAt(i))) {
                    if (map.containsValue(t.charAt(i)))
                        return false;
                    map.put(s.charAt(i), t.charAt(i));
                } else if (map.get(s.charAt(i))!=t.charAt(i))
                    return false;
            }
            return true;
        }
    }
}

