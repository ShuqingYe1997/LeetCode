import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class UglyNumber {
    //又大又慢，哭辽
    class Solution0 {
        public int nthUglyNumber(int n) {
            Queue<Double> queue=new PriorityQueue<>();
            queue.add(1.0);
            int cnt=0;
            while(!queue.isEmpty()){
                double smallest = queue.remove();
                System.out.println((int)smallest);
                cnt++;
                if(cnt==n) return (int)smallest;
                if(!queue.contains(smallest*2))
                    queue.add(smallest*2);
                if(!queue.contains(smallest*3))
                    queue.add(smallest*3);
                if(!queue.contains(smallest*5))
                    queue.add(smallest*5);
            }
            return 0;
        }
    }

    //加个HashSet去重如何，毕竟queue的查找是线性的
    //额，稍微好一点，但还不够
    class Solution1 {
        public int nthUglyNumber(int n) {
            Queue<Double> queue=new PriorityQueue<>();
            Set<Double> set = new HashSet<>();
            queue.add(1.0);
            set.add(1.0);
            int cnt=0;
            int[] factors = {2,3,5};
            while(!queue.isEmpty()){
                double smallest = queue.remove();
                //System.out.println((int)smallest);
                cnt++;
                if(cnt==n) return (int)smallest;
                for(int i=0;i<factors.length;i++)
                    if(!set.contains(smallest*factors[i])) {
                    queue.add(smallest*factors[i]);
                    set.add(smallest*factors[i]);
                    }
            }
            return 0;
        }
    }

    //三指针法，真是个人才
    class Solution {
        public int nthUglyNumber(int n) {
            int[] idx = new int[3];  //idx[0] for 2, idx[1] for 3, idx[2] for 5
            // 使用三个指针idx[3]，告诉它们。比如，2应该乘以ugly[idx[0]]，即数组中的第idx[0]个值
            int[] uglyNumbers = new int[n];
            uglyNumbers[0] = 1;
            for (int i = 1; i < n; i++) {
                int a = 2 * uglyNumbers[idx[0]];
                int b = 3 * uglyNumbers[idx[1]];
                int c = 5 * uglyNumbers[idx[2]];
                int next = Math.min(a, Math.min(b, c));
                if (next == a) idx[0]++;
                if (next == b) idx[1]++;
                if (next == c) idx[2]++;
                uglyNumbers[i] = next;
            }
            return uglyNumbers[n - 1];
        }
    }
}
