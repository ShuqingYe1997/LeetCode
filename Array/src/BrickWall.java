import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

public class BrickWall {
    // 对于每一块砖，我们将当前行遇到的所有砖头的宽度加起来得到 sum，
    // 如果这个 sumsum 在 mapmap 中没有出线过，我们创建一个初始 count 值为 1 的相应条目。
    // 如果 sumsum 已经存在于哈希表中，我们只需要给对应的 count 加一。
    class Solution {
        public int leastBricks(List<List<Integer>> wall) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (List<Integer> row: wall) {
                int sum = 0;
                for (int i = 0; i < row.size() - 1; i++) {
                    sum += row.get(i);
                    if (map.containsKey(sum)) {
                        map.put(sum, map.get(sum) + 1);
                    }
                    else {
                        map.put(sum, 1);
                    }
                }
            }
            int max = 0;
            for (int key: map.keySet())
                max = Math.max(max, map.get(key));
            return wall.size() - max;
        }
    }
    // Time Limit Exceeded
    class Solution0 {
        public int leastBricks(List<List<Integer>> wall) {
            int totalStep = 0;
            for (int i = 0; i < wall.get(0).size(); i++) {
                totalStep += wall.get(0).get(i);
            }
            int[] currentSteps = new int[wall.size()];
            int[] currentPos = new int[wall.size()];
            for (int i = 0; i < wall.size(); i++) {
                currentSteps[i] = wall.get(i).get(0);
                currentPos[i] = 0;
            }
            int minCnt = Integer.MAX_VALUE;
            boolean flag = false;
            for (int step = 1; step < totalStep; step++) {
                flag = true;
                int cnt = 0;
                for (int i = 0; i < wall.size(); i++) {
                    if (currentSteps[i] > step) {
                        cnt++;
                    }
                    else {
                        currentSteps[i] += wall.get(i).get(++currentPos[i]);
                    }
                }
                minCnt = Math.min(minCnt, cnt);
            }
            return flag ? minCnt: wall.size();
        }
    }
}
