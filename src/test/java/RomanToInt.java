import org.testng.annotations.Test;

import java.util.HashMap;

public class RomanToInt {

    @Test
    public void test() {
        String s = "MCMXCIV";
        int expectedOutput =  1994;
        romanToInt(s);
    }

    public int romanToInt(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        char[] chars = s.toCharArray();
        int sum = 0;
        sum = map.get(chars[0]);
        for(int i = 1; i < chars.length; i++) {
            if(map.get(chars[i - 1]) < map.get(chars[i])) {
                sum = sum + (map.get(chars[i]) - map.get(chars[i-1]));
            } else {
                sum = sum + map.get(chars[i]);
            }
        }
        System.out.println(sum);
        return sum;
    }
}
