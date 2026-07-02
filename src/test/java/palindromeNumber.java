/*
Problem solving template

Given an integer x, return true if x is a palindrome, and false otherwise.

 1. Did I understand the problem? yes

 What is the input(s)? - integer
 What is the expected output? - boolean. True if palindrome else false
 Do I’ve constraints to solve the problem? - Yes

 Do Ive all the information to go to the next steps - Yes
 How big is your test data set will be?

 2. Test data set
 Minimum  3 data set including positive, negative and edge
 Validate with the interviewer if the data set is fine by his/ her assumptions

 positive:
Input: x = 121 Output: true

 negative:
 input: null o/p: cannot be null
 input: x = 124 o/p: false


 edge case:
 input = -121 o/p: false (121-)
 input = 10 o/p: false (01)

 3. Do I know to solve it? - Yes

 4. Ask for hint (if you don’t know how to solve this) - No
 5.  Do I know alternate solutions as well
 Yes. Swap using two pointers

 Simple technique brute force

 6. If you know the alternate solution find out the O-notations (performance)
 7. Then, explain either both are the best (depends on the time)
 Approach 1:- start with the worst-> improve (optimize) ->  End up with the best
 Approach 2: Write down the options and benefits and code the best
 8. Start always with the Pseudo code (explain the pseudo code to the interviewer with some test data)
 -write the code
 9. Test against different test data
 10. If it fails then debug to solve it
 11. Optimize the code and remove unnecessary code*/

/*
Approach:
1. Initialize reverse = 0;
2. Loop until the element is not equal to zero
3. get the reminder of the element
4. multiply reverse variable by 10 and add it with reminder
5. return true if reverse number is equal to given number else return false
*/

import org.testng.Assert;
import org.testng.annotations.Test;

public class palindromeNumber {

    @Test
    public void checkPalindromeTest() {
        int num = 121;
        boolean expectedOutput = true;
        Assert.assertEquals(isPalindrome(num), expectedOutput);
    }

    @Test
    public void checkPalindromeTest2() {
        int num = -121;
        boolean expectedOutput = false;
        Assert.assertEquals(isPalindrome(num), expectedOutput);
    }

    @Test
    public void checkPalindromeTest3() {
        int num = 10;
        boolean expectedOutput = false;
        Assert.assertEquals(isPalindrome(num), expectedOutput);
    }



    public boolean isPalindrome(int num) {
        if(num < 0) return false;
        int temp = num;
        int rev = 0;
        while(temp!=0) {
            int rem = temp%10;
            rev = (rev*10) + rem;
            temp = temp/10;
        }
        while(rev == num) return true;
        return false;
    }
}
