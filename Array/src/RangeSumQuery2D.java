public class RangeSumQuery2D {
    class NumMatrix {
        int[][] matrix;
        int row,col;
        int[][] sums;

        public NumMatrix(int[][] matrix) {
            if (matrix.length > 0) {
                this.matrix = matrix;
                col = matrix[0].length;
                row = matrix.length;  //java真直接……
                sums = new int[row][col];
                for (int i = 0; i < row; i++) {
                    sums[i][0] = matrix[i][0];
                }
                for (int i = 0; i < row; i++) {
                    for (int j = 1; j < col; j++) {
                        sums[i][j] = sums[i][j - 1] + matrix[i][j];
                    }
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int sum=0;
            if(col1==0) {
                for (int i = row1; i <= row2; i++) {
                    sum += sums[i][col2];
                }
            }
            else{
                for (int i = row1; i <= row2; i++) {
                    sum += (sums[i][col2]-sums[i][col1-1]);
                }
            }
            return sum;
        }
    }
}
