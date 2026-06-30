/*
Problem solving template

You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer.
The digits are ordered from most significant to least significant in left-to-right order.
The large integer does not contain any leading 0's.

 1. Did I understand the problem? yes

 What is the input(s)? - the input is array of integers
 What is the expected output? - array of integers after increment(+ 1)
 Do I’ve constraints to solve the problem? - Yes
   1 <= digits.length <= 100
   0 <= digits[i] <= 9
   digits does not contain any leading 0's.
 Do Ive all the information to go to the next steps - Yes
 How big is your test data set will be?

 2. Test data set
 Minimum  3 data set including positive, negative and edge
 Validate with the interviewer if the data set is fine by his/ her assumptions

 positive:
 Input: x = [1,2,3] Output: [1,2,4]

 negative:
 Input: x = [] Output: ?

 edge case:
 input: x = [9,9,9], o/p: [1,0,0,0]

 3. Do I know to solve it? - Yes

 4. Ask for hint (if you don’t know how to solve this) - No
 5.  Do I know alternate solutions as well - Yes.
 Difference between sum of natural numbers and sum of elements in array

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

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

/*

Brute Force:

1. Iterate the array and concatenate the numbers
2. add + 1 to the number
3. Convert the integer back to array

Algorithm / Optimized approach:

1. Iterate the array from last index
2. Add + 1 to last number
3. if sum is less than 10 return the array digits
4. if sum is greater than 9, add the carry to prev sum
5. update the index in the array to reminder
6. Finally if the array goes beyond the given size (index = -1),
initialize an array with 1 in first index for array size n + 1
*/
public class PlusOne {

    @Test
    public void plusOneTestBruteForceTests() {
        int[] nums = {1,2,3};
        int[] expectedOutput = {1,2,4};
        Assert.assertEquals(PlusOneBruteFore(nums), expectedOutput);
    }

    @Test
    public void plusOneTestBruteForceTests2() {
        int[] nums = {9,9,9};
        int[] expectedOutput = {1,0,0,0};
        Assert.assertEquals(PlusOneBruteFore(nums), expectedOutput);
    }

    @Test
    public void plusOneTestOptimizedApproach() {
        int[] nums = {9,9,9};
        int[] expectedOutput = {1,0,0,0};
        Assert.assertEquals(optimizedPlusOne(nums), expectedOutput);
    }

    @Test
    public void plusOneTestOptimizedApproachTest2() {
        int[] nums = {1,2,3};
        int[] expectedOutput = {1,2,4};
        Assert.assertEquals(optimizedPlusOne(nums), expectedOutput);
    }

    //O(N)
    public int[] PlusOneBruteFore(int[] nums) {
        int sum = 0;
        for(int i = 0; i<nums.length; i++) {
            sum = (sum * 10)+ nums[i];
        }
        int plusOneNum = sum + 1;
        int countDigits = plusOneNum;

        int count = 0;
        while(countDigits != 0) {
            count ++;
            countDigits = countDigits / 10;
        }
        int[] finalPlusOneArray = new int[count];
        int k = count-1;
//        System.out.println("plusOne numebr: "+plusOneNum);
        while(plusOneNum != 0) {
            finalPlusOneArray[k--] = plusOneNum % 10;
//            System.out.println("reminder: "+plusOneNum % 10);
            plusOneNum = plusOneNum / 10;
//            System.out.println("quotient: "+plusOneNum / 10);
        }

//        System.out.println(Arrays.toString(finalPlusOneArray));
        return finalPlusOneArray;
    }

    // O(N)
    public int[] optimizedPlusOne(int[] nums) {
        int carry = 1;
        int i = 0;
        for(i = nums.length - 1; i>=0; i--) {
            int sum = 0;
            sum = nums[i] + carry;
            if(sum < 10) {
                nums[i] = sum;
                return nums;
            }
            nums[i] = sum % 10;
            carry = sum / 10;
        }

        if(i == -1) {
            int[] finalPlusOneArray = new int[nums.length + 1];
            finalPlusOneArray[0] = 1;
            System.out.println("final plus one array: "+Arrays.toString(finalPlusOneArray));
            return  finalPlusOneArray;
        }
        System.out.println("nums array: "+Arrays.toString(nums));

        return new int [] {};
    }
}
