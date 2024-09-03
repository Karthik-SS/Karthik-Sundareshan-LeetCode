import java.util.PriorityQueue;

public class MaxUnitsInBoxes {
    /* ((a, b) -> Integer.compare(b[0], a[0]))
      0 = {int[2]@781} [5, 10]
      1 = {int[2]@784} [4, 7]
      2 = {int[2]@785} [3, 9]
      3 = {int[2]@783} [2, 5]
    * */
    /* ((a, b) -> Integer.compare(b[1], a[1]))
      0 = {int[2]@782} [5, 10]
      1 = {int[2]@785} [3, 9]
      2 = {int[2]@784} [4, 7]
      3 = {int[2]@783} [2, 5]
    * */
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
            if (truckSize - boxAndUnitCount[0] >= 0){
                totalMaxUnits += boxAndUnitCount[0] * boxAndUnitCount[1];
            }
            else{
                totalMaxUnits += truckSize * boxAndUnitCount[1];
            }
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