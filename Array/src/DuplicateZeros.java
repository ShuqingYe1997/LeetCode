public class DuplicateZeros {
    //很省内存，但是太慢了！
    class Solution0 {
        public void duplicateZeros(int[] arr) {
            if (arr.length <= 1) return;

            int i;
            for(i=0;i<arr.length;){
                if(arr[i] == 0){
                    drag(arr,i+1);
                    i+=2;
                }
                else i++;
            }
        }
        public void drag(int[] arr ,int p){
            for(int i=arr.length-1;i>=p;i--)
                arr[i]=arr[i-1];
        }
    }

    class Solution{
        public void duplicateZeros(int[] arr) {
            if (arr.length <= 1) return;
            int[] s = new int[arr.length];
            for(int i=0, j=0 ;i<arr.length && j<s.length ;){
                    s[j++] = arr[i];
                if(arr[i]==0 && j<s.length)
                    s[j++] = arr[i];
                i++;
            }
            for(int i=0;i<arr.length;i++)
                arr[i] = s[i];
        }
    }
}
