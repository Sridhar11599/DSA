/*
Problem solving template

Given an array nums containing n distinct numbers in the range [0, n],
return the only number in the range that is missing from the array.

 1. Did I understand the problem? yes

 What is the input(s)? - the input is array of integers
 What is the expected output? - integer - missing number from array
 Do I’ve constraints to solve the problem? - Yes
    n == nums.length
    1 <= n <= 104
    0 <= nums[i] <= n
    All the numbers of nums are unique.
 Do Ive all the information to go to the next steps - Yes
 How big is your test data set will be?

 2. Test data set
 Minimum  3 data set including positive, negative and edge
 Validate with the interviewer if the data set is fine by his/ her assumptions

 positive:
 Input: x = [0,2,3] Output: 1

 negative:
 Input: x = [] Output: ?

 edge case: None

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

/*
Pseudo code:
1. Run a for loop for array length + 1 times
2. Pick each number and check if that number if present in the given array
3. If the number is present continue the loop until we find the missing number
4. If the missing number is found return the number

Algorithm: Sum of Natural Numbers
1. Calculate the sum of elements in array
2. Calculate sum of natural number where n is length of the given array
3. Compute the difference between sum of natural number and sum of elements in array which gives the missing number
 */


import org.testng.Assert;
import org.testng.annotations.Test;

public class MissingNumber {

    @Test
    public void findMissingNumberTest1() {
        int[] nums = {3,0,1};
        int expectedOutput = 2;
        Assert.assertEquals(findMissingNumberBruteForce(nums),expectedOutput);
    }

    @Test
    public void findMissingNumberTest2() {
        int[] nums = {0,1};
        int expectedOutput = 2;
        Assert.assertEquals(findMissingNumberBruteForce(nums),expectedOutput);
    }

    @Test
    public void findMissingNumberTest3() {
        int[] nums = {9,6,4,2,3,5,7,0,1};
        int expectedOutput = 8;
        Assert.assertEquals(findMissingNumberBruteForce(nums),expectedOutput);
    }

    @Test
    public void findMissingNumberTests1Algo() {
        int[] nums = {9,6,4,2,3,5,7,0,1};
        int expectedOutput = 8;
        Assert.assertEquals(findMissingNumberAlgoApproach(nums),expectedOutput);
    }

    @Test
    public void findMissingNumberTestExorOperator1() {
        int[] nums = {0,1,3};
        int expectedOutput = 2;
        Assert.assertEquals(findMissingNumberExorOperator(nums),expectedOutput);
    }

    @Test
    public void findMissingNumberTestExorOperator2() {
        int[] nums = {9,6,4,2,3,5,7,0,1};
        int expectedOutput = 8;
        Assert.assertEquals(findMissingNumberExorOperator(nums),expectedOutput);
    }


    //O(N^2)
    public int findMissingNumberBruteForce(int[] nums) {

        for(int i = 0; i<=nums.length; i++) {
            boolean flag = false;
            for(int j = 0; j<nums.length; j++) {
                if(i == nums[j]) {
                    flag = true;
                    break;
                }
            }
            if(!flag) return i;
        }

        return -1;
    }

    public int findMissingNumberAlgoApproach(int[] nums) {
        int n = nums.length;
        int sumOfNaturalNumbers = n*(n+1)/2;
        int sumOfGivenArray = 0;
        for(int i = 0; i<nums.length; i++) {
            sumOfGivenArray = sumOfGivenArray + nums[i];
        }

        return sumOfNaturalNumbers - sumOfGivenArray;
    }

    // O(N)
    public  int findMissingNumberExorOperator(int[] nums) {
        int missingNumber = 0;
        for(int i = 0; i<=nums.length; i++) {
            missingNumber = missingNumber ^ i;
        }
        for(int i = 0; i<nums.length; i++) {
            missingNumber = missingNumber ^ nums[i];
        }
        return missingNumber;
    }
}
