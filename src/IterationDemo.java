// Java program to demonstrate iteration over
// Map using keySet() and values() methods

import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;

class IterationDemo {
    public static void main(String[] arg) {
        Map<String, String> gfg = new HashMap<String, String>();

        // enter name/url pair
        gfg.put("GFG", "geeksforgeeks.org");
        gfg.put("Practice", "practice.geeksforgeeks.org");
        gfg.put("Code", "code.geeksforgeeks.org");
        gfg.put("Quiz", "www.geeksforgeeks.org");

        // using keySet() for iteration over keys
        for (String name : gfg.keySet()) {
            System.out.println("key: " + name + " | value: " + gfg.get(name));
           // if(gfg.containsKey("Code"))
            //    System.out.println("Victory! Code Found. Mission Accomplished...");
        }
        System.out.println("----------------------------------------------");
        // using values() for iteration over values
        for (String url : gfg.values())
            System.out.println("value: " + url);
        System.out.println("----------------------------------------------");
        // using for-each loop for iteration over Map.entrySet()
        for (Map.Entry<String,String> entry : gfg.entrySet())
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());
        System.out.println("----------------------------------------------");
        // using iterators
        Iterator<Map.Entry<String, String>> itr = gfg.entrySet().iterator();
        while(itr.hasNext())
        {
            Map.Entry<String, String> entry = itr.next();
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());
        }


    }
}
