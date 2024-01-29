public class FibonacciVariables {
        public static int fib(int n) {
            if(n == 0 || n == 1){
                return n;
            }
            int a = 0, b = 1, c = 0;
            for(int i = 2; i <= n; i++){
                c = a + b;
                a = b;
                b = c;
            }
            return c;
        }

    public static void main(String[] args) {
        int n = 1;
        //0, 1, 1, 2, 3, 5, 8, 13, 21
        int fibonacci = fib(n);
        System.out.println("Fibonacci = " +fibonacci);

    }
}
