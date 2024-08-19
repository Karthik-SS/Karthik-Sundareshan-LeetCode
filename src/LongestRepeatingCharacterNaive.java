public class LongestRepeatingCharacterNaive {
    public static void main(String[] args) {
        String input = "ABBCCCCMMMMXXXXXLLLLLLLL";//MMMMXXXXXLLLLLLLL";//"RRLE";
        int k = 4, answer = 0;
        answer = characterReplacement(input, k);
        System.out.println("Answer = " + answer);
    }

    public static int characterReplacement(String s, int k) {
        int n = s.length();
        int count = 0;
        int maxFreq = 0;
        for (int l = 0; l < n; l++) {
            // initialize a sliding window for each unique letter
            for (int m = l + 1; m < n; m++) {
                if (maxFreq == k) {
                    return maxFreq;
                }
                if (s.charAt(m) == s.charAt(l)) {
                    if (count == 0) {
                        count++;
                        count++;
                        l++;
                    } else {
                        count++;
                        l++;
                    }
                    if (count > maxFreq) {
                        maxFreq = count;
                    }
                } else {
                    if (maxFreq == 0) {
                        maxFreq = count;
                    }
                    count = 0;
                    l = m - 1;
                    break;
                }
            }
        }
        if (maxFreq == k) {
            return maxFreq;
        }
        return -1;
    }
}
