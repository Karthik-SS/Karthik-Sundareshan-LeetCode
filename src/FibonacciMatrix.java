public class FibonacciMatrix {
    static int fib(int N) {
        if (N <= 1) {
            return N;
        }
        int[][] A = new int[][]{{1, 1}, {1, 0}};
        matrixPower(A, N - 1);

        return A[0][0];
    }

    static void matrixPower(int[][] A, int N) {
        if (N <= 1) {
            return;
        }
        matrixPower(A, N / 2);
        multiply(A, A);

        if (N % 2 != 0) {
            int[][] B = new int[][]{{1, 1}, {1, 0}};
            multiply(A, B);
        }
    }

    static void multiply(int[][] A, int[][] B) {
        int w = A[0][0] * B[0][0] + A[0][1] * B[1][0];
        int x = A[0][0] * B[0][1] + A[0][1] * B[1][1];
        int y = A[1][0] * B[0][0] + A[1][1] * B[1][0];
        int z = A[1][0] * B[0][1] + A[1][1] * B[1][1];

        A[0][0] = w;
        A[0][1] = x;
        A[1][0] = y;
        A[1][1] = z;
    }

    public static void main(String[] args) {
        int N = 5;
        int fibonacci = fib(N);
        //0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144
        //0, 1, 2, 3, 4, 5, 6,  7,  8,  9, 10, 11,  12
        System.out.println("Fibonacci = " + fibonacci);
    }
}
