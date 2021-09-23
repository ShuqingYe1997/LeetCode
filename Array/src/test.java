import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test {
    public static void main(String argv[]) {
        Integer[][] a = {{1, 2, 2, 1},
                {3, 1, 2},
                {1, 3, 2},
                {2, 4},
                {3, 1, 2},
                {1, 3, 1, 1}};
        Integer[][] b = {{1}, {1}, {1}};
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(b[0]));
        triangle.add(Arrays.asList(b[1]));
        triangle.add(Arrays.asList(b[2]));
//        triangle.add(Arrays.asList(a[3]));
//        triangle.add(Arrays.asList(a[4]));
//        triangle.add(Arrays.asList(a[5]));

        BrickWall brickWall = new BrickWall();
        BrickWall.Solution solution1 = brickWall.new Solution();

        System.out.println(solution1.leastBricks(triangle));
    }
}


