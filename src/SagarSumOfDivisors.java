public class SagarSumOfDivisors {
    /*
   SumOfDivisors(1) = 1
   SumOfDivisors(2) = 1 + 2 = 3 ------ > // 4
   SumOfDivisors(3) = 1 + 3 = 4 ------ > // 8
   SumOfDivisors(4) = 1 + 2 + 4 = 7 ------ > // 15
   SumOfDivisors(5) = 1 + 5 = 6 ------ > //21
   SumOfDivisors(6) = 1 + 2 + 3 + 6 = 12 ------ > // 33
   SumOfDivisors(7) = 1 + 7 = 8 ----> //41
   SumOfDivisors(8) = 1 + 2 + 4 + 8 = 15 ------> // 56
  */
    public static int sumOfAllDivisors(int n) {
        int ans = 0;
        int l = 1;
        while (l <= n) {
            int val = n / l;
            int r = n / val;
            ans += ((r * (r + 1)) / 2 - (l * (l - 1)) / 2) * val;
            l = r + 1;
            //l++;
        }
        return ans;
    }
    public static void main(String[] args) {
        int n = 20;
        System.out.println(sumOfAllDivisors(n));
/*        n = 5;
        System.out.println(sumOfAllDivisors(n));*/
    }
}
