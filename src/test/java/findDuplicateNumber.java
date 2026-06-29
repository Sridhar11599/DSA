/*
Problem solving template

Given an integer array find the first duplicate number

 1. Did I understand the problem? yes

 What is the input(s)? - the input is array of integers
 What is the expected output? - integer - repeated number
 Do I’ve constraints to solve the problem? - Yes
    - There is only one repeated number in nums, return this repeated number.
    - You must solve the problem without modifying the array nums and using only constant extra space.
 Do Ive all the information to go to the next steps - Yes
 How big is your test data set will be? 1 <= n <= 105

 2. Test data set
 Minimum  3 data set including positive, negative and edge
 Validate with the interviewer if the data set is fine by his/ her assumptions

 positive:
 ['1','2','3','3','4'] o/p: 3
 negative: - requirement given as there is always one duplicate number
 [1,2,3,4] - o/p:
 [] - o/p:
 edge case:
 [3,3,3] o/p: 3
 retain the case sensitive

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
Brute Force Approach:
1. Pick each number in an array and Iterate the array fully to identify the duplicate number using two for loops
2. Skip if we encounter the number in same index as picked number
3. Break out of loop and return the duplicate number
4. If no duplicate is present return -1.

Algorithm - HashMap
1. Iterate the array push each integer into Map.
2. Check if that element is already present in the map
3. If present print the number and break
4. Else continue to iterate until end of array
 */


import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;


public class findDuplicateNumber {

    @Test
    public void findDuplicateNumberTestsUsingBruteForce() {
        int[] nums = {1,3,4,2,2};
        int expectedOutput = 2;
        Assert.assertEquals(findDuplicateBruteForce(nums),expectedOutput);
    }

    @Test
    public void findDuplicateNumberTestsUsingHashMap() {
        int[] nums = {3,1,3,4,2};
        int expectedOutput = 3;
        Assert.assertEquals(findDuplicateBruteForce(nums),expectedOutput);
    }

    @Test
    public void findDuplicateNumberTestsAllDuplicatesUsingHashMap() {
        int[] nums = {3,3,3,3,};
        int expectedOutput = 3;
        Assert.assertEquals(findDuplicateBruteForce(nums),expectedOutput);
    }

    //Time complexity: O(N^2)
    public int findDuplicateBruteForce(int[] nums) {
        for(int i = 0; i<nums.length; i++) {
            int num = nums[i];
            for(int j = 0; j < nums.length; j++) {
                if(i == j) continue;
                if(num == nums[j]) return num;
            }
        }
        return -1;
    }

    // Time Complexity: O(N)
    public int findDuplicateUsingHashMap(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
        for (int num : nums) {
            if (map.containsKey(num)) return num;
            map.getOrDefault(num, 0);
        }
        return -1;
    }
}
