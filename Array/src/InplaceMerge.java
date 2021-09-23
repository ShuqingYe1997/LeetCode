public class InplaceMerge {
    class Solution {
        public void merge(int num1[], int m, int num2[], int n) {
            if (num1.length < n) return;
            int i = 0, j = 0;
            while (i < m && j < n) {
                if (num1[i] <= num2[j])
                    i++;
                else {
                    for (int k = m; k > i; k--)
                        num1[k] = num1[k - 1];
                    num1[i] = num2[j];
                    j++;
                    m++;  //排好序的数组尾部往后移一位
                }
            }
            while (j < n)
                num1[i++] = num2[j++];
        }

        public void merge1(int[] num, int start, int mid, int end){
            int i = start;
            int j = mid+1;
            while (i<=mid && j<=end){
                if(num[i] < num[j])
                    i++;
                else {
                    int temp = num[j];
                    for (int k = mid + 1; k > i; k--)
                        num[k] = num[k - 1];
                    num[i] = temp;
                    mid++;i++;j++;
                }
            }
        }
    }
}

