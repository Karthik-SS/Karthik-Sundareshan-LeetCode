public class IsSubSequenceRecursive {
    String source, target;
    Integer leftBound, rightBound;

    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        boolean answer = false;
        IsSubSequenceRecursive obj = new IsSubSequenceRecursive();
        answer = obj.isSubsequence(s, t);
        System.out.println("Answer = " + answer);
    }

    private boolean rec_isSubsequence(int leftIndex, int rightIndex) {
        // base cases
        if (leftIndex == leftBound)
            return true;
        if (rightIndex == rightBound)
            return false;

        boolean answer = false;

        // consume both strings or just the target string
        if (source.charAt(leftIndex) == target.charAt(rightIndex))
            ++leftIndex;
        ++rightIndex;

        answer = rec_isSubsequence(leftIndex, rightIndex);
        return answer;
    }

    public boolean isSubsequence(String s, String t) {
        this.source = s;
        this.target = t;
        this.leftBound = s.length();
        this.rightBound = t.length();

        return rec_isSubsequence(0, 0);
    }
}
