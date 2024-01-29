public class Anagram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";

        boolean answer = isAnagram(s, t);
        System.out.println("Answer = " +answer);

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
