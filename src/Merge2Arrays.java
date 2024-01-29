public class Merge2Arrays {
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
        int[] nums1 = new int[] {4,0,0,0,0,0,};
        int[] nums2 = new int[] {1,2,3,5,6};
        nums1 = merge(nums1, 1, nums2, 5);

        for(int i = 0; i < nums1.length; i++){
            if(i + 1 == nums1.length){
                System.out.print(nums1[i]);
            }else{
                System.out.print(nums1[i]+ ",");
            }
        }
    }
}