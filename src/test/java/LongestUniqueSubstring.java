import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class LongestUniqueSubstring {

    @Test
    public void longestSubstringTest() {
        String s = "abcabcbb";
        int expectedOutput = 3;
        Assert.assertEquals(lengthOfLongestSubstring(s),expectedOutput);
    }

    @Test
    public void longestSubstringTest1() {
        String s = "bbbbb";
        int expectedOutput = 1;
        Assert.assertEquals(lengthOfLongestSubstring(s),expectedOutput);
    }

    @Test
    public void longestSubstringTest2() {
        String s = "pwwkew";
        int expectedOutput = 3;
        Assert.assertEquals(lengthOfLongestSubstring(s),expectedOutput);
    }

    public boolean isUniqueString(String str) {
        char[] chars = str.toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0; i<chars.length; i++) {
            map.put(chars[i], map.getOrDefault(chars[i],0)+1);
        }

        for(Map.Entry<Character,Integer> entry :map.entrySet()) {
            if(entry.getValue() > 1) return false;
        }
        return true;
    }
    public int lengthOfLongestSubstring(String s) {
        int[] charFrequency = new int[128];
        int i = 0;
        // int j =0;
        int maxLength = Integer.MIN_VALUE;
        while(i < s.length()) {
            int j = i;
            while(j < s.length()) {
                String str = s.substring(i,j);
//                System.out.println("substring: "+str);
                if(isUniqueString(str)) {
                    System.out.println("uniq substr: "+str);
                    maxLength = Math.max(maxLength, str.length());
                }
                j++;
            }
            i++;
        }
        return maxLength;
    }

    public int lengthOfSubstringOptimized(String s) {
        int[] charFrequency = new int[128];
        int l = 0;
        int r = 0;
        int maxLength  = 0;
        while(r < s.length() ) {
            char c = s.charAt(r);
            charFrequency[c]++;
            while(charFrequency[c] > 1) {
                charFrequency[s.charAt(l)]--;
                l++;
            }

            maxLength = Math.max(maxLength, r-l+1);
        }
        return maxLength;
    }
}
