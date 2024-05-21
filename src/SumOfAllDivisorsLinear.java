public class SumOfAllDivisorsLinear {
    /*
       SumOfDivisors(1) = 1
       SumOfDivisors(2) = 1 + 2 = 3 ------ > // 4
       SumOfDivisors(3) = 1 + 3 = 4 ------ > // 8
       SumOfDivisors(4) = 1 + 2 + 4 = 7 ------ > // 15
       SumOfDivisors(5) = 1 + 5 = 6 ------ > //21
       SumOfDivisors(6) = 1 + 2 + 3 + 6 = 12 ------ > // 33
   */
    static int divisorSum(int n) {
        if (n == 1)
            return 1;
        int sum = 0;
        for (int i = 1; i <= n; ++i) {
            sum += i * (n / i);
        }
        return sum;
    }

    // Driver code
    public static void main(String args[]) {
        int n = 4;
        System.out.println(divisorSum(n));
        n = 5;
        System.out.println(divisorSum(n));
    }
}
