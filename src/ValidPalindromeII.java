public class ValidPalindromeII {
    public static boolean isPalindrome(String s) {
        //boolean skipped = false;
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            // Found a mismatched pair - try both deletions
            if (s.charAt(i) != s.charAt(j)) {
                return (checkPalindrome(s, i, j - 1) || checkPalindrome(s, i + 1, j));
            }
            i++;
            j--;
        }
        return true;
    }

    public static boolean checkPalindrome(String s, int p1, int p2) {
        while (p1 < p2) {
            if (s.charAt(p1) != s.charAt(p2)) {
                return false;
            }
            p1++;
            p2--;
        }
        return true;
    }
    public static void main(String[] args) {
        String str = "madame"; //"tebbem"; "madame"
        //int n = str.length();
        boolean answer = isPalindrome(str);
        System.out.println("Answer = " + answer);
    }
}
