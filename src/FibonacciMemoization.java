public class FibonacciMemoization {
    public static int fibonacci(int n){
        int[] memo = new int[n + 1];
        return fibonacci(n, memo);
    }

    public static int fibonacci(int n, int[] memo) {
        if(n == 0 || n == 1){
            return n;
        }
      if(memo[n] == 0){
         memo[n] = fibonacci(n - 1, memo) + fibonacci(n - 2, memo);
      }

      return memo[n];
    }

    public static void main(String[] args) {
        //0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144
        //0, 1, 2, 3, 4, 5, 6,  7,  8,  9, 10, 11,  12
        int n = 8;
        int answer = fibonacci(n);
        System.out.println("Answer = " +answer);
    }
}
