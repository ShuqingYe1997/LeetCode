public class HeightChecker {
    class Solution {
        public int heightChecker(int[] heights) {
            int[] temp = new int[105];
            for(int i=0;i<heights.length;i++)
                temp[i] = heights[i];
            mergeSort(heights,0,heights.length-1);
            int cnt=0;
            for(int i=0;i<heights.length;i++)
                if(temp[i]!=heights[i])
                    cnt++;
            return cnt;
        }


        public void mergeSort(int[] s,int start, int end){
            if(start<end){
                int mid = (start+end)/2;
                mergeSort(s,start,mid);
                mergeSort(s,mid+1,end);
                merge(s,start,mid,end);
            }
        }
        public void merge(int[] s, int start, int mid, int end){
            int i = start, j = mid+1, k=0;
            int[]temp = new int[end-start+1];
            while(i<=mid && j<=end){
               if(s[i]<s[j]) temp[k++] = s[i++];
               else temp[k++] = s[j++];
            }
            if(i>mid){
                while(j<=end)
                    temp[k++] = s[j++];
            }
            else{
                while(i<=mid)
                    temp[k++] = s[i++];
            }
            for(int t = start, q=0; t<=end; t++,q++)
                s[t] = temp[q];
        }
    }
}
