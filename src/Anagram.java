import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Anagram {
    public static void main(String[] args) {
        //String s = "anagram"; --> ASCII.
        //String t = "nagaram"; --> ASCII.

        String s = "\\u0061\\u006e\\u0061\\u0067\\u0072\\u0061\\u006d\n"; //--> UNICODE.
                    // a       n      a      g      r      a      m

        String t = "\\u006e\\u0061\\u0067\\u0061\\u0072\\u0061\\u006d\n"; //--> UNICODE.
                    //  n      a      g      a      r      a      m

        //boolean answer = isAnagram(s, t);
        //System.out.println("Answer = " + answer);
        String sFormatted = decodeWithPlainJava(s);
        String tFormatted = decodeWithPlainJava(t);

        boolean answer2 = isAnagram2(sFormatted.trim(), tFormatted.trim());
        System.out.println("Answer2 = " + answer2);
    }

    public static String decodeWithPlainJava(String input) {
        Pattern pattern = Pattern.compile("\\\\u[0-9a-fA-F]{4}");
        Matcher matcher = pattern.matcher(input);

        StringBuilder decodedString = new StringBuilder();

        while (matcher.find()) {
            String unicodeSequence = matcher.group();
            char unicodeChar = (char) Integer.parseInt(unicodeSequence.substring(2), 16);
            matcher.appendReplacement(decodedString, Character.toString(unicodeChar));
        }

        //matcher.appendTail(decodedString);
        return decodedString.toString();
    }

    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            System.out.println("s.charAt(i) = " + s.charAt(i));
            /*if(Character.isLetter(s.charAt(i))){
                table[s.charAt(i) - 'a']++;
            }*/
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            /*if(Character.isLetter(s.charAt(i))){
                table[t.charAt(i) - 'a']--;
            }*/
            table[t.charAt(i) - 'a']--;
            /*if(Character.isLetter(s.charAt(i))){
                if (table[t.charAt(i) - 'a'] < 0) {
                    return false;
                }
            }*/
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        int countOdd = 0;
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int check = 0;

        //System.out.println(Character.getNumericValue('z'));
        //System.out.println(Character.getNumericValue('a'));

        for (char c : s.toCharArray()) {
            int y = Character.getNumericValue(c);
            int index = 0;
            //System.out.println(y);
            //System.out.println(a);
            //System.out.println(z);
            //System.out.println(y);
            if (a <= y && y <= z) {
                index = y - a;
            } else {
                index = -1;
                return false;
            }
            if (y != -1) {
                table[index]++;
            }
        }

        for (char d : t.toCharArray()) {
            int x = Character.getNumericValue(d);
            if (a <= x && x <= z) {
                check = x - a;
            } else {
                return false;
            }
            if (table[check] % 2 == 1) {
                countOdd++;
            }
            table[check]--;
            if (table[check] < 0) {
                return false;
            }
            if (table[check] % 2 == 0) {
                countOdd--;
            }
        }
        return countOdd == 0;
    }
}
