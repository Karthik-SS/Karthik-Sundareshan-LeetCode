
import java.util.PriorityQueue;

class Solution {
    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> Integer.compare(b[1],
                a[1]));
        int i = 0;
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
        int[][] boxTypes = new int[][]{{2, 2}, {1, 3}, {3, 1}};
        int answer = 0;
        answer = maximumUnits(boxTypes, 4);
        System.out.println("Answer = " + answer);
    }

}