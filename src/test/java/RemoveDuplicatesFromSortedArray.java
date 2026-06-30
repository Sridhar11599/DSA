/*
Problem solving template

Given an integer array nums sorted in non-decreasing order,
remove the duplicates in-place such that each unique element appears only once.
The relative order of the elements should be kept the same.

 1. Did I understand the problem? yes

 What is the input(s)? - the input is array of integers in sorted order
 What is the expected output? - integer - repeated number
 Do I’ve constraints to solve the problem? - Yes
    - 1 <= nums.length <= 3 * 104
    -100 <= nums[i] <= 100
    nums is sorted in non-decreasing order.
 Do Ive all the information to go to the next steps - Yes
 How big is your test data set will be?

 2. Test data set
 Minimum  3 data set including positive, negative and edge
 Validate with the interviewer if the data set is fine by his/ her assumptions

 positive:
 Input: nums = [1,1,2]
Output: 2, nums = [1,2,_]
 negative: what if no duplicates
 [1,2,3,4] - o/p:
 edge case:

 3. Do I know to solve it? - Yes

 4. Ask for hint (if you don’t know how to solve this) - No
 5.  Do I know alternate solutions as well - No

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
Brute Force Approach:
1. Initialize an array of size same as given array
2. Iterate the entire given array and add all the elements into the new array without any duplicates
3. Count the elements in the array which are not zero
4. return the length of the array

Algorithm - Two pointers
1. Iterate the array push each integer into Map.
2. Check if that element is already present in the map
3. If present print the number and break
4. Else continue to iterate until end of array
 */


import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {

    @Test
    public void removeDuplicatesBruteForce() {
        int[] nums = {1,1,2};
        int expectedOutput = 2;
        Assert.assertEquals(removeDuplicatesFromSortedArrayBruteForce(nums),expectedOutput);
    }

    @Test
    public void removeDuplicatesBruteForceTests2() {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int expectedOutput = 5;
        Assert.assertEquals(removeDuplicatesFromSortedArrayBruteForce(nums),expectedOutput);
    }

    @Test
    public void removeDuplicatesOptimized() {
        int[] nums = {1,1,2};
        int expectedOutput = 2;
        Assert.assertEquals(removeDuplicatesOptimizedApproach(nums),expectedOutput);
    }

    @Test
    public void removeDuplicatesOptimizedTests2() {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int expectedOutput = 5;
        Assert.assertEquals(removeDuplicatesOptimizedApproach(nums),expectedOutput);
    }


    //O(N^2)
    public int removeDuplicatesFromSortedArrayBruteForce(int[] nums) {
        int[] result = new int[nums.length];
        int k = 0;
        for(int i = 0; i<nums.length; i++) {
            if(nums[i] != -1) {
                result[k++] = nums[i];
            }
            for(int j = 0; j < nums.length; j++) {
                if(i == j) continue;
                else if(nums[i] == nums[j]) nums[j] = -1;
            }
        }
        while(k < nums.length) {
            result[k++] = -1;
        }
        System.out.println("result array: "+ Arrays.toString(result));
        int count = 0;
        for(int i =0 ; i < result.length; i++) {
            if(result[i]!= -1) {
                count++;
            }
        }
        return count;
    }

    //O(N)
    public int removeDuplicatesOptimizedApproach(int[] nums) {
        int i = 0;
        for(int j = 1; j < nums.length; j++) {
            if(nums[i]!=nums[j]) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }
}
