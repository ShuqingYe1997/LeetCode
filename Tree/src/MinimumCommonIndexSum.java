import java.util.*;

public class MinimumCommonIndexSum {
    class Solution {
        public String[] findRestaurant(String[] list1, String[] list2) {
            List<String> res = new ArrayList<>();
            if(list1==null || list2 == null || list1.length ==0 || list2.length==0)
                return res.toArray(new String[res.size()]);

            HashMap<String, Integer> map1 = new HashMap<>();
            HashMap<String, Integer> map2 = new HashMap<>();

            for(int i=0;i<list1.length;i++)
                map1.put(list1[i],i);
            for(int i=0;i<list2.length;i++)
                map2.put(list2[i],i);

            HashMap<String, Integer> map = new HashMap<>();
            Set<String> set2 = map2.keySet();
            for (String s: set2) {
                if(map1.containsKey(s))
                    map.put(s,map1.get(s)+map2.get(s));
            }

            int min = Integer.MAX_VALUE;
            Set<String> set = map.keySet();
            for (String s: set) {
                if(min > map.get(s))
                    min = map.get(s);
            }
            for (String s: set) {
                if(min == map.get(s))
                    res.add(s);
            }
            return res.toArray(new String[res.size()]);
        }
    }
}
