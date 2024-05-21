public class SumOf4Divisors {
    public static int sumFourDivisors(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            int tempSum = 0;
            int count = 0;
            for (int i = 2; i * i <= num && count <= 2; i++) {
                if (num % i == 0) {
                    if (i * i != num) {
                        tempSum += i + (num / i);
                        count += 2;
                    } else {
                        tempSum += i;
                        count++;
                    }
                }
            }
            if (count == 2) {
                tempSum += 1 + num;
                sum += tempSum;
            }
        }
        return sum;
    }

    // Driver code
    public static void main(String[] args) {
        int[] arr1 = {21, 4, 7};
        System.out.println(sumFourDivisors(arr1));
        int[] arr2 = {21, 21};
        System.out.println(sumFourDivisors(arr2));
    }
}
