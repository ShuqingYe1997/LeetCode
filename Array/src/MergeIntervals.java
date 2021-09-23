import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    //先根据终点排序，终点相同的起点前在先
    class Solution {
        public int[][] merge(int[][] intervals) {
            if(intervals.length<=1) return intervals;

            Arrays.sort(intervals, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });
            int p=intervals[0][0];
            int q=intervals[0][1];

            List<int[]> mergeInterval = new ArrayList<>();

            for(int i=0;i<intervals.length;i++){
                if(intervals[i][0]<=q)  //overlapping
                    q = intervals[i][1];
                else{
                    mergeInterval.add(new int[] {p,q});
                    p = intervals[i][0];
                    q = intervals[i][1];
                }
                if(i==intervals.length-1){
                    mergeInterval.add(new int[] {p,q});
                }
            }
            return mergeInterval.toArray(new int[mergeInterval.size()][2]);
        }
    }
}
