/*
Problem solving template

Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
You must implement a solution with a linear runtime complexity and use only constant extra space.

 1. Did I understand the problem? yes

 What is the input(s)? - the input is array of integers
 What is the expected output? - integer - element that appears only once
 Do I’ve constraints to solve the problem? - Yes
   - Each element in the array appears twice except for one element which appears only once
   - You must implement a solution with a linear runtime complexity and use only constant extra space.

 Do Ive all the information to go to the next steps - Yes
 How big is your test data set will be?

 2. Test data set
 Minimum  3 data set including positive, negative and edge
 Validate with the interviewer if the data set is fine by his/ her assumptions

 positive:
Input: x = [2,2,1] Output: 1

 negative:
 Input: x = [] Output: cannot be empty
 input: null o/p: cannot be null

 edge case:
 input = [1], o/p = [1]

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
1. Iterate over each element in a for loop
2. Initialize count = 0;
3. Within the loop run another loop to find the count of each element
4. If element count is greater than 1, continue
5. If element count is 1, print the number and break out of loop

Algorithm Hashmap
1. Declare a Hashmap
2. Iterate over each element is array and map the count of each element in hashmap
3. Iterate over hashMap and find count of element. If count is 1 return the key.

Optimized: xor operator
1. Apply exor for all the elements in array.
2. return the result
 */


import org.testng.Assert;
import org.testng.annotations.Test;

public class singleNumber {

    @Test
    public void findSingleNumberTestBruteForce() {
        int[] nums = {4,1,2,1,2};
        int expectedOutput = 4;
        Assert.assertEquals(findSingleNumberBruteForce(nums),expectedOutput);
    }

    @Test
    public void findSingleNumberTest2BruteForce() {
        int[] nums = {1};
        int expectedOutput = 1;
        Assert.assertEquals(findSingleNumberBruteForce(nums),expectedOutput);
    }

    @Test
    public void findSingleNumberTestOptimized() {
        int[] nums = {1};
        int expectedOutput = 1;
        Assert.assertEquals(findSingleNumberOptimized(nums),expectedOutput);
    }

    @Test
    public void findSingleNumberTest2Optimized() {
        int[] nums = {4,1,2,1,2};
        int expectedOutput = 4;
        Assert.assertEquals(findSingleNumberOptimized(nums),expectedOutput);
    }

    public int findSingleNumberBruteForce(int[] nums) {

        if(nums.length == 1) {
            return nums[0];
        }

        for(int i = 0; i<nums.length; i++) {
            int count = 1;
            for(int j = 0; j<nums.length; j++) {
                if(i == j) continue;
                if(nums[i] == nums[j]) {
                    count++;
                }
            }
            if(count == 1) {
                return nums[i];
            }
        }
        return -1;
    }

    public int findSingleNumberOptimized(int[] nums) {
        int result = nums[0];
        for(int i = 1; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }
}
