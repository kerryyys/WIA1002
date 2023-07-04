package py2020;
import java.util.*;
public class Q4 {
    public static void main(String[] args){
        Q4HashMap hashMap = new Q4HashMap();
        System.out.println("New directory entry: ");
        hashMap.put("BruceW", "011-8998990");
        hashMap.put("DeanW", "017-2274000");
        hashMap.put("TonyS", "019-4550800");
        hashMap.put("LaraC", "014-6402009");
        System.out.println("");
        
        System.out.println("Get directory: ");
        Entry e1 = hashMap.get("DeanW");
        System.out.println("DeanW: " + e1.getValue());
        Entry e2 = hashMap.get("BruceW");
        System.out.println("BruceW: " + e2.getValue());
        System.out.println("");
        
        System.out.println("Updated directory: ");
        hashMap.put("BruceW", "011-5677900");
        hashMap.put("JeanG", "019-9001123");
        
        Entry e3 = hashMap.get("BruceW");
        System.out.println("BruceW: " + e3.getValue());
        Entry e4 = hashMap.get("JeanG");
        System.out.println("JeanG: "+ e4.getValue());
    }
}
