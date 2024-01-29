public class LeetCodeAnagram {
    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        int countOdd = 0;
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int check = 0;
        int index = 0;

        //System.out.println(Character.getNumericValue('z'));
        //System.out.println(Character.getNumericValue('a'));

        for (char c : s.toCharArray()) {
            int y = Character.getNumericValue(c);
            //System.out.println(y);
            //System.out.println(a);
            //System.out.println(z);
            //System.out.println(y);
            if (a <= y && y <= z) {
                index = y - a;
                table[index]++;
            } else {
                return false;
            }
        }

/*        for (int k = 0; k < table.length; k++) {
            System.out.println(table[k]);
        }*/

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
            if(table[check] < 0){
                return false;
            }
            if (table[check] % 2 == 0) {
                countOdd--;
            }
        }
        return countOdd == 0;
    }


    public static void main(String[] args) {
        String s = "mol";
        String t = "mob";
        System.out.println("a's Ascii value = " +('a' - 0));
        System.out.println("m's Ascii value = " +('m' - 0));
        System.out.println("o's Ascii value = " +('o' - 0));
        for (char x : s.toCharArray()) {
            System.out.println(x - 'a');
        }

        for (char y : t.toCharArray()) {
            System.out.println(y - 'a');
        }

        boolean answer = false;
        answer = isAnagram(s, t);
        System.out.println("Answer = " + answer);
    }
}