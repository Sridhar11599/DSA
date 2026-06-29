/*
Problem solving template

Given a signed 32-bit integer x, return x with its digits reversed.
If reversing x causes the value to go outside the signed 32-bit integer range [-2^31, 2^31 - 1], then return 0.

 1. Did I understand the problem? yes

 What is the input(s)? - the input is integer
 What is the expected output? - reversed integer
 Do I’ve constraints to solve the problem? - Yes
    => -231 <= x <= 231 - 1
 Do Ive all the information to go to the next steps - Yes
 How big is your test data set will be?

 2. Test data set
 Minimum  3 data set including positive, negative and edge
 Validate with the interviewer if the data set is fine by his/ her assumptions

 positive:
Input: x = 123 Output: 321

 negative:
 Input: x = -123 Output: -321
 [] - o/p:

 edge case:
 Input: x = 120 Output: 21

 3. Do I know to solve it? - Yes

 4. Ask for hint (if you don’t know how to solve this) - No
 5.  Do I know alternate solutions as well
 Yes. HashMap

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
Pseudo code:
1. Loop until the number is not equal to zero
2. Every time add reminder to the result by multiplying the existing result with 10
3. reassign the number with quotient - dividing the number 10
 */


import org.testng.Assert;
import org.testng.annotations.Test;

public class ReverseInteger {

    @Test
    public void test1() {
        int x = 123;
        int expectedOutput = 321;
        Assert.assertEquals(reverse(x),expectedOutput);
    }

    //Time complexity: O(n)
    public int reverse(int x) {
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        int result = 0;
        while(x != 0) {
             if (result < Integer.MIN_VALUE / 10 || result > Integer.MAX_VALUE / 10) {
                 return 0;
             }
            int rem = x % 10;
            result = result * 10 + rem;
            x = x/10;
        }
        return result;
    }
}
