import java.util.*;

public class NumberOfMatchingSubSequence_2 {
    public static int numMatchingSubseq(String mainString, String[] words) {
        int matchingSubsequenceCount = 0;

        Map<Character, List<Integer>> charPositions =
                new HashMap<>();

        // Pre-process: store char indices in main string.
        for (int i = 0; i < mainString.length(); i++) {
            char currentChar = mainString.charAt(i);
            charPositions.computeIfAbsent(currentChar, k -> new ArrayList<>()).add(i);
        }

        for (String word : words) {
            int previousPosition = -1;
            boolean isSubsequence = true;

            for (char characterInWord : word.toCharArray()) {
                // Check if current char exists in main string.
                if (!charPositions.containsKey(characterInWord)) {
                    isSubsequence = false;
                    break;
                }

                List<Integer> positions = charPositions.get(characterInWord);
                int nextPosition = findNextPosition(positions, previousPosition);

                // Early exit: no valid positions found.
                if (nextPosition == -1) {
                    isSubsequence = false;
                    break;
                }

                previousPosition = nextPosition;
            }

            if (isSubsequence) {
                matchingSubsequenceCount++;
            }
        }

        return matchingSubsequenceCount;
    }

    private static int findNextPosition(List<Integer> positions, int previousPosition) {
        // Find the smallest position > previousPosition using binary search.
        int left = 0;
        int right = positions.size() - 1;
        int nextPosition = -1;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            // Narrow search range based on middle position.
            if (positions.get(middle) > previousPosition) {
                nextPosition = positions.get(middle);
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        // Return the next valid position (or -1 if none found).
        return nextPosition;
    }

    public static void main(String[] args) {
        String s = "abc";
        String [] words = {"a","b","abc"};

        int output = numMatchingSubseq(s, words);
        System.out.println("Number Of Matching Sub-Sequences = "+output);
    }
}
