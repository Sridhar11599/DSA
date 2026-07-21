import org.testng.Assert;
import org.testng.annotations.Test;


/*
Pseudo code:
1. Intialize a left pointer
2. Intialize maxLength to zero
3. Initialize the ascii char frequency array for 128chars;
3. Iterate the string and increment the ascii char freq values in ascii freq array
4. When there is a char frequency is greater 1 (duplicate char is present), move decrement the freq of character in
left index and increment the index
5. Compute the max length of the unique substring
 */

/*
Time compexity: o(n)
Space complexity: o(n)
 */
public class UniqueSubStringAssessment {

    @Test
    public void test1() {
        String s = "abcdefghiaaa";
        int expectedOutput = 9;
        Assert.assertEquals(lengthOfLongestSubstring(s),expectedOutput);
    }

    @Test
    public void test2() {
        String s = "sssss";
        int expectedOutput = 1;
        Assert.assertEquals(lengthOfLongestSubstring(s),expectedOutput);
    }

    @Test
    public void test3() {
        String s = "sssslot";
        int expectedOutput = 4;
        Assert.assertEquals(lengthOfLongestSubstring(s),expectedOutput);
    }

    @Test
    public void test4() {
        String s = "";
        int expectedOutput = -1;
        Assert.assertEquals(lengthOfLongestSubstring(s),expectedOutput);
    }


    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int[] charFreq = new int[128];
        int maxLength  = 0;
        if(s.length() == 0 || s == null)  return -1;
        for(int right = 0; right < s.length(); right++) {
            charFreq[s.charAt(right) - 'a']++;
            while(charFreq[s.charAt(right) - 'a'] > 1) {
                charFreq[s.charAt(left) - 'a']--;
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
