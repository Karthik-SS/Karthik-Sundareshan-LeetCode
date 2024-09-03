public class LongestCommonPrefix {
    public static String longestCommonPrefixVertical(String[] strs) {
        if (strs == null || strs.length == 0){
            return "";
        }
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }
    public static String longestCommonPrefixHorizontal(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                //System.out.println(strs[i].indexOf(prefix));
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
    public static void main(String[] args) {
        String[] input = new String[]{"flower", "flow", "flight"};
        //String[] input = new String[]{"flow", "flow", "flow"};
        String output = longestCommonPrefixHorizontal(input);
        System.out.println("Horizontal Output = " + output);
        String output2 = longestCommonPrefixVertical(input);
        System.out.println("Vertical Output = "+ output2);
    }

}
