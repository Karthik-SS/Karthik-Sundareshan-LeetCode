import java.util.*;

class RepeatedDNA {
    public static Set<String> findRepeatedSequences(String s, int k) {
        int n = s.length();
        if (n < k) {
            return new HashSet<String>();
        }
        Map<Character, Integer> mapping = new HashMap<>();
        mapping.put('A', 1);
        mapping.put('C', 2);
        mapping.put('G', 3);
        mapping.put('T', 4);
/*        mapping.put('A', 1);mapping.put('B', 2);mapping.put('C', 3);mapping.put('D', 4);mapping.put('E', 5);mapping.put('F', 6);
        mapping.put('G', 7);mapping.put('H', 8);mapping.put('I', 9);mapping.put('J', 10);mapping.put('K', 11);mapping.put('L', 12);
        mapping.put('M', 13);mapping.put('N', 14);mapping.put('O', 15);mapping.put('P', 16);mapping.put('Q', 17);mapping.put('R', 18);
        mapping.put('S', 19);mapping.put('T', 20);mapping.put('U', 21);mapping.put('V', 22);mapping.put('W', 23);
        mapping.put('X', 24);mapping.put('Y', 25);mapping.put('Z', 26);*/

        int base = 4;
        List<Integer> numbers = new ArrayList<>(Arrays.asList(new Integer[n]));
        Arrays.fill(numbers.toArray(), 0);
        for (int i = 0; i < n; i++) {
            numbers.set(i, mapping.get(s.charAt(i)));
        }
        int hashValue = 0;
        Set<Integer> hashSet = new HashSet<>();
        Set<String> output = new HashSet<>();
        for (int i = 0; i < n - k + 1; i++) {
            if (i == 0) {
                for (int j = 0; j < k; j++) {
                    hashValue += numbers.get(j) * (int) Math.pow(base, k - j - 1);
                }
            } else {
                int previousHashValue = hashValue;
                hashValue = (((previousHashValue - numbers.get(i - 1) * (int) Math.pow(base, k - 1)) * base) + numbers.get(i - 1 + k));
            }
            if (hashSet.contains(hashValue)) {
                output.add(s.substring(i, i + k));
            }
            hashSet.add(hashValue);
        }
        return output;
    }
    public static void main(String[] args) {
       /* List<String> inputsString = Arrays.asList("ACGT", "AGACCTAGAC", "AAAAACCCCCAAAAACCCCCC",
                "GGGGGGGGGGGGGGGGGGGGGGGGG", "TTTTTCCCCCCCTTTTTTCCCCCCCTTTTTTT", "TTTTTGGGTTTTCCA",
                "AAAAAACCCCCCCAAAAAAAACCCCCCCTG", "ATATATATATATATAT"); "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        List<Integer> inputsK = Arrays.asList(3, 3, 8, 12, 10, 14, 10, 6);*/
        String input = "AGACCTAGAC";
        int k = 3;
        Set<String> output = new HashSet<>();
        output = findRepeatedSequences(input, k);
        Iterator<String> iterator = output.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next()+", ");
        }
    }
}