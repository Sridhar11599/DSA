/*
Problem solving template

The majority element is the element that appears more than ⌊n / 2⌋ times.
You may assume that the majority element always exists in the array.

 1. Did I understand the problem? yes

 What is the input(s)? - the input is array of integers
 What is the expected output? - integer - majority element is the element that appears more than ⌊n / 2⌋ times
 Do I’ve constraints to solve the problem? - Yes
   n == nums.length
   1 <= n <= 5 * 104
   -109 <= nums[i] <= 109
   The input is generated such that a majority element will exist in the array.
 Do Ive all the information to go to the next steps - Yes
 How big is your test data set will be?

 2. Test data set
 Minimum  3 data set including positive, negative and edge
 Validate with the interviewer if the data set is fine by his/ her assumptions

 positive:
 Input: x = [3,2,3] Output: 3

 negative: none. input will not be empty as provided in constraint

 edge case:
 input x = [2,2,1,1,1,2,2] o/p: 2

 3. Do I know to solve it? - Yes

 4. Ask for hint (if you don’t know how to solve this) - No
 5.  Do I know alternate solutions as well - Yes.
 Using HashMap and count logic

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
1. Compute the value of n/2 of an array of size n;
2. Run two loops and count the number of times element is present in the array.
3. Return the element when the element count is greater than n/2 times

Algorithm: HashMap
1. Map elements and set default to zero
2. check if the count is greater than n/2
3. Increase the count of mapped element when encountered again.
 */

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class MajorityElement {

    @Test
    public void findMajorityElementTestBruteForce() {
        int[] nums = {2,2,1,1,1,2,2};
        int expectedOutput = 2;
        Assert.assertEquals(findMajorityElementBruteForce(nums),expectedOutput);
    }

    @Test
    public void findMajorityElementTest2BruteForce() {
        int[] nums = {3,2,3};
        int expectedOutput = 3;
        Assert.assertEquals(findMajorityElementBruteForce(nums),expectedOutput);
    }

    @Test
    public void findMajorityElementTestHashMap() {
        int[] nums = {2,2,1,1,1,2,2};
        int expectedOutput = 2;
        Assert.assertEquals(findMajorityElementHashMap(nums),expectedOutput);
    }

    public int findMajorityElementBruteForce(int[] nums) {

        int maxRange = nums.length / 2;

        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int count = 1;
            for(int j = 0; j < nums.length; j++) {
                if(i == j) continue;
                if(num == nums[j]) {
                    count ++;
                }
            }
            if(count > maxRange) {
                return nums[i];
            }
        }

        return -1;
    }

    public  int findMajorityElementHashMap(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i<nums.length; i++) {
            map.put(nums[i],(map.getOrDefault(nums[i],0)+1));
            if(map.get(nums[i]) > nums.length/2) {
                System.out.println(map);
                return nums[i];
            }
        }
        System.out.println(map);
        return -1;
    }

}
