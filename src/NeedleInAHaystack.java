public class NeedleInAHaystack {
 public static int findNeedleInHaystack(String hayStack, String needle){
     int m = hayStack.length();
     int n = needle.length();

     for(int windostart = 0; windostart <= m - n; windostart++){
         for(int i = 0; i < n; i++){
             if(needle.charAt(i) != hayStack.charAt(windostart + i)){
                 break;
             }
             if(i == n - 1){
                 return windostart;
             }
         }
     }
     return -1;
 }

    public static void main(String[] args) {
        String hayStack = "sonofthesun";
        String needle = "sun";
        int output = findNeedleInHaystack(hayStack, needle);
        System.out.println("Output = " +output);
    }
}
