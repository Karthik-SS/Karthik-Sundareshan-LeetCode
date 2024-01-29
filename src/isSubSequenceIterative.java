public class isSubSequenceIterative {

    public static boolean isSubsequence(String s, String t) {
        int leftBound = s.length();
        int rightBound = t.length();
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
        String s = "abc";
        String t = "ahbgdc";
        boolean answer = false;
        answer = isSubsequence(s, t);
        System.out.println("Answer = " + answer);
    }
}
