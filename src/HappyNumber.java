public class HappyNumber {
    public static int sumOfSquaredDigits(int number) {
        int totalSum = 0;
        while (number > 0) {
            int digit = number % 10;
            number = number / 10;
            totalSum += (digit * digit);//(Math.pow(digit, 2));
        }
        return totalSum;
    }
    public static boolean isHappyNumber(int n) {
        int slowPointer = n;
        int fastPointer = sumOfSquaredDigits(n);
        while (fastPointer != 1 && slowPointer != fastPointer) {
            slowPointer = sumOfSquaredDigits(slowPointer);
            fastPointer =  sumOfSquaredDigits(sumOfSquaredDigits(fastPointer));
        }
        return fastPointer == 1;
    }

    public static void main(String[] args) {
        int n = 9;//28; // 99,999,999
        boolean answer = isHappyNumber(n);
        System.out.println("Answer = "+answer);
    }
}
