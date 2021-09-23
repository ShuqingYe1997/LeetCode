import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class Fractal {
    public void Draw(int size) {
        String[][] res = recursive(size);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }

    public String[][] recursive(int size) {
        int n = (int) Math.pow(3, size - 1);
        String[][] matrix = new String[n][n];

        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++)
                matrix[i][j] = " ";

        if (size == 1) {
            matrix[0][0] = "X";
        } else if (size == 2) {
            matrix[0][0] = "X";
            matrix[0][2] = "X";
            matrix[1][1] = "X";
            matrix[2][0] = "X";
            matrix[2][2] = "X";
        } else {
            String[][] smallerMatrix = recursive(size - 1);
            int smallerN = n / 3;
            for (int i = 0; i < smallerN; i++) {
                for (int j = 0; j < smallerN; j++) {
                    matrix[i][j] = smallerMatrix[i][j];
                    matrix[i][j + 2 * smallerN] = smallerMatrix[i][j];
                    matrix[i + smallerN][j + smallerN] = smallerMatrix[i][j];
                    matrix[i + 2 * smallerN][j] = smallerMatrix[i][j];
                    matrix[i + 2 * smallerN][j + 2 * smallerN] = smallerMatrix[i][j];
                }
            }
        }
        return matrix;
    }
}
