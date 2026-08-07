import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class PermutationInString {
//    @Test
//    public void test() {
//        String s1 = "ab";
//        String s2 = "eidbaooo";
//        Assert.assertTrue(checkInclusion(s1, s2));
//    }

    @Test
    public void test2() {
        String s1 = "ab";
        String s2 = "eidboaoo";
        Assert.assertFalse(checkInclusion(s1, s2));
    }

    public boolean checkInclusion(String s1, String s2) {
        int left = 0, right = 0, formed = 0;
        HashMap<Character, Integer> s1Map = new HashMap<>();
        HashMap<Character, Integer> s2Map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            s1Map.put(s1.charAt(i), s1Map.getOrDefault(s1.charAt(i), 0) + 1);
        }
        while (right < s2.length()) {
            char ch = s2.charAt(right);
            s2Map.put(ch, s2Map.getOrDefault(ch, 0) + 1);
            if (s1Map.containsKey(ch) && s1Map.get(ch).intValue() == s2Map.get(ch))
                formed++;
            while (formed == s1Map.size()) {
                if (s1Map.equals(s2Map)) return true;
                char leftChar = s2.charAt(left);
                s2Map.put(leftChar, s2Map.getOrDefault(leftChar, 0) - 1);
                if (s2Map.get(leftChar) == 0) s2Map.remove(leftChar);

                if(s1Map.containsKey(leftChar) && s2Map.getOrDefault(leftChar,0)< s1Map.get(leftChar))
                    formed--;
                left++;
            }
            right++;
        }
        return false;
    }
}
