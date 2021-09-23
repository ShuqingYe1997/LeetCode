public class Fibonacci {
    int[] Fibonacci;
    public char getChar(int n, int k){
        Fibonacci = new int[n];
        Fibonacci[0] = 1;
        Fibonacci[1] = 1;
        for(int i=2;i<n;i++)
            Fibonacci[i] = Fibonacci[i-1]+Fibonacci[i-2];
        return recursive(n,k);
    }

    public char recursive(int n,int k) {
        if (n > 1) {
            if (k - Fibonacci[n - 2] > 0)
                return recursive(n - 1, k - Fibonacci[n - 2]);
            else return recursive(n - 2, k);
        }
        else return n == 0 ? 'a' : 'b';
    }

}
