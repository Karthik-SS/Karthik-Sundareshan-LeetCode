import java.util.PriorityQueue;

public class MaxUnitsInBoxes {
    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>((a, b) -> Integer.compare(b[1],
                a[1]));
        int i = 0;
        //int[][] test = new int[5][2];
        while (heap.size() < boxTypes.length) {
            heap.offer(boxTypes[i++]);
        }
        int[] boxAndUnitCount;
        int totalMaxUnits = 0;
        while (!heap.isEmpty() && truckSize > 0) {
            boxAndUnitCount = heap.poll();
            if (truckSize - boxAndUnitCount[0] >= 0)
                totalMaxUnits += boxAndUnitCount[0] * boxAndUnitCount[1];
            else
                totalMaxUnits += truckSize * boxAndUnitCount[1];
            truckSize -= boxAndUnitCount[0];
        }

        return totalMaxUnits;
    }

    public static void main(String[] args) {
        int[][] boxTypes = new int[][]{{5, 10}, {2, 5}, {4, 7}, {3, 9}};
        int answer = 0;
        answer = maximumUnits(boxTypes, 10);
        System.out.println("Answer = " + answer);
    }


}