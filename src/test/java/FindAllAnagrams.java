/*
Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.



Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
 */

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class FindAllAnagrams {

    @Test
    public void test() {
        String s = "abab";
        String p = "ab";
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        Assert.assertEquals(findAllAnagramsInString(s,p),list);

    }

    public ArrayList<Integer> findAllAnagramsInString(String s, String p) {

        ArrayList<Integer> list = new ArrayList<>();
        if(s.length() < p.length()) {
            return list;
        }

        int[] pAsciiTable = new int[128];
        int[] sAsciiTable = new int[128];

        for(int i = 0; i < p.length(); i++) {
            pAsciiTable[p.charAt(i) -'a']++;
        }

        Arrays.toString(pAsciiTable);

        int pLength = p.length();
        int sLength = s.length();

        for(int i = 0; i < pLength - 1; i++) {
            sAsciiTable[s.charAt(i) - 'a']++;
        }

        for(int i = pLength - 1; i < s.length(); i++) {
            sAsciiTable[s.charAt(i) - 'a']++;
            if(Arrays.equals(pAsciiTable,sAsciiTable)) {
                list.add(i - pLength + 1);
            }
            sAsciiTable[s.charAt(i - pLength + 1) - 'a']--;
        }
        System.out.println(list);
        return list;
    }

}
