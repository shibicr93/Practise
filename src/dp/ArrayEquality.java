package dp;

import java.util.*;

/**
 * Created by sramachandran on 3/20/17
 **/
public class ArrayEquality {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        Map<Integer,Integer> freqMap = new HashMap();
        for(int i=0;i<n;i++) {
            int key = scanner.nextInt();
            if (!freqMap.containsKey(key)) {
                freqMap.put(key, 1);
            } else {
                int val = freqMap.get(key);
                val++;
                freqMap.put(key, val);
            }
        }

        Map.Entry<Integer,Integer> maxEntry = null;
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet())
        {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
            {
                maxEntry = entry;
            }
        }

        int maxKey = maxEntry.getKey();
        int tot_del = 0;
        for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()){
            if(entry.getKey() != maxKey){
                tot_del+=entry.getValue();
            }
        }
        System.out.println(tot_del);

    }

}
