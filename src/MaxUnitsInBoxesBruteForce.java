public class MaxUnitsInBoxesBruteForce {

    private static int maxUnitInBoxes(int[][] arr, int truckSize) {
        int unitCount = 0;
        while (truckSize > 0) {
            int maxUnitsIndex = findMaxUnitsIndex(arr);
/*            if (maxUnitsIndex == -1) {
                break;
            }*/
            int boxCount = Math.min(truckSize, arr[maxUnitsIndex][0]);
            unitCount += arr[maxUnitsIndex][1] * boxCount;
            truckSize -= boxCount;

            arr[maxUnitsIndex][1] = -1;
        }
        return unitCount;
    }

    private static int findMaxUnitsIndex(int[][] arr) {
        int maxUnitsIndex = -1;
        int maxUnits = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i][1] > maxUnits) {
                maxUnits = arr[i][1];
                maxUnitsIndex = i;
            }
        }
        return maxUnitsIndex;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 3}, {2, 2}, {3, 1}};
        int answer = maxUnitInBoxes(arr, 4);
        System.out.println("Maximum Units In The Truck = " + answer);
    }


}
