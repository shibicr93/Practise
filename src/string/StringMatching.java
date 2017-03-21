package string;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sramachandran on 3/21/17
 **/
public class StringMatching {

    private static Map<String,String> charNumMap = new HashMap<>();

    static {
        charNumMap.put("a", "0");
        charNumMap.put("b", "1");
        charNumMap.put("c", "2");
        charNumMap.put("d", "3");
        charNumMap.put("e", "4");
        charNumMap.put("f", "5");
        charNumMap.put("g", "6");
        charNumMap.put("h", "7");
        charNumMap.put("i", "8");
        charNumMap.put("j", "9");
        charNumMap.put("k", "10#");
        charNumMap.put("l", "11#");
        charNumMap.put("m", "12#");
        charNumMap.put("n", "13#");
        charNumMap.put("o", "14#");
        charNumMap.put("p", "15#");
        charNumMap.put("q", "16#");
        charNumMap.put("r", "17#");
        charNumMap.put("s", "18#");
        charNumMap.put("t", "19#");
        charNumMap.put("u", "20#");
        charNumMap.put("v", "21#");
        charNumMap.put("w", "22#");
        charNumMap.put("x", "23#");
        charNumMap.put("y", "24#");
        charNumMap.put("z", "25#");


    }

    static int[] frequency(String s) {
        for(char c : s.toCharArray()){

        }
        return null;
    }

    public static void main(String[] args) {

    }
}
