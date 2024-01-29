public class MergeSortedArrays {
    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        return nums1;
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 4, 0, 0};
        int[] nums2 = {1, 2};
        int m = 2, n = 2;
        nums1 = merge(nums1, m, nums2, n);

        for (int j = 0; j < nums1.length; j++) {
            System.out.print(nums1[j] + ", ");
        }
    }
}
