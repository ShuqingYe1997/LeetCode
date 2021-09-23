import java.util.*;

public class CourseSchedule {

    //topological graph

    //你看看这是什么垃圾拓扑
    class Solution0 {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            int[] inDegree = new int[numCourses];
            int[] visited = new int[numCourses];
            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i < numCourses; i++)
                graph.add(i, new ArrayList<>());

            for (int i = 0; i < prerequisites.length; i++) {
                graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
                inDegree[prerequisites[i][1]]++;
            }

            int cnt = 0;
            while (true) {
                int starter = -1;
                for (int i = 0; i < inDegree.length; i++) {
                    if (inDegree[i] == 0 && visited[i]==0) {
                        starter = i;
                        break;
                    }
                }
                if (starter == -1) return false;  //没有starter

                if(++cnt==numCourses) return true;
                List<Integer> list = graph.get(starter);
                visited[starter]=1;
                graph.remove(list);
                for (int i = 0; i < list.size(); i++) {
                    inDegree[list.get(i)]--;
                }
            }
        }
    }

    class Solution{
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            int[] inDegree = new int[numCourses];
            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i < numCourses; i++)
                graph.add(i, new ArrayList<>());

            for (int i = 0; i < prerequisites.length; i++) {
                graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
                inDegree[prerequisites[i][1]]++;
            }

            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < inDegree.length; i++) {
                if (inDegree[i] == 0) {
                    queue.add(i);
                }
            }
            int cnt=0;
            while (!queue.isEmpty()){
                List<Integer> nbr = graph.get(queue.poll());
                cnt++;
                for(int i=0;i<nbr.size();i++){
                    inDegree[nbr.get(i)]--;
                    if (inDegree[nbr.get(i)] == 0) {
                        queue.add(nbr.get(i));
                    }
                }
            }
            if(cnt==numCourses)return true;
            return false;
        }

        public int[] findOrder(int numCourses, int[][] prerequisites) {
            int[] inDegree = new int[numCourses];
            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i < numCourses; i++)
                graph.add(i, new ArrayList<>());

            for (int i = 0; i < prerequisites.length; i++) {
                graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
                inDegree[prerequisites[i][1]]++;
            }

            Queue<Integer> queue = new LinkedList<>();
            int[] path = new int[numCourses]; int p=0;
            for (int i = 0; i < inDegree.length; i++) {
                if (inDegree[i] == 0) {
                    queue.add(i);
                }
            }
            int cnt=0;
            while (!queue.isEmpty()){
                int a = queue.poll();
                List<Integer> nbr = graph.get(a);
                cnt++;
                path[p++] = a;
                for(int i=0;i<nbr.size();i++){
                    inDegree[nbr.get(i)]--;
                    if (inDegree[nbr.get(i)] == 0) {
                        queue.add(nbr.get(i));
                    }
                }
            }
            if(cnt==numCourses)return path;
            return new int[0];
        }
    }
}
