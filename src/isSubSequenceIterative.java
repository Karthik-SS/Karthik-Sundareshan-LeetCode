public class isSubSequenceIterative {

    public static boolean isSubsequence(String s, String t) {
        int leftBound = Math.min(s.length(), t.length());
        int rightBound = Math.max(s.length(), t.length());

        int left = 0;
        int right = 0;

        while (left < leftBound || right < rightBound) {
            if (s.charAt(left) == t.charAt(right)) {
                left++;
            }
            right++;
        }
        return left == leftBound;
    }

    public static void main(String[] args) {
        String s = "abc"; //abc
        String t = "ahbgdc"; //ahbgdc
        boolean answer = false;
        answer = isSubsequence(s, t);
        System.out.println("Answer = " + answer);
    }
}
