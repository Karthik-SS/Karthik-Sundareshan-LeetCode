public class FibonacciDynamicBottomUp {
    public static int fibonacci(int n){
        if(n == 0 || n == 1){
            return n;
        }
        int[] memo = new int[n + 1];
        memo[0] = 0;
        memo[1] = 1;

        for(int i = 2; i <= n; i++){
            memo[i] = memo[i -1] + memo[i - 2];
        }
        return memo[n];
    }

    public static void main(String[] args) {
        //0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144
        //0, 1, 2, 3, 4, 5, 6,  7,  8,  9, 10, 11,  12
        int n = 11;
        int answer = fibonacci(n);
        System.out.println("Answer = " +answer);
    }
}
