class MinSubsequence {
    public static String minWindow(String str1, String str2) {
        int sizeStr1 = str1.length();
        int sizeStr2 = str2.length();
        float length = Float.POSITIVE_INFINITY;
        int indexS1 = 0;
        int indexS2 = 0;
        int start = 0, end = 0;
        String minSubsequence = "";
        while (indexS1 < sizeStr1) {
            if (str1.charAt(indexS1) == str2.charAt(indexS2)) {
                indexS2 += 1;
                if (indexS2 == sizeStr2) {
                    start = indexS1;
                    end = indexS1;
                    indexS2 -= 1;
                    while (indexS2 >= 0) {
                        if (str1.charAt(start) == str2.charAt(indexS2)) {
                            indexS2 -= 1;
                        }
                        start -= 1;
                    }
                    start += 1;
                    if ((end - start + 1) < length) {
                        length = end - start + 1;
                        minSubsequence = str1.substring(start, end + 1);
                    }
                    indexS1 = start;
                    indexS2 = 0;
                }
            }
            indexS1 += 1;
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
        String str1 = "adeqcdedeaqdweq";
        String str2 = "adeq";
        String minSubsequence = minWindow(str1, str2);
        System.out.println("minSubsequence = "+minSubsequence);

    }
}