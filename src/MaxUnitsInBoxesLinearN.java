import java.util.HashMap;
import java.util.Map;

public class MaxUnitsInBoxesLinearN {
    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        /*Map<Integer, Integer> map = new HashMap<>();
        for (int[] boxType : boxTypes) {
            //Units are the indices and values are the boxes
            map.put(boxType[0], boxType[1]);
        }

        for (int key : map.keySet()) {
            //Units are the indices and values are the boxes
            System.out.println("Key = " + key + "; Value = " + map.get(key));
        }

        for (int[] boxType : boxTypes) {
            //Units are the indices and values are the boxes
            box[boxType[1]] += boxType[0];
        }*/

/*        int boxesWithUnits = 0;
            int mid = left + (units - left) / 2;
            if (box[mid] == 0) {
                units = mid;
            } else if (box[mid] > 0) {
                int fitIn = Math.min(box[units], truckSize);
                boxesWithUnits += units * fitIn;
                truckSize -= fitIn;
                if (truckSize == 0) {
                    return boxesWithUnits;
                }
            }*/

        int[] box = new int[1001];
        for (int[] boxType : boxTypes) {
            //Units are the indices and values are the boxes
            box[boxType[1]] += boxType[0];
        }
        int boxesWithUnits = 0;
        for (int units = 1000; units > 0; --units) {
            //Units are the indices and values are the boxes
            if (box[units] > 0) {
                int fitIn = Math.min(box[units], truckSize);
                boxesWithUnits += units * fitIn;
                truckSize -= fitIn;
                if (truckSize == 0) {
                    return boxesWithUnits;
                }
            }
        }
        return boxesWithUnits;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 3}, {2, 2}, {3, 1}};
        int answer = maximumUnits(arr, 4);
        System.out.println("Maximum Units In The Truck = " + answer);
    }
}
