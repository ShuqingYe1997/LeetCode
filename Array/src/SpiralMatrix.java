import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    class Solution {
        List<Integer> visitedList = new ArrayList<>();
        int[][] direction = {{0,1},{1,0},{0,-1},{-1,0}};

        public List<Integer> spiralOrder(int[][] matrix) {
            int m = matrix.length;
            if(m<=0) return visitedList;
            int n = matrix[0].length;
            int left = 0, right = n-1, top=0, bottom = m-1;

            //嗯，还是逐行/列输出比较好，符合人性
            while (true){
                for(int j=left;j<=right;j++)
                    visitedList.add(matrix[top][j]);
                if(++top>bottom) break;

                for(int i=top;i<=bottom;i++)
                    visitedList.add(matrix[i][right]);
                if(--right<left) break;

                for(int j=right;j>=left;j--)
                    visitedList.add(matrix[bottom][j]);
                if(--bottom<top) break;

                for(int i=bottom;i>=top;i--)
                    visitedList.add(matrix[i][left]);
                if(++left>right) break;
            }
            return visitedList;
        }

        public void visit(int[][]matrix, int h_start,int h_end, int v_start, int v_end){
            int i= h_start;int j = v_start;
            //单独处理1×1
            if(h_start==h_end && v_start==v_end)
                visitedList.add(matrix[i][j]);
            else{
                while (j<h_end) {
                    visitedList.add(matrix[i][j]);
                    i+=direction[0][0];
                    j+=direction[0][1];
                }
                while (i<v_end) {
                    visitedList.add(matrix[i][j]);
                    i+=direction[1][0];
                    j+=direction[1][1];
                }
                while (j>h_start) {
                    visitedList.add(matrix[i][j]);
                    i+=direction[2][0];
                    j+=direction[2][1];
                }
                while (i>v_start) {
                    visitedList.add(matrix[i][j]);
                    i+=direction[3][0];
                    j+=direction[3][1];
                }
            }
        }
    }
}
