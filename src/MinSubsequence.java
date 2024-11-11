import java.util.ArrayList;
import java.util.List;

class MinSubsequence {
    public static String minWindow(String str1, String str2) {
        int str1L = str1.length();
        int str2L = str2.length();
        float length = Float.POSITIVE_INFINITY; //Float.POSITIVE_INFINITY ; Float.NEGATIVE_INFINITY
        int s1Indx = 0;
        int s2Indx = 0;
        int start = 0, end = 0;
        String minSubsequence = "";
        while (s1Indx < str1L) {
            if (str1.charAt(s1Indx) == str2.charAt(s2Indx)) {
                s2Indx++;
                if (s2Indx == str2L) {
                    start = s1Indx;
                    end = s1Indx;
                    s2Indx--;
                    while (s2Indx >= 0) {
                        if (str1.charAt(start) == str2.charAt(s2Indx)) {
                            s2Indx--;
                        }
                        start--;
                    }
                    start++;
                    if ((end - start + 1) < length) {
                        length = end - start + 1;
                        minSubsequence = str1.substring(start, end + 1);
                    }
                    s1Indx = start;
                    s2Indx = 0;
                }
            }
            s1Indx++;
        }
        return minSubsequence;
    }
    public static void main(String[] args) {
        // Driver code
/*        String[] str1 = {
                "abcdedeaqdweq", "fgrqsqsnodwmxzkzxwqegkndaa", "zxcvnhss", "alpha", "beta"
        };
        String[] str2 = {
                "adeq", "kzed", "css", "la", "ab"
        };*/
        String str1 = "axbcdeaceaxqlade";
        String str2 = "axe";
        String minSubsequence = minWindow(str1, str2);
        System.out.println("minSubsequence = "+minSubsequence);

    }
}