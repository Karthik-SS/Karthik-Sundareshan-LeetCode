import java.io.*;
public class SumOfAllDivisors {
    // JAVA program to find sum of all
// divisor of number up to 'n'
    /*
    SumOfDivisors(1) = 1
    SumOfDivisors(2) = 2 + 1 = 3 ------ > // 4
    SumOfDivisors(3) = 3 + 1 = 4 ------ > // 8
    SumOfDivisors(4) = 4 + 2 + 1 = 7 ------ > // 15
    SumOfDivisors(5) = 5 + 1 = 6 ------ > //21
    SumOfDivisors(6) = 6 + 3 + 2 + 1 = 12 ------ > // 33
     */
        // Utility function to find sum of
        // all divisor of number up to 'n'
        static int divisorSum(int n)
        {
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                // Find all divisors of i
                // and add them
                for (int j = 1; j * j <= i; j++) {
                    if (i % j == 0) {
                        if (i / j == j)
                            sum += j;
                        else
                            sum += j + i / j;
                    }
                }
            }
            return sum;
        }

        // Driver code
        public static void main(String args[])
        {
            int n = 4;
            System.out.println(divisorSum(n));
            n = 5;
            System.out.println(divisorSum(n));
        }
    }
