import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidSquare {
    class Solution {
        public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
            if(p1==null ||p2==null ||p3==null ||p4==null  ) return false;
            //不能有重叠点
            Set<int[]> set = new HashSet<>();
            int[][] p = new int[4][2];
            p[0] = p1;p[1] = p2;p[2] = p3;p[3] = p4;
            for(int i=0;i<4;i++)
                set.add(p[i]);
            if(set.size()<4) return false;

            int[] a = new int[2];
            int[] b = new int[2];
            int[] c = new int[2];
            int[] d = new int[2];

            a[0] = p1[0] - p2[0];
            a[1] = p1[1] - p2[1];

            b[0] = p1[0] - p3[0];
            b[1] = p1[1] - p3[1];

            c[0] = p1[0] - p4[0];
            c[1] = p1[1] - p4[1];

            if(isVertical(a,b)){
                d[0] = p2[0] - p3[0];
                d[1] = p2[1] - p3[1];
                return isVertical(c,d);
            }
            else {
                if(isVertical(a,c)){
                    d[0] = p2[0] - p4[0];
                    d[1] = p2[1] - p4[1];
                    return  isVertical(b,d);
                }
                else{
                    d[0] = p3[0] - p4[0];
                    d[1] = p3[1] - p4[1];
                    return isVertical(b,c) && isVertical(a,d);
                }
            }
        }

        public boolean isVertical(int[] a, int[] b){
            return (a[0]*b[0] + a[1]*b[1] == 0);
        }
    }
}
