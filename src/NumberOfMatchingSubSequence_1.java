public class NumberOfMatchingSubSequence_1 {

    public static int numMatchingSubsequences(String mainString, String[] words) {
        int matchingSubsequenceCount = 0;

        for (String word : words) {
            if (isSubsequence(mainString, word)) {
                matchingSubsequenceCount++;
            }
        }

        return matchingSubsequenceCount;
    }

    private static boolean isSubsequence(String mainString, String word) {
        int mainStringIndex = 0;
        int wordIndex = 0;

        // Iterate while both strings still have characters to compare
        while (mainStringIndex < mainString.length() && wordIndex < word.length()) {
            // Found matching character in both strings
            if (mainString.charAt(mainStringIndex) == word.charAt(wordIndex)) {
                wordIndex++;
            }
            mainStringIndex++;
        }
        //If wordIndex reached the end of the word, all chars were found
        return wordIndex == word.length();
    }

    public static void main(String[] args) {
        String s = "abc";
        String [] words = {"a","b","abc"};

        int output = numMatchingSubsequences(s, words);
        System.out.println("Number Of Matching Sub-Sequences = "+output);
    }
}
