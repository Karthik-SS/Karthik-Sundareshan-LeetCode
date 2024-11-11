import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static String minWindowSubstring(String s, String t) {
        if (s.isEmpty() || t.isEmpty()) {
            return "";
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            int count1 = map.getOrDefault(t.charAt(i), 0);
            map.put(t.charAt(i), count1 + 1);
        }
        int required = map.size();
        int l = 0, r = 0, formed = 0;

        Map<Character, Integer> windowCounts = new HashMap<>();
        int[] ans = {-1, 0, 0};

        while (r < s.length()) {
            //s = "ADOBECDABC"
            char c = s.charAt(r);
            int count2 = windowCounts.getOrDefault(c, 0);
            windowCounts.put(c, count2 + 1);

            if (map.containsKey(c) && windowCounts.get(c) == map.get(c)) {
                formed++;
            }
            while (l <= r && formed == required) {
                c = s.charAt(l);
                if (ans[0] == -1 || r - l + 1 < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }
                windowCounts.put(c, windowCounts.get(c) - 1);
                if (map.containsKey(c) && windowCounts.get(c) < map.get(c)) {
                    formed--;
                }
                l++;
            }
            r++;
        }
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
    public static void main(String[] args) {
        String s = "ADOBECDABC";//"ADOBECODEBANC"; //DOBECODEBA
        String t = "ADC";
        String output = minWindowSubstring(s, t);
        System.out.println("Minimum Window Substring = " + output);

    }
}
