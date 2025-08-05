public class ReverseWordsInAString {
    private static String outPut = "";
    private static void strRev(char[] str, int startIndx, int endIndx) {
        while (startIndx < endIndx) {
            char temp = str[startIndx];
            str[startIndx] = str[endIndx];
            str[endIndx] = temp;
            startIndx++;
            endIndx--;
        }
    }
    public static String reverseWords(String sentence) {
        sentence = sentence.trim().replaceAll("\\s+", " ");

        char[] charArray = sentence.toCharArray();
        int strLen = charArray.length - 1;

        strRev(charArray, 0, strLen);

        for (int start = 0, end = 0; end <= strLen; ++end) {
            if (end == strLen || charArray[end] == ' ') {
                int endIdx = (end == strLen) ? end : end - 1;
                strRev(charArray, start, endIdx);
                start = end + 1;
            }
        }
        return new String(charArray);
    }

    public static void main(String[] args) {
        String str = "  A   String   With   Multiple     Spaces    ";
        outPut = reverseWords(str);
        System.out.println("/************OutPut***********/");
        System.out.println(outPut);
    }

/*    @Override
    public String toString() {
        return outPut;
    }*/
}
