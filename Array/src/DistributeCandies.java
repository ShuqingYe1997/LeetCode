public class DistributeCandies {
    class Solution {
        public int[] distributeCandies(int candies, int num_people) {
            int[] result = new int[num_people];
            int cnt = 0;
            int n = 0;
            while(candies > 0 ){
                if(++n < candies) {
                    candies -= n;
                    result[cnt%num_people] += n;
                }
                else {
                    result[cnt%num_people] += candies;
                    candies = 0;
                }
                cnt++;
            }
            return result;
        }
    }
}
