import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    static boolean is_palindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }
        return true;
    }

    static void generate_palindromic_decompositions_util(ArrayList<String> decompositions_container, String s,
                                                         int pos, String cur_decomposition) {
        int n = s.length();
        // If we have reached the end, add the string.
        if (pos == n) {
            decompositions_container.add(cur_decomposition);
            return;
        }
        // Try to add s[pos, i] if it a palindrome.
        for (int i = pos; i < n; i++) {
            if (is_palindrome(s, pos, i)) {
                if (pos == 0) {
                    // We are adding s[0, i] so do not put '|' before it.
                    generate_palindromic_decompositions_util(decompositions_container, s, i + 1,
                            s.substring(pos, i + 1));
                } else {
                    generate_palindromic_decompositions_util(decompositions_container, s, i + 1,
                            cur_decomposition + "|" + s.substring(pos, i + 1));
                }
            }
        }
    }

    static ArrayList<String> generate_palindromic_decompositions(String s) {
        ArrayList<String> decompositions_container = new ArrayList<>();
        generate_palindromic_decompositions_util(decompositions_container, s, 0, "");
        return decompositions_container;
    }

    public static void main(String[] args) {
        String input = "abaa";
        List<String> output = new ArrayList<>();
        output = generate_palindromic_decompositions(input);

        for (int i = 0; i < output.size(); i++) {
            System.out.print(output.get(i) + ", ");
        }
    }
}
