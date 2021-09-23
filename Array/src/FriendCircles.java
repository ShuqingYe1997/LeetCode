public class FriendCircles {
    class Solution {

        //有几个强连通
        public int findCircleNum(int[][] graph) {
            int n = graph.length;
            boolean[] visited = new boolean[n];
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    recursiveFind(graph, i, visited);
                    cnt++;
                }
            }
            return cnt;
        }

        public void recursiveFind(int[][] graph, int i, boolean[] visited) {
            int n = graph.length;
            for(int j = 0;j<n;j++){
                if(graph[i][j] == 1 && !visited[j]){
                    visited[j] = true;
                    recursiveFind(graph,j,visited);
                }
            }
        }
    }
}
