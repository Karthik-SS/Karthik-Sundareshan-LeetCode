
public class LongestRepeatingCharacterNaive {
    public static void main(String[] args) {
        String input = "ABC";//"RRLE";
        int k = 1, answer = 0;
        answer = characterReplacement(input, k);
        System.out.println("Answer = "+answer);
    }
    public static int characterReplacement(String s, int k) {
        int n = s.length();
        int maxLength = 0;
        int count = 0;
        for (int l = 0; l < n; l++) {
            // initialize a sliding window for each unique letter
            for (int m = l + 1; m < n; m++) {
                 for(int r = m + 1; r < n; r++){
                     if(s.charAt(m) == s.charAt(r)){
                         count++;
                     }
                 }
            }
        }
        return maxLength;
    }
}
